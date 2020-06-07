package com.github.ztgreat.dp.leetcode_416;


/**
 * 0,1背包 二维数组版
 */
class Solution3 {

    public boolean canPartition(int[] nums) {

        if (nums == null || nums.length == 0) {
            return true;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if ((sum & 1) != 0) {
            return false;
        }
        int targetSum = sum / 2;

        // dp[i][j] 前i个元素是否可以组成和为j
        int max = Math.max(targetSum, nums[0]);
        boolean[][] dp = new boolean[nums.length][max + 1];
        dp[0][nums[0]] = true;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j <= targetSum; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] | dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[nums.length - 1][targetSum];

    }


}