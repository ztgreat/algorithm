package com.github.ztgreat.dfs.leetcode_473;


class Solution {

    long edge;

    public boolean makesquare(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        edge = sum / 4;
        if (edge * 4 != sum) {
            return false;
        }
        long[] edges = new long[4];
        return dfs(0, edges, nums);
    }

    public boolean dfs(int index, long[] edges, int[] nums) {

        if (index == nums.length) {
            return edges[0] == edges[1] && edges[1] == edges[2] && edges[2] == edges[3];
        }
        for (int i = 0; i < 4; i++) {
            if (edges[i] + nums[index] <= edge) {
                edges[i] += nums[index];
                if (dfs(index + 1, edges, nums)) {
                    return true;
                }
                edges[i] -= nums[index];
            }
        }
        return false;
    }



}