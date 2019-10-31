package com.github.ztgreat.leetcode.problem_838;


import java.util.ArrayList;
import java.util.List;

class Solution {

    // 直接模拟
    public String pushDominoes(String dominoes) {

        char[] res = dominoes.toCharArray();
        List<Integer> index = new ArrayList<>(res.length);
        for (int i = 0; i < res.length; i++) {
            if (res[i] != '.')
                index.add(i);

        }

        for (int i = 0; i < index.size(); i++) {
            int ii = index.get(i);
            if (res[ii] == 'L') {
                if (i == 0) {
                    for (int j = 0; j < ii; j++) {
                        res[j] = 'L';
                    }
                    continue;
                }
                int l = index.get(i - 1);
                if (res[l] == 'R')
                    continue;
                for (int j = l + 1; j < ii; j++) {
                    res[j] = 'L';
                }
            } else {
                if (i == index.size() - 1) {
                    for (int j = ii + 1; j < res.length; j++) {
                        res[j] = 'R';
                    }
                    continue;
                }
                int r = index.get(i + 1);
                if (res[r] == 'R') {
                    for (int j = ii + 1; j < r; j++) {
                        res[j] = 'R';
                    }
                } else {
                    int len = (r - ii - 1) / 2;
                    for (int j = ii + 1; j <= len + ii; j++) {
                        res[j] = 'R';
                    }
                    for (int j = r - 1; j >= r - len; j--) {
                        res[j] = 'L';
                    }
                }
            }
        }
        return new String(res);

    }

}