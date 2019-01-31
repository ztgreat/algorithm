package com.github.ztgreat.leetcode.problem_563;


/**
 * 判断一颗二叉树 中的元素是否完全一样
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    private Boolean flag;

    public boolean isUnivalTree(TreeNode root) {
        flag=true;
        if(root==null){
            return true;
        }
        isUnivalTree(root,root.val);
        return flag;
    }
    public void isUnivalTree(TreeNode root, int value) {

        if(root==null){
            return;
        }
        if(root.val != value){
            flag=false;
            return;
        }
        if (flag){
            isUnivalTree(root.left,value);
        }
        if (flag){
            isUnivalTree(root.right,value);
        }
    }
}