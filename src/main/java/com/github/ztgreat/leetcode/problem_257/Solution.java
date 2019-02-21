package com.github.ztgreat.leetcode.problem_257;


import java.util.ArrayList;
import java.util.List;

/**
 * 遍历出 根节点到所有叶子结点的路径
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {


    public List<String> binaryTreePaths(TreeNode root) {

        List<String>res= new ArrayList<String>();
        paths(root,res,"");
        return res;
    }

    public void paths(TreeNode root,List res,String path){

        if(root==null){
            return;
        }
        if(root.left!=null){
            if(path.equals("")){
                paths(root.left,res,String.valueOf(root.val));
            }else{
                paths(root.left,res,path+"->"+root.val);
            }
        }
        if(root.right!=null){
            if(path.equals("")){
                paths(root.right,res,String.valueOf(root.val));
            }else{
                paths(root.right,res,path+"->"+root.val);
            }
        }

        //叶子节点
        if(root.left == root.right && root.left==null){
            if(path.equals("")){
                res.add(String.valueOf(root.val));
            }else{
                res.add(path+"->"+root.val);
            }
        }
    }
}