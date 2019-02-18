package com.github.ztgreat.leetcode.problem_993;


/**
 * 判断两个节点 深度是否相同，并且其父节点不同
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    private TreeNode node;
    public boolean isCousins(TreeNode root, int x, int y) {

        dfs(root,null,x,0);
        TreeNode nodex = new TreeNode(node.val);
        nodex.left=node.left;

        node=null;

        dfs(root,null,y,0);
        TreeNode nodey = new TreeNode(node.val);
        nodey.left=node.left;
        if(nodex.val == node.val  && nodex.left != node.left){
            return true;
        }
        return false;
    }
    public void dfs(TreeNode root, TreeNode parent,int x,int deep) {

        if(root==null){
            return;
        }
        if(root.val==x){
            node=new TreeNode(deep);
            node.left=parent;
            return;
        }
        if(node==null){
            dfs(root.left,root,x,deep+1);
            dfs(root.right,root,x,deep+1);
        }
    }
}