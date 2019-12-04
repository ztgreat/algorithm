package com.github.ztgreat.dp.leetcode_377;


import java.util.Arrays;

/**
 * dp
 */
class Solution3 {

    public int combinationSum4(int[] nums, int target) {

        if (target == 0) {
            return 1;
        }
        // dp[i] += dp[i-nums[j]];
        int[] dp = new int[target + 1];
        Arrays.sort(nums);
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] <= i) {
                    dp[i] += dp[i - nums[j]];
                } else {
                    break;
                }
            }
        }
        return dp[target];
    }

}