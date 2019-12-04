package com.github.ztgreat.dp.leetcode_377;


import java.util.Arrays;

/**
 * 尝试用dfs 来做
 * 普通dfs 会超时
 */
class Solution {

    private int ans;

    public int combinationSum4(int[] nums, int target) {

        ans = 0;
        Arrays.sort(nums);
        dfs(nums, target, 0);
        return ans;

    }

    public void dfs(int[] nums, int target, int current) {

        if (current == target) {
            ans++;
            return;
        }
        for (int i = 0; i < nums.length; i++) {

            if (current + nums[i] <= target) {
                dfs(nums, target, current + nums[i]);
            } else {
                return;
            }
        }

    }
}