package com.github.ztgreat.dfs.leetcode_99;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    private TreeNode t1;
    private TreeNode t2;
    private TreeNode last;

    /**
     * 中序 遍历 搜索树,记录不正确的节点
     */
    public void recoverTree(TreeNode root) {

        t1 = null;
        t2 = null;
        last = null;
        inOrder(root);
        if (t1 != null && t2 != null) {
            int x = t1.val;
            t1.val = t2.val;
            t2.val = x;
        }
    }

    public void inOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        inOrder(root.left);

        if (last != null && root.val < last.val) {
            if (t1 == null) {
                t1 = last;
                t2 = root;
            } else {
                t2 = root;
            }
        }
        last = root;
        inOrder(root.right);
    }
}