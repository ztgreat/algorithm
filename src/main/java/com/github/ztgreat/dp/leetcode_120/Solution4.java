package com.github.ztgreat.dp.leetcode_120;


import java.util.List;

class Solution4 {


    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }

        // 记忆化搜索
        int[][] dp = new int[triangle.size()][triangle.size()];

        for (int i = 0; i < triangle.size(); i++) {
            for (int j = 0; j < triangle.size(); j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < triangle.size(); i++) {
            result = Math.min(result, dfs(triangle.size() - 1, i, triangle, dp));
        }
        return result;

    }

    public int dfs(int i, int j, List<List<Integer>> triangle, int[][] dp) {

        if (i == 0) {
            return triangle.get(0).get(0);
        }
        if (triangle.get(i).size() <= j || j < 0) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][j] != Integer.MAX_VALUE) {
            return dp[i][j];
        }

        // dp[i][j] = min(dp[i-1][j],dp[i-1][j-1])

        int result = dfs(i - 1, j, triangle, dp);
        if (result != Integer.MAX_VALUE) {
            dp[i][j] = Math.min(dp[i][j], triangle.get(i).get(j) + result);
        }
        result = dfs(i - 1, j - 1, triangle, dp);
        if (result != Integer.MAX_VALUE) {
            dp[i][j] = Math.min(dp[i][j], triangle.get(i).get(j) + result);
        }
        return dp[i][j];
    }

}