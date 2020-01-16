package com.github.ztgreat.dfs.leetcode_200;

// 简单遍历dfs就可以了
class Solution {
    public int numIslands(char[][] grid) {

        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {

                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
            }
        }
        return cnt;
    }

    public void dfs(char[][] grid, int x, int y) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '0';
            dfs(grid, x + 1, y);
            dfs(grid, x - 1, y);
            dfs(grid, x, y + 1);
            dfs(grid, x, y - 1);

        }
    }
}