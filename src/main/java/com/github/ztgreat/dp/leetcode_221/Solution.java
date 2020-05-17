package com.github.ztgreat.dp.leetcode_221;


class Solution {

    public int maximalSquare(char[][] matrix) {

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int max = 0;

        // dp[i][j][0]  表示 (i,j) 这个位置 向上最多连续1 的个数
        // dp[i][j][1]  表示 (i,j) 这个位置 向左最多连续1 的个数


        int[][][] dp = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    max = Math.max(max, 1);
                    // 上
                    if (i == 0) {
                        dp[i][j][0] = 1;
                    } else {
                        dp[i][j][0] = dp[i - 1][j][0] + 1;
                    }

                    // 左
                    if (j == 0) {
                        dp[i][j][1] = 1;
                    } else {
                        dp[i][j][1] = dp[i][j - 1][1] + 1;
                    }

                } else {
                    continue;
                }

                // 计算最大面积
                // 上
                int y1 = dp[i][j][0];

                // 左
                int x1 = dp[i][j][1];
                x1 = Math.min(x1, y1);
                int cnt = x1;
                // 从这个点（i,j）开始扩展计算查找最大面积
                for (int a = j; a >= j - cnt + 1; a--) {

                    x1 = j - a + 1;
                    y1 = x1;

                    int x2 = dp[i - y1 + 1][j][1];
                    if (x2 >= x1) {
                        x2 = x1;
                    } else {
                        break;
                    }

                    int y2 = dp[i][j - x1 + 1][0];
                    if (y2 >= y1) {
                        y2 = y1;
                    } else {
                        break;
                    }

                    if (x1 == x2 && y1 == y2) {
                        max = Math.max(max, y2 * x2);
                    }
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {


        char[][] a = {
                {'1', '0', '1', '1', '0', '1'},
                {'1', '1', '1', '1', '1', '1'},
                {'0', '1', '1', '0', '1', '1'},
                {'1', '1', '1', '0', '1', '0'},
                {'0', '1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '1', '1'}};
        System.out.println(new Solution().maximalSquare(a));
    }


    // 第二种做法
    // 实际是第一种的优化版

    /**
     dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长, 则递推式为:
     dp[i][j] = 1 + min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]);
     **/
}