package com.github.ztgreat.string.leetcode_28;


class Solution {


    // 寻找 最长公共前后缀 数组
    public int[] prefixTable(String pattern) {
        int n = pattern.length();
        int[] prefix = new int[n];
        prefix[0] = 0;
        int i = 1;
        int len = 0;
        while (i < n) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                prefix[i] = ++len;
                i++;
            } else {

                if (len > 0) {
                    len = prefix[len - 1];
                } else {
                    prefix[i] = 0;
                    i++;
                }
            }
        }
        return prefix;
    }

    public int[] movePrefixTable(int[] prefix) {
        int n = prefix.length;
        for (int i = n - 1; i > 0; i--) {
            prefix[i] = prefix[i - 1];
        }
        prefix[0] = -1;
        return prefix;
    }

    public int kmp(String text, String pattern) {

        int[] prefixTable = prefixTable(pattern);
        movePrefixTable(prefixTable);
        //text[i] len(text) =m
        //pattern[j] len(pattern) =n
        int i = 0, j = 0, m = text.length(), n = pattern.length();
        while (i < m) {
            if (n - j > m - i) {
                break;
            }
            if (j == n - 1 && text.charAt(i) == pattern.charAt(j)) {

                // found
                return i - n + 1;
                // 如果 还要继续匹配,做如下操作
                //j = prefixTable[j];

            }
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                j = prefixTable[j];
                if (j == -1) {
                    j = 0;
                    i++;
                }
            }
        }
        return -1;
    }


    public int strStr(String haystack, String needle) {

        if ("".equals(needle)) {
            return 0;
        }

        if (haystack.length() < needle.length()) {
            return -1;
        }

        return kmp(haystack, needle);
    }

}