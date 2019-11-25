package com.github.ztgreat.dfs.leetcode_112;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public boolean hasPathSum(TreeNode root, int sum) {

        return preOrder(root, 0, sum);

    }

    private boolean preOrder(TreeNode root, int currentSum, int sum) {

        if (root == null) {
            return false;
        }
        if (currentSum > sum) {
            //return false;
        }
        boolean flag1 = preOrder(root.left, currentSum + root.val, sum);
        boolean flag2 = preOrder(root.right, currentSum + root.val, sum);

        if (flag1 || flag2) {
            return true;
        }

        if (root.left == null && root.right == null && root.val + currentSum == sum) {
            return true;
        }
        return false;
    }
}