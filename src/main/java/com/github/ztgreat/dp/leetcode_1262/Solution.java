package com.github.ztgreat.dp.leetcode_1262;


class Solution {

    public int maxSumDivThree(int[] nums) {


        // dp[i][j] 表示 前i 个数 模3 余j 的最大和
        //dp[i][j] = dp[i - 1][j], dp[i - 1][x] + nums[i];
        //(x +[nums[i]])%3 = j;

        // 下面是逆推的过程,也可以正推优化， dp[i - 1][j] + nums[i]  -> dp[i][(j+nums[i])%3]

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[][] dp = new int[nums.length + 1][3];
        dp[1][nums[0] % 3] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                for (int x = 0; x < 3; x++) {
                    if ((nums[i - 1] + dp[i - 1][x]) % 3 == j) {
                        dp[i][j] = Math.max(dp[i][j], dp[i - 1][x] + nums[i - 1]);
                        break;
                    }
                }
            }
        }
        return dp[nums.length][0];
    }
}