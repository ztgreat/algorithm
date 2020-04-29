package com.github.ztgreat.array.leetcode_33.leetcode_31;

/**
 * 二分搜索 变形
 */
class Solution {

    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        return binarySearch(0, nums.length - 1, nums, target);
    }

    private int binarySearch(int a, int b, int[] nums, int target) {

        if (a > b) {
            return -1;
        }
        int mid = (a + b) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (a == b) {
            return -1;
        }

        if (nums[a] < nums[mid]) {

            if (target < nums[mid] && target >= nums[a]) {
                return binarySearch(a, mid - 1, nums, target);
            } else {
                return binarySearch(mid + 1, b, nums, target);
            }
        } else {

            if (target < nums[mid] && target >= nums[a]) {
                return binarySearch(a, mid - 1, nums, target);
            } else {
                int index = binarySearch(a, mid - 1, nums, target);
                if (index != -1) {
                    return index;
                }
                return binarySearch(mid + 1, b, nums, target);
            }
        }
    }

}