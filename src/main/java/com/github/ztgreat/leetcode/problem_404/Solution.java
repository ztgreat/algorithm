package com.github.ztgreat.leetcode.problem_404;


/**
 * 计算二叉树中左叶子结点和
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    private int sum;

    public int sumOfLeftLeaves(TreeNode root) {
        sum=0;
        sumOfLeftLeaves(root,null);
        return sum;
    }

    public void sumOfLeftLeaves(TreeNode root,TreeNode parent) {

        if(root==null){
            return;
        }
        sumOfLeftLeaves(root.left,root);
        sumOfLeftLeaves(root.right,root);
        if(root.left == root.right && root.left == null){
            if(parent!=null && parent.left == root){
                sum+=root.val;
            }
        }
    }
}