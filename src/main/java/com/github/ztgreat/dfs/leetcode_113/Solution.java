package com.github.ztgreat.dfs.leetcode_113;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    //　用于保存当前遍历　存放的序列
    private int[] current;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

        //　预估的树高度
        current = new int[10000];
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, 0, sum, ans, 0);
        return ans;
    }

    public void dfs(TreeNode root, int sum, int targetSum, List<List<Integer>> ans, int deepth) {

        if (root == null) {
            return;
        }
        current[deepth] = root.val;
        if (root.left == null && root.right == null && sum + root.val == targetSum) {
            List<Integer> temp = new ArrayList<>(deepth);
            for (int i = 0; i <= deepth; i++) {
                temp.add(current[i]);
            }
            ans.add(temp);
            return;
        }
        dfs(root.left, sum + root.val, targetSum, ans, deepth + 1);
        dfs(root.right, sum + root.val, targetSum, ans, deepth + 1);
    }
}