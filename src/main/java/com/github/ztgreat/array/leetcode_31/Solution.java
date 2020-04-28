package com.github.ztgreat.array.leetcode_31;


/**
 * 以3 4 5 2 1 为例
 * 从后往前寻找第一次出现的正序对：（找到 4,5）
 * 之后因为从5 开始都是逆序，所以把他们反转就是正序：3 4 1 2 5
 * 之后4 的位置应该是：在它之后的，比他大的最小值（5）
 * 交换这两个值：得到 3 5 1 2 4
 * 对于初始即为逆序的序列，将在反转步骤直接完成
 */
class Solution {

    public void nextPermutation(int[] nums) {

        if (nums == null || nums.length == 1) {
            return;
        }

        // 从后往前找 一个 正序 对
        int a = -1;
        int b = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                a = i;
                b = i + 1;
                break;
            }
        }
        // 如果没有找到，说明 没有 没有下一个排列，直接逆序返回
        if (a == -1) {
            reverse(0, nums.length - 1, nums);
            return;
        }

        // 反转 a 后面的元素
        reverse(a + 1, nums.length - 1, nums);

        // 将a 与后面第一个比它大的元素交换位置
        int temp;
        for (int i = a + 1; i < nums.length; i++) {

            if (nums[i] > nums[a]) {
                temp = nums[a];
                nums[a] = nums[i];
                nums[i] = temp;
                break;
            }
        }
    }

    private void reverse(int x, int y, int[] nums) {
        int temp;
        while (x < y) {
            temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
            x++;
            y--;
        }
    }
}