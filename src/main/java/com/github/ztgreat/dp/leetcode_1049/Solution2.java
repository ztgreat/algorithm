package com.github.ztgreat.dp.leetcode_1049;


class Solution2 {


    /**
     * dfs 搜索 接近 sum/2 的组合数
     */
    int result;

    public int lastStoneWeightII(int[] stones) {

        if (stones == null || stones.length == 0) {
            return 0;
        }
        int sum = 0;
        for (int i = 0; i < stones.length; i++) {
            sum += stones[i];
        }
        int nsum = sum / 2;
        result = -1;
        dfs(0, stones, 0, nsum);
        return sum - result - result;
    }

    public void dfs(int index, int[] stones, int current, int target) {

        if (result == target) {
            return;
        }
        result = Math.max(result, current);
        for (int i = index; i < stones.length; i++) {
            if (current + stones[i] <= target) {
                dfs(i + 1, stones, current + stones[i], target);
            }
        }
    }
}