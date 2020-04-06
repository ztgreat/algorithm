package com.github.ztgreat.dfs.leetcode_111;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    /**
     * 前序遍历 + 减支
     */
    private int cnt;
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        cnt = Integer.MAX_VALUE;
        preOrder(root, 0, root);
        return cnt;
    }

    private void preOrder(TreeNode root, int deep, TreeNode parent) {

        if (root == null) {
            if (parent.left == null && parent.right == null) {
                cnt = Math.min(cnt, deep);
            }
            return;
        }
        if (cnt < deep) {
            return;
        }

        preOrder(root.left, deep + 1, root);
        preOrder(root.right, deep + 1, root);
    }
}