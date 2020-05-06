package com.github.ztgreat.dp.leetcode_322;


class Solution {
    public int coinChange(int[] coins, int amount) {

        if (amount == 0) {
            return 0;
        }
        if (coins.length == 1) {
            if (amount % coins[0] == 0) {
                return amount / coins[0];
            }
            return -1;
        }
        //dp[i][j] 表示  前 j 个 硬币 拼成 i 所需要的最少的硬币
        // dp[i][j]= min(dp[i][j-1],dp[i-coins[j]][j]+1)  && dp[i-coins[j]][j] 可以拼成
        int[][] dp = new int[amount + 1][coins.length];

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                // 表示 没法拼成
                dp[i][j] = Integer.MAX_VALUE;
                if (j == 0) {
                    if (i >= coins[j]) {
                        if (dp[i - coins[j]][j] != Integer.MAX_VALUE) {
                            dp[i][j] = dp[i - coins[j]][j] + 1;
                        }
                    }
                } else {

                    if (i >= coins[j]) {
                        if (dp[i - coins[j]][j] != Integer.MAX_VALUE) {
                            dp[i][j] = Math.min(dp[i][j - 1], dp[i - coins[j]][j] + 1);
                        } else {
                            dp[i][j] = dp[i][j - 1];
                        }
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                }
            }


        }
        return dp[amount][coins.length - 1] == Integer.MAX_VALUE ? -1 : dp[amount][coins.length - 1];


    }
}