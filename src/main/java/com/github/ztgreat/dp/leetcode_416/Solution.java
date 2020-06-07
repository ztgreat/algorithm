package com.github.ztgreat.dp.leetcode_416;


/**
 * 暴力 dfs
 * 肯定会超时
 */
class Solution {

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
        int tartgetSum = sum / 2;
        return dfs(0, nums, 0, tartgetSum);

    }

    public boolean dfs(int index, int[] nums, int currentSum, int targetSum) {

        if (currentSum == targetSum) {
            return true;
        }
        if (index == nums.length) {
            return false;
        }
        if (currentSum > targetSum) {
            return false;
        }
        for (int i = index; i < nums.length; i++) {
            if (dfs(i + 1, nums, currentSum + nums[i], targetSum)) {
                return true;
            }
        }
        return false;
    }

}