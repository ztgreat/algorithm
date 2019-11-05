package com.github.ztgreat.graph.leetcode_128;


import java.util.HashMap;
import java.util.Map;

/**
 * 并查集
 */
class Solution {


    public int longestConsecutive(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>(nums.length);
        Map<Integer, Integer> cnt = new HashMap<>(nums.length);

        for (int x : nums) {
            map.put(x, x);
            cnt.put(x, 1);
        }
        for (int x : nums) {

            Integer father = find(map, x - 1);
            if (father != null && map.get(x).equals(x)) {
                // 合并,路径压缩
                map.put(x, father);
                cnt.put(father, cnt.get(father) + cnt.get(x));
            }
        }

        final int[] max = {0};
        cnt.forEach((k, v) -> {
            if (max[0] < v) {
                max[0] = v;
            }
        });

        return max[0];

    }

    Integer find(Map<Integer, Integer> map, int child) {
        Integer fa = map.get(child);
        while (fa != null && fa != child) {
            return find(map, fa);
        }
        if (fa == null) {
            return null;
        }
        return child;
    }

    public static void main(String[] args) {

        int[] a = {1, -2, -4, -4, 0, -1, 1, -3};

        //6
        System.out.println(new Solution().longestConsecutive(a));

    }

}