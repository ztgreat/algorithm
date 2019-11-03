package com.github.ztgreat.dp.leetcode_3;


class Solution {


    public int lengthOfLongestSubstring(String s) {

        if (s == null || "".equals(s)) {
            return 0;
        }
        int n = s.length();
        // dp[i] 表示 以s[i] 结尾的 无重复的最长子串的长度
        // 假设dp[i-1]=x,dp[i] = dp[i-1]+1 且 s[i-x] ~ s[i] 不重复
        int[] dp = new int[n];
        dp[0] = 1;
        int cnt;
        int ans = 1;
        int temp;
        for (int i = 1; i < n; i++) {
            dp[i] = 1;
            cnt = dp[i - 1];
            temp = 0;
            while (cnt > 0) {
                if (s.charAt(i - cnt) == s.charAt(i)) {
                    temp = 0;
                    cnt--;
                    continue;
                }
                temp++;
                cnt--;
            }
            dp[i] = temp + 1;

            if (ans < dp[i]) {
                ans = dp[i];
            }
        }
        return ans;


    }


}