package com.github.ztgreat.dfs.leetcode_130;


class Solution {

    /**
     * 思想 就是从边界触发，找到和边界连通的O,这些O 是不需要被替换的，其余的O 是需要被替换的
     */
    public void solve(char[][] board) {

        int n = board.length;

        if (n == 0) {
            return;
        }

        int m = board[0].length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // 从边缘o开始搜索
                if ((i == 0 || j == 0 || i == n - 1 || j == m - 1) && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }

        /**
         * 将不需要被替换的O还原，其余的O替换成X
         */
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public void dfs(char[][] board, int i, int j) {

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == 'X' || board[i][j] == '#') {
            return;
        }
        // 中间临时标记
        board[i][j] = '#';
        // 上
        dfs(board, i - 1, j);
        // 下
        dfs(board, i + 1, j);
        // 左
        dfs(board, i, j - 1);
        // 右
        dfs(board, i, j + 1);

    }
}