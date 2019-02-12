package com.github.ztgreat.leetcode.problem_563;


/**
 * 树直径问题
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private int deep;
    public int diameterOfBinaryTree(TreeNode root) {
        deep=0;
        search(root);
        return deep;
    }

    public int search(TreeNode root){
        if(root==null){
            //倒过来计数
            return 0;
        }
        int left = search(root.left);
        int right = search(root.right);

        if(left+right>deep){
            deep=left+right;
        }
        return left > right ? left + 1 : right + 1;
    }
}