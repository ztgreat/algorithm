package com.github.ztgreat.dp.leetcode_120;


import java.util.List;

class Solution2 {


    int result;

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        result = Integer.MAX_VALUE;
        // 简单树形遍历  超时
        dfs(0, 0, triangle, triangle.get(0).get(0));
        return result;
    }

    public void dfs(int i, int j, List<List<Integer>> triangle, int current) {

        if (current >= result) {
            return;
        }
        if (i == triangle.size() - 1) {
            result = Math.min(current, result);
            return;
        }
        dfs(i + 1, j, triangle, current + triangle.get(i + 1).get(j));
        dfs(i + 1, j + 1, triangle, current + triangle.get(i + 1).get(j + 1));
    }
}