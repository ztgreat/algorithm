package com.github.ztgreat.dfs.leetcode_872;


import java.util.ArrayList;
import java.util.List;

/**
 * 判断两颗树 叶子节点是否一致
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer>res1= new ArrayList<Integer>(100);
        List<Integer>res2= new ArrayList<Integer>(100);
        travelTree(root1,res1);
        travelTree(root2,res2);
        return res1.equals(res2);
    }
    public List<Integer> travelTree(TreeNode root,List<Integer>res) {
        if(root==null){
            return res;
        }
        if(root.left!=null){
            travelTree(root.left,res);
        }
        if(root.right!=null){
            travelTree(root.right,res);
        }
        if(root.left == root.right && root.left==null){
            res.add(root.val);
        }
        return res;
    }
 }