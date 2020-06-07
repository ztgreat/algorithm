package com.github.ztgreat.dp.leetcode_416;


/**
 * 0,1背包 一维数组版
 */
class Solution4 {

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

        boolean[] dp = new boolean[targetSum + 1];
        if(nums[0]<=targetSum){
            dp[nums[0]] = true;
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = targetSum; j >= nums[i]; j--) {
                dp[j] = dp[j] | dp[j - nums[i]];
            }
        }
        return dp[targetSum];

    }


}