package com.github.ztgreat.array.leetcode_34.leetcode_33;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    /**
     * 可以 保存全部二分查找结果
     * 因为是有序的，也可以向后，向前向后查到该元素截至位置
     */
    private List<Integer> result;

    public int[] searchRange(int[] nums, int target) {

        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        if (nums == null || nums.length == 0) {
            return ans;
        }
        result = new ArrayList<>();
        binarySearch(0, nums.length - 1, nums, target);
        if (result.isEmpty()) {
            return ans;
        }
        Collections.sort(result);
        ans[0] = result.get(0);
        ans[1] = result.get(result.size() - 1);
        return ans;
    }

    private void binarySearch(int a, int b, int[] nums, int target) {

        if (a > b) {
            return;
        }
        int mid = (a + b) / 2;
        if (nums[mid] == target) {
            result.add(mid);
        }

        if (a == b) {
            return;
        }
        if (nums[mid] >= target) {
            binarySearch(a, mid - 1, nums, target);
        }

        if (nums[mid] <= target) {
            binarySearch(mid + 1, b, nums, target);
        }
    }
}

}