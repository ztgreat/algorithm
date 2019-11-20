package com.github.ztgreat.dfs.leetcode_979;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 多的就要移走
 * 不够的就要先欠着 为 -1
 */
class Solution {

    private int ans;

    public int distributeCoins(TreeNode root) {

        ans = 0;
        postOrder(root);
        return ans;
    }

    // 后序遍历
    private void postOrder(TreeNode root) {

        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        if (root.left != null) {
            cal(root, root.left);
        }
        if (root.right != null) {
            cal(root, root.right);
        }
    }

    private void cal(TreeNode root, TreeNode child) {

        if (child.val == 0) {
            root.val -= 1;
            ans++;
        }
        if (child.val > 1) {
            root.val += (child.val - 1);
            ans += (child.val - 1);
        }
        if (child.val < 0) {
            root.val += (child.val - 1);
            ans += Math.abs(child.val) + 1;
        }
    }
}