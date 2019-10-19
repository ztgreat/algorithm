package com.github.ztgreat.leetcode.problem_873;


class Solution {


    public int lenLongestFibSubseq(int[] A) {

        int n = A.length;

        int[][] dp = new int[n][n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = 0; k < i; k++) {

                    if (A[k] + A[i] > A[j]) {
                        break;
                    }

                    if (A[k] + A[i] == A[j]) {
                        if (dp[i][j] == 0) {
                            dp[i][j] = 3;
                        }
                        dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                        if (max < dp[i][j]) {
                            max = dp[i][j];
                        }
                    }
                }
            }
        }
        return max;
    }
}