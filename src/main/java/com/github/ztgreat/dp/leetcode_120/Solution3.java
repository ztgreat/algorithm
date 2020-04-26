package com.github.ztgreat.dp.leetcode_120;


import java.util.List;

class Solution3 {


    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.isEmpty()) {
            return 0;
        }
        // 利用O(n)空间数据 自底向上计算
        int[] dp = new int[triangle.size()];
        for (int i = 0; i < triangle.size(); i++) {
            dp[i] = triangle.get(triangle.size() - 1).get(i);
        }
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                dp[j] = Math.min(triangle.get(i).get(j) + dp[j], triangle.get(i).get(j) + dp[j + 1]);
            }
        }
        return dp[0];
    }

}