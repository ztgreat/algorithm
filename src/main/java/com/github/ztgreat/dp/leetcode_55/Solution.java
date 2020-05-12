package com.github.ztgreat.dp.leetcode_55;


/**
 * dp 解法
 * dp[i] = dp[j]  && dp[j] 能到达 && nums[j] >= i - j
 */
class Solution {

    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums[0] == 0 && nums.length == 1) {
            return true;
        }
        boolean[] dp = new boolean[nums.length];
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && nums[j] >= i - j) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[nums.length - 1];

    }
}