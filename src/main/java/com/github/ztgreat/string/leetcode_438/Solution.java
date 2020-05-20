package com.github.ztgreat.string.leetcode_438;


import java.util.*;

/**
 * 滑动窗口解法
 * <p>
 * 还可以代码优化
 */
class Solution {


    public List<Integer> findAnagrams(String s, String p) {


        if (s == null || p == null) {
            return Collections.emptyList();
        }
        if (p.length() > s.length()) {
            return Collections.emptyList();
        }

        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        List<Integer> res = new ArrayList<>();

        Integer temp;
        for (int i = 0; i < p.length(); i++) {
            target.put(p.charAt(i), target.getOrDefault(p.charAt(i), 0) + 1);
        }

        // 窗口 左指针
        int left = 0;

        // 窗口右指针
        int right = 0;

        // 有效字符记录
        int valid = 0;
        while (right < s.length()) {

            // 处理 right 处字符
            char c = s.charAt(right);
            right++;

            // 更新窗口中c的字符个数
            if (target.get(c) != null) {
                window.put(c, window.getOrDefault(c, 0) + 1);

                // 如果目标字符串 字符"个数" 和窗口的一致，表示找到一个
                if (window.get(c).equals(target.get(c))) {
                    valid++;
                }
            }

            // 尝试收缩窗口
            while (right - left >= p.length()) {
                if (valid == target.size()) {
                    res.add(left);
                }
                char d = s.charAt(left);
                left++;
                // 更新窗口中的字符个数
                if (target.get(d) != null) {

                    if (window.get(d).equals(target.get(d))) {
                        valid--;
                    }
                    if (window.get(d) == 1) {
                        window.remove(d);
                    } else {
                        window.put(d, window.get(d) - 1);
                    }
                }
            }
        }
        return res;
    }

}