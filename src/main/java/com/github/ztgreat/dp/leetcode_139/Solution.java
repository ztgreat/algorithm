package com.github.ztgreat.dp.leetcode_139;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 暴力 dfs
 * 超时
 */
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        HashMap<String, Boolean> map = new HashMap<>(wordDict.size());
        for (int i = 0; i < wordDict.size(); i++) {
            map.put(wordDict.get(i), true);
        }
        return dfs(s, 0, map);
    }

    public boolean dfs(String str, Integer index, Map map) {

        if (index == str.length()) {
            return true;
        }
        for (int i = index; i <= str.length(); i++) {

            if (map.get(str.substring(index, i)) != null) {
                if (dfs(str, i, map)) {
                    return true;
                }
            }
        }
        return false;
    }
}