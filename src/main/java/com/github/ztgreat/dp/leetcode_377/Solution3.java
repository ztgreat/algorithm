package com.github.ztgreat.dp.leetcode_377;


import java.util.Arrays;

/**
 * 记忆化dfs
 */
class Solution3 {

    public int combinationSum4(int[] nums, int target) {

        int[] arr = new int[target + 1];
        Arrays.fill(arr, -1);
        // 排个序，可以优化
        Arrays.sort(nums);
        return dfs(nums, arr, target);
    }

    public int dfs(int[] nums, int[] arr, int target) {

        if (arr[target] != -1) {
            return arr[target];
        }
        if (target == 0) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target >= nums[i]) {
                result += dfs(nums, arr, target - nums[i]);
            } else {
                break;
            }

        }
        return arr[target] = result;
    }
}