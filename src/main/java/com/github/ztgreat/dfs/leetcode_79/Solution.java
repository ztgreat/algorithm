package com.github.ztgreat.dfs.leetcode_79;

/**
 * dfs 暴力搜索就可以了
 */
class Solution {


    private int[][] step = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public boolean exist(char[][] board, String word) {

        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word == null || "".equals(word)) {
            return false;
        }
        boolean[][] vis = new boolean[board.length][board[0].length];
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == words[0]) {
                    vis[i][j] = true;
                    if (dfs(board, i, j, words, vis, 0)) {
                        return true;
                    }
                }

            }
        }
        return false;

    }

    boolean dfs(char[][] board, int x, int y, char[] word, boolean[][] vis, int index) {

        if (index == word.length) {
            return false;
        }
        if (board[x][y] != word[index]) {
            return false;
        }

        if (index == word.length - 1) {
            return true;
        }
        int newX;
        int newY;
        for (int i = 0; i < 4; i++) {
            newX = x + step[i][0];
            newY = y + step[i][1];
            if (newX < 0 || newX >= board.length || newY < 0 || newY >= board[newX].length) {
                continue;
            }
            if (vis[newX][newY]) {
                continue;
            }
            vis[newX][newY] = true;
            if (dfs(board, newX, newY, word, vis, index + 1)) {
                return true;
            }
            vis[newX][newY] = false;
        }
        return false;
    }
}