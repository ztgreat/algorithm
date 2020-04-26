package com.github.ztgreat.dp.leetcode_152;

/**
 * 这题是求数组中子区间的最大乘积，对于乘法，我们需要注意，负数乘以负数，会变成正数，所以解这题的时候我们需要维护两个变量，当前的最大值，以及最小值，最小值可能为负数，但没准下一步乘以一个负数，当前的最大值就变成最小值，而最小值则变成最大值了。
 * <p>
 * 我们的动态方程可能这样：
 * <p>
 * maxDP[i + 1] = max(maxDP[i] * A[i + 1], A[i + 1],minDP[i] * A[i + 1])
 * minDP[i + 1] = min(minDP[i] * A[i + 1], A[i + 1],maxDP[i] * A[i + 1])
 * dp[i + 1] = max(dp[i], maxDP[i + 1])
 * <p>
 */
class Solution2 {

    public int maxProduct(int[] nums) {


        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] maxdp = new int[nums.length];
        int[] mindp = new int[nums.length];

        int result = nums[0];
        maxdp[0] = nums[0];
        mindp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {

            maxdp[i] = Math.max(Math.max(maxdp[i - 1] * nums[i], nums[i]), mindp[i - 1] * nums[1]);
            mindp[i] = Math.min(Math.min(mindp[i - 1] * nums[i], nums[i]), maxdp[i - 1] * nums[1]);
            result = Math.max(result, maxdp[i]);
        }
        return result;

    }
}