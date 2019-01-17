package com.github.ztgreat.leetcode.problem_700;


/**
 * 给定一个元素,如果该二叉树中有该元素,那么返回以该元素为根的子树
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        TreeNode temp = searchBST(root.left,val);
        if(temp==null){
            temp=searchBST(root.right,val);
        }
        return  temp;
    }
}