package com.github.ztgreat.dp.leetcode_983;


class Solution {

    public int mincostTickets(int[] days, int[] costs) {


        if (days == null) {
            return 0;
        }

        int n = days.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                dp[i] = costs[0];
                dp[i] = Math.min(dp[i], costs[1]);
                dp[i] = Math.min(dp[i], costs[2]);
                continue;
            }

            dp[i] = dp[i - 1] + costs[0];
            dp[i] = Math.min(dp[i], dp[i - 1] + costs[1]);
            dp[i] = Math.min(dp[i], dp[i - 1] + costs[2]);

            for (int j = i - 1; j >= 0; j--) {
                if (days[i] - days[j] + 1 <= 7) {
                    if (j == 0) {
                        dp[i] = Math.min(dp[i], costs[1]);
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[j - 1] + costs[1]);
                }
                if (days[i] - days[j] + 1 <= 30) {
                    if (j == 0) {
                        dp[i] = Math.min(dp[i], costs[2]);
                        continue;
                    }
                    dp[i] = Math.min(dp[i], dp[j - 1] + costs[2]);
                }
            }
        }
        return dp[n - 1];

    }
}