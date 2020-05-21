package com.github.ztgreat.string.leetcode_567.leetcode_438;


import java.util.HashMap;
import java.util.Map;

/**
 * 滑动窗口解法
 */
class Solution {

    public boolean checkInclusion(String s1, String s2) {

        if (s1 == null || s2 == null) {
            return false;
        }

        Map<Character, Integer> target = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            target.put(s1.charAt(i), target.getOrDefault(s1.charAt(i), 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()) {

            char c = s2.charAt(right);
            right++;

            if (target.get(c) != null) {

                window.put(c, window.getOrDefault(c, 0) + 1);

                if (window.get(c).equals(target.get(c))) {
                    valid++;
                }
            }
            while (right - left >= s1.length()) {

                if (valid == target.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left++;

                if (target.get(d) != null) {

                    if (target.get(d).equals(window.get(d))) {
                        valid--;
                    }

                    if (window.get(d) == 1) {
                        window.remove(d);
                    } else {
                        window.put(d, window.get(c) - 1);
                    }
                }
            }
        }
        return false;
    }

}