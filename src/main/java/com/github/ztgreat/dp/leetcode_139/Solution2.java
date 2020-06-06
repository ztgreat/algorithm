package com.github.ztgreat.dp.leetcode_139;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 记忆化dfs
 */
class Solution2 {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        HashMap<String, Boolean> map = new HashMap<>(wordDict.size());
        for (int i = 0; i < wordDict.size(); i++) {
            map.put(wordDict.get(i), true);
        }

        boolean[] vis = new boolean[s.length() + 1];

        return dfs(s, 0, map, vis);
    }

    public boolean dfs(String str, Integer index, Map map, boolean[] vis) {

        if (index == str.length()) {
            return true;
        }
        for (int i = index; i <= str.length(); i++) {

            if (map.get(str.substring(index, i)) != null && !vis[i]) {
                vis[i] = true;
                if (dfs(str, i, map, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}