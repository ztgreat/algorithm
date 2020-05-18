package com.github.ztgreat.sort.leetcode_56;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {


    public int[][] merge(int[][] intervals) {

        List<int[]> res = new ArrayList<>();
        if (intervals == null || intervals.length == 0)
            return res.toArray(new int[0][]);
        // 对起点进行排序
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int n = intervals.length;
        int i = 0;

        // 遍历 处理区间右端点情况
        while (i < n) {

            int left = intervals[i][0];
            int right = intervals[i][1];
            while (i < n - 1 && right >= intervals[i + 1][0]) {
                right = Math.max(right, intervals[i + 1][1]);
                i++;
            }
            res.add(new int[]{left, right});
            i++;
        }
        return res.toArray(new int[res.size()][2]);

    }

}