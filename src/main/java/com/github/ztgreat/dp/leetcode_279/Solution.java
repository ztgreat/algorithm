package com.github.ztgreat.dp.leetcode_279;


class Solution {
    public int numSquares(int n) {

        //动态规划思想

        //dp[i] = dp[j]+1   i-j 是完全平方数
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}