package com.github.ztgreat.dp.leetcode_1223;


class Solution {

    public int dieSimulator(int n, int[] rollMax) {

        int MOD = 1000000007;

        // dp[n][j][k] 代码 投递 第n 次 点数 为j 连续次数不超过 k的情况总数
        int[][][] dp = new int[n][7][16];

        for (int j = 1; j <= 6; j++) {
            dp[0][j][1] = 1;
        }
        // 第 i 次投递
        for (int i = 1; i < n; i++) {
            // 上次投递结果
            for (int j = 1; j <= 6; j++) {
                // 这次投递结果
                for (int k = 1; k <= 6; k++) {

                    // 上次投递结果和本次不相同
                    if (j != k) {
                        for (int t = 1; t <= rollMax[k - 1]; t++) {
                            // 上次投递结果和本次不相同 那么肯定是不连续的,本次的连续次数 则为1
                            // 结果数 = 上次 投递 结果数之和（上次不超过指定连续次数情况的总和）
                            dp[i][j][1] += dp[i - 1][k][t];
                            dp[i][j][1] %= MOD;
                        }
                    } else {
                        for (int t = 1; t < rollMax[k - 1]; t++) {
                            //上次投递结果和本次相同
                            dp[i][j][t + 1] += dp[i - 1][k][t];
                            dp[i][j][t + 1] %= MOD;
                        }

                    }
                }
            }
        }
        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            for (int k = 1; k <= rollMax[i - 1]; k++) {
                sum += dp[n - 1][i][k];
                sum %= MOD;
            }
        }
        return sum;
    }
}