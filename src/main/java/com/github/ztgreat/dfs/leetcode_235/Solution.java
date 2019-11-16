package com.github.ztgreat.dfs.leetcode_235;


/**
 * 最近公共祖先-lca 问题
 * 这里是bst 树,要简单很多
 * lca 问题有很多解决方法:
 * Tarjan算法,线段树
 *
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if(root==null){
            return null;
        }
        if(p.val>q.val){
            int temp=p.val;
            p=new TreeNode(q.val);
            q=new TreeNode(temp);
        }

        if(root.val>p.val && root.val<q.val){
            return root;
        }
        else if(root.val > p.val && root.val >q.val){
            return lowestCommonAncestor(root.left,p,q);
        }

        else if(root.val < p.val && root.val <q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
    }
}