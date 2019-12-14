package com.github.ztgreat.dfs.leetcode_129;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private int ans;
    public int sumNumbers(TreeNode root) {
        ans = 0;
        dfs(root, 0);
        return ans;
    }

    public void dfs(TreeNode root, int current) {
        if (root == null) {
            return;
        }
        dfs(root.left, current * 10 + root.val);
        dfs(root.right, current * 10 + root.val);
        if (root.left == null && root.right == null) {
            ans += current * 10 + root.val;
        }
    }
}