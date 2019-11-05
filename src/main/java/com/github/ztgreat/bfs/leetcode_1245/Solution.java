package com.github.ztgreat.bfs.leetcode_1245;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/**
 * 两次 bfs
 */
class Solution {


    private int ans;

    public int treeDiameter(int[][] edges) {

        List<Integer>[] map = new ArrayList[edges.length + 1];

        short[] visited = new short[edges.length + 1];

        for (int i = 0; i < map.length; i++) {
            map[i] = new ArrayList<>();
        }
        for (int i = 0; i < edges.length; i++) {
            map[edges[i][0]].add(edges[i][1]);
            map[edges[i][1]].add(edges[i][0]);
        }

        visited[0] = 1;
        int root = bfs(map, visited, 0);
        for (int i = 0; i < edges.length + 1; i++) {
            visited[i] = 1;
        }
        visited[root] = 1;
        ans = 0;
        bfs(map, visited, root);
        return ans - 1;
    }

    public int bfs(List<Integer>[] edge, short[] visited, int root) {

        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(root);
        boolean flag;
        while (!queue.isEmpty()) {
            root = queue.pollFirst();
            if (!edge[root].isEmpty()) {
                flag = false;
                for (Integer u : edge[root]) {
                    if (visited[u] == 0) {
                        queue.addLast(u);
                        visited[u] = (short) (visited[root] + 1);
                        flag = true;
                    }
                }
                if (flag) {
                    ans = visited[root] + 1;
                }
            }
            if (queue.isEmpty()) {
                return root;
            }
        }
        return -1;
    }
}