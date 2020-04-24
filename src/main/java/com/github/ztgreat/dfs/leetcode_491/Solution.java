package com.github.ztgreat.dfs.leetcode_491;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    List<Integer> current;

    public List<List<Integer>> findSubsequences(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        current = new ArrayList<>();
        dfs(0, nums, result);
        return result;
    }

    public void dfs(int index, int[] nums, List<List<Integer>> result) {

        if (index == nums.length) {
            return;
        }
        for (int i = index; i < nums.length; i++) {

            if (i == 0) {
                current.add(nums[i]);
                dfs(i + 1, nums, result);
                current.remove(current.size() - 1);
            } else {
                if ((current.size() + (nums.length - i) >= 2)) {
                    current.add(nums[i]);
                    if(current.size()>=2){
                        result.add(current);
                        current = new ArrayList<>(current);
                    }
                    dfs(i + 1, nums, result);
                    current.remove(current.size() - 1);
                    if (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                        i++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int[] a = {4, 6, 7, 7};
        System.out.println(new Solution().findSubsequences(a));
    }
}