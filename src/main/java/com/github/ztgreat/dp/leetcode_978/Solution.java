package com.github.ztgreat.dp.leetcode_978;


class Solution {
    public int maxTurbulenceSize(int[] A) {

        int n = A.length;
        if (n == 1) {
            return 1;
        }
        // dp[i] 表示 以 A[i] 为结尾的 湍流数组的 最大长度
        int[] dp = new int[n];
        dp[0] = 1;
        if (A[0] != A[1]) {
            dp[1] = 2;
        }
        int res = Math.max(dp[0], dp[1]);
        for (int i = 2; i < n; i++) {
            if ((A[i] > A[i - 1] && A[i - 2] > A[i - 1]) || (A[i] < A[i - 1] && A[i - 2] < A[i - 1])) {
                dp[i] = dp[i - 1] + 1;
            } else if (A[i] != A[i - 1]) {
                dp[i] = 2;
            }
            if (res < dp[i]) {
                res = dp[i];
            }
        }
        return res;
    }
}