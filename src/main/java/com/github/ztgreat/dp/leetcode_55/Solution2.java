package com.github.ztgreat.dp.leetcode_55;


/**
 * 一次遍历
 * 记录 能到达最远的地方
 */
class Solution2 {

    public boolean canJump(int[] nums) {

        if (nums == null || nums.length == 0) {
            return false;
        }
        if (nums.length == 1) {
            return true;
        }
        if (nums[0] == 0) {
            return false;
        }
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {

            if (i <= max) {
                max = Math.max(max, i + nums[i]);
            } else {
                return false;
            }
        }
        if (max < nums.length - 1) {
            return false;
        }
        return true;

    }
}