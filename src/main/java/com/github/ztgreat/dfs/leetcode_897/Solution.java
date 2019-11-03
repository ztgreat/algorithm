package com.github.ztgreat.dfs.leetcode_897;


/**
 * 将一颗二叉树 转换成一个 有序的只有右孩子的树
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    private  TreeNode newRoot;
    private  TreeNode p;
    public TreeNode increasingBST(TreeNode root) {
        newRoot=null;
        p=null;
        travelTree(root);
        return newRoot;
    }

    /**
     * 中序遍历,遍历的过程中,重建树（修改指针）
     * @param root
     */
    public void travelTree(TreeNode root) {

        if(root==null){
            return;
        }
        travelTree(root.left);
        if(newRoot ==null){
            newRoot =root;
            p=newRoot;
        }else{
            p.right=root;
            p=root;
        }
        p.left=null;
        travelTree(root.right);
    }
}