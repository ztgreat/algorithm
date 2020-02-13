package com.github.ztgreat.graph.leetcode_207;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

class Solution {


    public boolean canFinish(int numCourses, int[][] prerequisites) {

        // 邻接表
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // 入度统计表
        int[] indegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            indegree[prerequisites[i][1]] += 1;
            List<Integer> list = map.get(prerequisites[i][0]);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(prerequisites[i][1]);
            map.put(prerequisites[i][0], list);
        }
        return sort(map, indegree);
    }

    // 拓扑排序
    public boolean sort(HashMap<Integer, List<Integer>> map, int[] indegree) {

        LinkedList<Integer> queue = new LinkedList<Integer>();

        // 入度为0的节点
        for (int i = 0; i < indegree.length; i++) {
            if(indegree[i]==0){
                queue.addLast(i);
            }
        }
        while (!queue.isEmpty()) {

            int top = queue.poll();
            List<Integer> next = map.get(top);
            if (next == null) {
                continue;
            }
            next.forEach(node -> {
                indegree[node] -= 1;
                if (indegree[node] == 0) {
                    queue.addLast(node);
                }
            });
        }
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] > 0) {
                return false;
            }
        }
        return true;
    }
}