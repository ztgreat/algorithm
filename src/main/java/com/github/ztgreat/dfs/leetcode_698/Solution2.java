package com.github.ztgreat.dfs.leetcode_698;


import java.util.Arrays;


class Solution2 {

    /**
     * 先算出子集的和是多少，并抽象成k个桶，每个桶的值是子集的和。
     * 然后尝试所有不同的组合（即放数到桶中），如果存在一种组合可以使每个桶都正好放下，
     * 那么返回可以。如果不存在，返回不可以。
     */
    private boolean ans;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % k != 0) {
            return false;
        }
        sum = sum / k;
        Arrays.sort(nums);
        if (nums[nums.length - 1] > sum) {
            return false;
        }
        int[] arr = new int[k];
        boolean[] visit = new boolean[nums.length];
        ans = false;
        dfs(nums, visit, 0, arr, k, sum);
        return ans;
    }
    void dfs(int[] nums, boolean[] visit, int cur, int[] arr, int k, int targetSum) {
        if (cur == nums.length) {
            ans = true;
        }
        for (int i = 0; i < k; i++) {
            if (ans) {
                return;
            }
            if (visit[cur]) {
                continue;
            }
            // 这里主要需要剪枝，不然过不了
            ////如果正好能放下当前的数或者放下当前的数后，还有机会继续放 还没有放进桶中的最小的元素
            if (arr[i] + nums[cur] == targetSum || targetSum - arr[i] - nums[cur] >= nums[getOption(nums.length, visit)]) {
                visit[cur] = true;
                arr[i] += nums[cur];
                dfs(nums, visit, cur + 1, arr, k, targetSum);
                arr[i] -= nums[cur];
                visit[cur] = false;
            }
        }
    }
    int getOption(int numsSize, boolean[] visit) {
        int i;
        for (i = 0; i < numsSize; i++) {
            if (!visit[i]) {
                break;
            }
        }
        return i;
    }
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5};
        System.out.println(new Solution2().canPartitionKSubsets(a, 12));
    }
}