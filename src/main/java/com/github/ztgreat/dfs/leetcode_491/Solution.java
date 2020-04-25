package com.github.ztgreat.dfs.leetcode_491;


import java.util.*;

class Solution {

    List<Integer> current;
    Set<List<Integer>> filter;
    public List<List<Integer>> findSubsequences(int[] nums) {

        if (nums == null || nums.length == 0 || nums.length == 1) {
            return Collections.emptyList();
        }
        List<List<Integer>> result = new ArrayList<>();
        current = new ArrayList<>();
        filter = new HashSet<>();
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
                // 剪枝
                if ((current.size() + (nums.length - i) >= 2)) {
                    if(current.isEmpty()  || current.get(current.size()-1)<=nums[i]  ){
                        current.add(nums[i]);
                        if(current.size()>=2  && !filter.contains(current)){
                            result.add(current);
                            filter.add(current);
                            current = new ArrayList<>(current);
                        }
                        dfs(i + 1, nums, result);
                        current.remove(current.size() - 1);
                    }
                }
            }
        }
    }
}