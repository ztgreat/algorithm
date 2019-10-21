package com.github.ztgreat.dp.leetcode_873;


import java.util.HashMap;
import java.util.Map;

class Solution {


    public int lenLongestFibSubseq(int[] A) {

        int n = A.length;

        if (n == 0) {
            return 0;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>(n);
        //dp[i][j] 的含义 为 A[?]+A[i]=A[j]
        int[][] dp = new int[n][n];
        int max = 0;
        Integer k;
        map.put(A[0], 0);
        for (int i = 1; i < n; i++) {
            map.put(A[i], i);
            for (int j = i + 1; j < n; j++) {

                k = map.get(A[j] - A[i]);
                if (k == null) {
                    continue;
                }
                if (dp[i][j] == 0) {
                    dp[i][j] = 3;
                }
                dp[i][j] = Math.max(dp[i][j], dp[k][i] + 1);
                if (max < dp[i][j]) {
                    max = dp[i][j];
                }

            }
        }
        return max;
    }
}