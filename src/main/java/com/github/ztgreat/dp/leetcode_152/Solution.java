package com.github.ztgreat.dp.leetcode_152;


class Solution {

    // 暴力 两层循环
    public int maxProduct(int[] nums) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {

            int temp = nums[i];
            result = Math.max(result, temp);
            for (int j = i + 1; j < nums.length; j++) {
                temp *= nums[j];
                result = Math.max(result, temp);
            }

        }
        return result;
    }
}