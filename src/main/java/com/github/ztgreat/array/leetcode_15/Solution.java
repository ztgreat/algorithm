package com.github.ztgreat.array.leetcode_15;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {


    public List<List<Integer>> threeSum(int[] nums) {

        if (nums == null || nums.length < 3) {
            return Collections.emptyList();
        }
        int len = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        for (int i = 0; i < len; i++) {

            if (nums[i] > 0) {
                // 排序后，当前数字大于0 则肯定不能和后面的数字 组成 和为0
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                // 去重
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    L++;
                    R--;
                    while (L < R && nums[L] == nums[L - 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R + 1]) {
                        R--;
                    }
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return ans;
    }

}