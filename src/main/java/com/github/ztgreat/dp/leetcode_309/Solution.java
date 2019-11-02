package com.github.ztgreat.dp.leetcode_309;


class Solution {

    public int maxProfit(int[] prices) {

        int n = prices.length;
        if(n==0){
            return 0;
        }

        // dp[i][0] 表示 第 i 天 手里 没有股票 时的最大收益
        // dp[i][1] 表示 第 i 天 手里 有股票 时的最大收益
        // 显然 手里 没有 股票 时  收益 应该才是 最大的
        int[][] dp = new int[n][2];
        dp[0][1]=-prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            if (i - 2 >= 0) {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
            } else {
                dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            }
        }
        return dp[n-1][0];
    }
}