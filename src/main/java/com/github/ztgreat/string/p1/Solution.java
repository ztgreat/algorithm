package com.github.ztgreat.string.p1;


class Solution {


    // 方法 1 使用hash
    // 方法 2 如果 是字符数组 可以使用堆排序

    public boolean checkDifferent(String iniString) {

        if (iniString == null || "".equals(iniString)) {
            return true;
        }

        if (iniString.length() > 256) {
            return false;
        }
        // ????  这里定义 257 不通过？？
        boolean[] hash = new boolean[65535];

        int x;
        for (int i = 0; i < iniString.length(); i++) {
            x = iniString.charAt(i);
            if (hash[x]) {
                return false;
            }
            hash[x] = true;
        }
        return true;
    }


    // 堆排序
    public boolean checkDifferent2(String iniString) {

        if (iniString == null || "".equals(iniString)) {
            return true;
        }
        if (iniString.length() > 256) {
            return false;
        }
        char[] str = iniString.toCharArray();
        int n = str.length;
        for (int i = n; i > 0; i--) {
            headUp(str, i);
            swap(str, 0, i - 1);
        }
        for (int i = 1; i < str.length; i++) {
            if (str[i] == str[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public void swap(char[] str, int x, int y) {
        char temp = str[x];
        str[x] = str[y];
        str[y] = temp;
    }

    public void headUp(char[] str, int n) {

        int x, y;
        for (int i = n / 2 - 1; i >= 0; i--) {
            x = i * 2 + 1;
            y = i * 2 + 2;

            if (x < n && str[i] < str[x]) {
                swap(str, i, x);
            }
            if (y < n && str[i] < str[y]) {
                swap(str, i, y);
            }
        }
    }

    public static void main(String[] args) {

        new Solution().checkDifferent2("1234");
    }


}