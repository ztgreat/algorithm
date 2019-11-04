package com.github.ztgreat.dp.leetcode_322;


class Solution2 {

    // 背包思想
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
        // dp[i] 表示 金额 为i ,需要的最少硬币
        // dp[i] = dp[i-coins[i]]+1;
        int[] dp = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && dp[i - coins[j]] + 1 >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];

    }
}