package com.github.ztgreat.dp.leetcode_764;


class Solution {


    /**
     * 对于每个中心点坐标 (r, c)，从四个方向计算从 (r, c) 开始最长连续 1 的个数。
     * 用动态规划的方法来看，如果 grid[r][c] 是 0，那么臂长就是 0，
     * 如果 grid[r][c] 是 l, 那么臂长就是当前方向上连续 1 的个数再加 1。
     * 举个例子，假设当前方向为左，网格中有一行为 01110110， 那么对应的连续 1 的个数就是 012301201。
     * 可以观察到，每个数要么是它相邻左边的数加 1， 要么是 0。
     * 对于每个中心点，让 dp[r][c] 为四个方向中最小的连续 1 的个数。显然，dp 数组中最大的值就是我们要的结果
     */
    public int orderOfLargestPlusSign(int N, int[][] mines) {

        short[][][] dp = new short[N][N][4];
        boolean[][] map = new boolean[N][N];
        // 可以采用 0，1 反过来表示题目的意思,这样 这里就可以不用初始化
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = true;
            }
        }
        for (int i = 0; i < mines.length; i++) {
            map[mines[i][0]][mines[i][1]] = false;
        }
        for (int i = 0; i < N; i++) {

            // 左右
            if (map[i][0]) {
                dp[i][0][0] = 1;
            }
            if (map[i][N - 1]) {
                dp[i][N - 1][1] = 1;
            }
            for (int j = 1, k = N - 2; j < N; j++, k--) {
                if (map[i][j]) {
                    dp[i][j][0] = (short) (dp[i][j - 1][0] + 1);
                }
                if (map[i][k]) {
                    dp[i][k][1] = (short) (dp[i][k + 1][1] + 1);
                }
            }

            // 上下
            if (map[0][i]) {
                dp[0][i][2] = 1;
            }
            if (map[N - 1][i]) {
                dp[N - 1][i][3] = 1;
            }
            for (int j = 1, k = N - 2; j < N; j++, k--) {
                if (map[j][i]) {
                    dp[j][i][2] = (short) (dp[j - 1][i][2] + 1);
                }
                if (map[k][i]) {
                    dp[k][i][3] = (short) (dp[k + 1][i][3] + 1);
                }
            }
        }

        int ans = Integer.MIN_VALUE;
        int cnt;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cnt = Integer.MAX_VALUE;
                cnt = Math.min(cnt, dp[i][j][0]);
                cnt = Math.min(cnt, dp[i][j][1]);
                cnt = Math.min(cnt, dp[i][j][2]);
                cnt = Math.min(cnt, dp[i][j][3]);
                ans = Math.max(cnt, ans);
            }

        }
        return ans;
    }
}