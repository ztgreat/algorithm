package com.github.ztgreat.dp.leetcode_1049;


class Solution {

    //转换成01背包问题，求两堆石头的最小差值。由于石头总和为sum.则问题转换成了
    //背包最多装sum / 2的石头,stones数组里有一大堆石头。求如何装能装下最多重量石头。
    public int lastStoneWeightII(int[] stones) {

        if (stones == null || stones.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int[][] dp = new int[stones.length][sum / 2 + 1];
        for (int i = stones[0]; i <= sum / 2; i++) {
            dp[0][i] = stones[0];
        }
        for (int i = 1; i < stones.length; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                if (j < stones[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - stones[i]] + stones[i]);
                }
            }
        }
        return Math.abs((sum - dp[stones.length - 1][sum / 2]) - dp[stones.length - 1][sum / 2]);
    }

}