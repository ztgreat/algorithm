package com.github.ztgreat.array.leetcode_240;


/**
 * 分治法。
 * <p>
 * 左下角的元素是这一行中最小的元素，同时又是这一列中最大的元素。比较左下角元素和目标：
 * 若左下角元素等于目标，则找到
 * 若左下角元素大于目标，则目标不可能存在于当前矩阵的最后一行，问题规模可以减小为在去掉最后一行的子矩阵中寻找目标
 * 若左下角元素小于目标，则目标不可能存在于当前矩阵的第一列，问题规模可以减小为在去掉第一列的子矩阵中寻找目标
 * 若最后矩阵减小为空，则说明不存在
 */
class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {

        if (matrix == null) {
            return false;
        }
        int x = matrix.length;
        if (x == 0) {
            return false;
        }
        int y = matrix[0].length;
        return search(matrix, x - 1, 0, target);
    }

    public boolean search(int[][] matrix, int x, int y, int target) {

        if (x < 0 || y >= matrix[0].length) {
            return false;
        }
        if (matrix[x][y] == target) {
            return true;
        }

        if (matrix[x][y] > target) {

            return search(matrix, x - 1, y, target);
        }
        if (matrix[x][y] < target) {

            return search(matrix, x, y + 1, target);
        }
        return false;

    }


}