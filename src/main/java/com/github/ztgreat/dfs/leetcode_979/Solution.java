package com.github.ztgreat.dfs.leetcode_979;


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

    public int distributeCoins(TreeNode root) {

        ans = 0;
        order(root);
        return ans;
    }

    // 后序遍历
    public int order(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int l = order(root.left);
        int r = order(root.right);

        if (root.left != null) {

            if (root.left.val == 0) {
                root.val -= 1;

            }

            if (root.left.val > 1) {
                root.val -= (root.left.val - 1);
            }

        }


        return l;
    }
}