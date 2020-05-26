package com.github.ztgreat.array.leetcode_560;


class Solution {

    public int subarraySum(int[] nums, int k) {

        if (nums == null) {
            return 0;
        }
        int[] dp = new int[nums.length + 1];
        dp[1] = nums[0];
        int cnt = 0;
        if (dp[1] == k) {
            cnt++;
        }
        for (int i = 1; i < nums.length; i++) {
            dp[i + 1] = dp[i] + nums[i];

            for (int j = 0; j <= i; j++) {
                if (dp[i + 1] - dp[j] == k) {
                    cnt++;
                }
            }
        }
        return cnt;

    }


}