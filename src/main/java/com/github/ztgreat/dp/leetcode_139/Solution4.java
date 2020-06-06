package com.github.ztgreat.dp.leetcode_139;


import java.util.HashMap;
import java.util.List;

/**
 * dp
 */
class Solution4 {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        HashMap<String, Boolean> map = new HashMap<>(wordDict.size());
        for (int i = 0; i < wordDict.size(); i++) {
            map.put(wordDict.get(i), true);
        }

        /**
         * dp[i] 表示字符串 s[0,i] 是否可以满足可以拆分成字典中的单词
         * dp[i]  = dp[j]  & str[j,i] in map
         */
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[j] && map.get(s.substring(j, i)) != null) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];

    }

}