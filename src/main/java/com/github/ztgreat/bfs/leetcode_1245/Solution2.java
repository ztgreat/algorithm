package com.github.ztgreat.bfs.leetcode_1245;


import java.util.ArrayList;
import java.util.List;


/**
 * 两次 dfs
 * 还未验证代码(题目突然加锁了,不是会员 没验证)
 */
class Solution2 {


    private int ans;

    private int e;

    public int treeDiameter(int[][] edges) {

        List<Integer>[] map = new ArrayList[edges.length + 1];

        boolean[] visited = new boolean[edges.length + 1];

        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            map[edges[i][0]].add(edges[i][1]);
            map[edges[i][1]].add(edges[i][0]);
        }

        visited[0] = true;
        dfs(map, visited, 0, 0);
        for (int i = 0; i < edges.length + 1; i++) {
            visited[i] = false;
        }
        visited[e] = true;
        ans = 0;
        dfs(map, visited, e, 0);
        return ans;
    }

    public void dfs(List<Integer>[] edge, boolean[] visited, int root, int depth) {

        for (Integer e : edge[root]) {
            if (!visited[e]) {
                visited[e] = true;
                dfs(edge, visited, e, depth + 1);
            }
        }
        if (ans < depth) {
            ans = depth;
            e = root;
        }
    }
}