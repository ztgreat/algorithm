package com.github.ztgreat.leetcode.problem_226;


/**
 * 左右子树交换
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    public TreeNode invertTree(TreeNode root) {
        if(root==null) {
            return null;
        }
        //可以交换引用,也可以交换值
        TreeNode temp1=root.left;
        root.left=root.right;
        root.right=temp1;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}