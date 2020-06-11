package com.github.ztgreat.dp.leetcode_416;


import java.util.Arrays;

/**
 * 剪枝dfs
 */
class Solution2 {

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
        // 排序
        Arrays.sort(nums);

        boolean[] vis = new boolean[nums.length];

        return dfs(0, nums, 0, tartgetSum, vis);

    }

    public boolean dfs(int index, int[] nums, int currentSum, int targetSum, boolean[] vis) {

        if (index == nums.length) {
            return false;
        }
        if (currentSum == targetSum) {
            return true;
        }
        if (currentSum > targetSum) {
            return false;
        }
        for (int i = index; i < nums.length; i++) {

            // 剪枝1，去掉重复数据的尝试
            if (i >= 1 && nums[i] == nums[i - 1] && vis[i - 1] == false) {
                continue;
            }

            //还可以剪枝2，如果后面的元素全部加起来 都还比targetSum 小，那么也不尝试了
            //这个用一个数组，记录前缀和就可以了，这里没有做

            vis[i] = true;
            if (dfs(i + 1, nums, currentSum + nums[i], targetSum, vis)) {
                return true;
            }
            vis[i] = false;
        }
        return false;
    }

}