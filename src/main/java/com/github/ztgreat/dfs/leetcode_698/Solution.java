package com.github.ztgreat.dfs.leetcode_698;


import java.util.Arrays;


class Solution {

    boolean ans;

    // 超时了
    public boolean canPartitionKSubsets(int[] nums, int k) {

        int sum = 0;
        ans = false;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        Arrays.sort(nums);
        // 子集的和
        int partSum = sum / k;
        boolean[] visit = new boolean[20];
        dfs(nums, visit, k, 0, 0, partSum);
        return ans;

    }

    void dfs(int[] nums, boolean[] visit, int k, int curIndex, int currentSum, int targetSum) {

        if (curIndex == k) {
            ans = true;
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (ans) {
                return;
            }
            if (!visit[i]) {
                visit[i] = true;
                int temp = currentSum + nums[i];
                if (temp == targetSum) {
                    dfs(nums, visit, k, curIndex + 1, 0, targetSum);
                } else if (temp < targetSum) {
                    dfs(nums, visit, k, curIndex, temp, targetSum);
                } else {
                    visit[i] = false;
                    continue;
                }
                visit[i] = false;
            }

        }

    }

    public static void main(String[] args) {
        int[] a = {4, 5, 3, 2, 5, 5, 5, 1, 5, 5, 5, 5, 5, 5, 5, 5};
        System.out.println(new Solution().canPartitionKSubsets(a, 14));
    }
}