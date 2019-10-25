package com.github.ztgreat.dp.leetcode_494;


class Solution {


    private int ans;

    // 暴力 dfs
    public int findTargetSumWays(int[] nums, int S) {

        ans = 0;
        dfs(nums, 0, 0, S);
        return ans;
    }

    public void dfs(int[] nums, int i, int current, int s) {

        if (current == s && i == nums.length) {
            ans++;
            return;
        }
        if (i == nums.length) {
            return;
        }
        dfs(nums, i + 1, current + nums[i], s);
        dfs(nums, i + 1, current - nums[i], s);
    }



}