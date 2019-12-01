package com.github.ztgreat.dp.leetcode_1139;


class Solution {

    public int largest1BorderedSquare(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        //dp[i][j][0] 表示　从左往右看，位置[i][j] 横向连续１的个数
        //dp[i][j][１] 表示　从上往下看，位置[i][j] 纵向连续１的个数
        int[][][] dp = new int[m][n][2];
        int ans = 0;
        int min;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // 当前位置为0,不计算
                if (grid[i][j] == 0) {
                    continue;
                }
                // 横向统计连续１个数
                if (j == 0) {
                    dp[i][j][0] = 1;
                } else {
                    dp[i][j][0] = dp[i][j - 1][0] + 1;
                }

                //纵向统计连续１个数
                if (i == 0) {
                    dp[i][j][1] = 1;
                } else {

                    dp[i][j][1] = dp[i - 1][j][1] + 1;
                }

                min = Math.min(dp[i][j][0], dp[i][j][1]);
                // 计算正方形另外两条边的最大长度
                for (int k = min; k > 0 && ans < k; k--) {
                    if (dp[i][j - k + 1][1] >= k && dp[i - k + 1][j][0] >= k) {
                        ans = Math.max(ans, k);
                        break;
                    }
                }
            }
        }
        return ans * ans;
    }

}
