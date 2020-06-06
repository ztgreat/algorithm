package com.github.ztgreat.dp.leetcode_139;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * bfs
 */
class Solution3 {

    public boolean wordBreak(String s, List<String> wordDict) {

        if (s == null || wordDict == null || wordDict.isEmpty()) {
            return false;
        }
        HashMap<String, Boolean> map = new HashMap<>(wordDict.size());
        for (int i = 0; i < wordDict.size(); i++) {
            map.put(wordDict.get(i), true);
        }
        LinkedList<Integer> queue = new LinkedList<>();
        return bfs(s, map, queue);
    }

    private boolean bfs(String str, Map map, LinkedList<Integer> queue) {

        boolean[] vis = new boolean[str.length() + 1];
        queue.addLast(0);
        while (!queue.isEmpty()) {
            int index = queue.removeFirst();
            if (index == str.length()) {
                return true;
            }
            if (vis[index]) {
                continue;
            }
            vis[index] = true;
            for (int i = index; i <= str.length(); i++) {
                if (map.get(str.substring(index, i)) != null) {
                    queue.addLast(i);
                }
            }
        }
        return false;
    }
}