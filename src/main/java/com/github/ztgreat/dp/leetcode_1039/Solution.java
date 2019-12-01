package com.github.ztgreat.dp.leetcode_1039;


class Solution {

    /**
     * 对于点 0，1，...，n-1构成的多边形三角剖分，考虑点0和n-1，因为总有某个点 j 与点0和n-1构成三角形，
     * <p>
     * 使得原多边形被分成一个三角形和至多两个凸多边形，求解原问题退化成求解两个规模更小的子问题，
     * <p>
     * 即有若 f(0,n-1)表示原问题的解，则存在 j使
     * <p>
     * f(0,n-1) = f(0,j) + f(j,n-1) + A[0]*A[k]*A[n-1]
     */
    public int minScoreTriangulation(int[] A) {

        int n = A.length;

        if (n < 3) {
            return 0;
        }

        //dp[i][j] = dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]
        int[][] dp = new int[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                if (i + 2 == j) {
                    dp[i][j] = A[i] * A[i + 1] * A[j];
                    continue;
                }
                for (int k = i + 1; k < j; k++) {
                    if (dp[i][j] != 0) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + A[i] * A[j] * A[k]);
                    } else {
                        dp[i][j] = dp[i][k] + dp[k][j] + A[i] * A[j] * A[k];
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}