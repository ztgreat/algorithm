package com.github.ztgreat.dp.leetcode_813;


class Solution {


    public double largestSumOfAverages(int[] A, int K) {


        //dp[i][k] 表示 前i 个数 分成 k 个相邻数组的 最大分数值

        //dp[i][k] = dp[j][k-1] + (A[j+1]+...+A[i])/(i-j);

        int n = A.length;

        if (K > n) {
            K = n;
        }
        double[][] dp = new double[n][K + 1];
        int[] sum = new int[n];
        int temp = 0;
        for (int i = 0; i < n; i++) {
            temp += A[i];
            sum[i] = temp;

        }
        for (int i = 0; i < n; i++) {
            for (int k = 1; k <= K; k++) {

                if (k == 1) {
                    dp[i][k] = sum[i] * 1.0 / (i + 1);
                    continue;
                }
                for (int j = 0; j < i; j++) {
                    dp[i][k] = Math.max(dp[i][k], dp[j][k - 1] + (sum[i] - sum[j]) * 1.0 / (i - j));
                }
            }
        }
        return dp[n - 1][K];

    }
}