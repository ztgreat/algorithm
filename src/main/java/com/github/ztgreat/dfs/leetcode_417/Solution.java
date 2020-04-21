package com.github.ztgreat.dfs.leetcode_417;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {

    // 上下左右
    int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    short[][] result;

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {


        if (matrix == null) {
            return Collections.emptyList();
        }
        int n = matrix.length;
        if (n == 0) {
            return Collections.emptyList();
        }
        int m = matrix[0].length;
        result = new short[n][m];
        boolean[][] visit = new boolean[n][m];


        // 初始化
        for (int i = 0; i < m; i++) {
            result[0][i] = 1;
        }
        for (int i = 0; i < n; i++) {
            result[i][0] = 1;
        }


        // 上边界dfs
        for (int i = 0; i < m; i++) {
            if (!visit[0][i]) {
                dfs(0, i, matrix, n, m, visit, 1);
            }
        }

        // 左边界dfs
        for (int i = 0; i < n; i++) {

            if (!visit[i][0]) {
                dfs(i, 0, matrix, n, m, visit, 1);
            }
        }

        // 恢复标记
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = false;
            }
        }

        // 下边界dfs
        for (int i = 0; i < m; i++) {
            if (!visit[n - 1][i]) {
                dfs(n - 1, i, matrix, n, m, visit, 2);
            }
        }

        // 右边界dfs
        for (int i = 0; i < n; i++) {

            if (!visit[i][m - 1]) {
                dfs(i, m - 1, matrix, n, m, visit, 2);
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (result[i][j] == 3) {
                    List<Integer> point = new ArrayList<>(2);
                    point.add(i);
                    point.add(j);
                    res.add(point);
                }

            }
        }
        return res;

    }

    public void dfs(int x, int y, int[][] matrix, int n, int m, boolean[][] visit, int flag) {

        visit[x][y] = true;

        // 从上/左 边界 到 右/下 边界
        if (flag == 1) {
            result[x][y] = 1;
        } else if (flag == 2) {

            // 从右/下  边界 到 上/左 边界
            if (result[x][y] == 1) {
                result[x][y] = 3;
            } else {
                result[x][y] = 2;
            }
        }
        for (int i = 0; i < 4; i++) {
            int newX = x + step[i][0];
            int newY = y + step[i][1];
            if (newX < 0 || newY < 0 || newX >= n || newY >= m) {
                continue;
            }
            if (matrix[newX][newY] < matrix[x][y]) {
                continue;
            }

            if (visit[newX][newY]) {
                continue;
            }
            dfs(newX, newY, matrix, n, m, visit, flag);
        }


    }
}

