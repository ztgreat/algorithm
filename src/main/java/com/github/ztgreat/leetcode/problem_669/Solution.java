package com.github.ztgreat.leetcode.problem_669;


/**
 * 给定一颗bst树,给定一个区间[L,R],bst树中只保留在这个区间的元素
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    private  TreeNode newRoot;
    public TreeNode trimBST(TreeNode root, int L, int R) {

        newRoot=null;
        travelTree(root,L,R);
        return newRoot;

    }

    public void travelTree(TreeNode root, int L, int R) {

        if(root ==null){
            return;
        }
        if(root.val >=L  && root.val<=R){
            if(newRoot ==null){
                newRoot = new TreeNode(root.val);
            }else{
                //采取的是新建树,这样比较简单
                //也可以直接在原来的树上进行修改,这样会高效点
                buildTree(newRoot,new TreeNode(root.val));
            }
        }
        travelTree(root.left,L,R);
        travelTree(root.right,L,R);
    }

    public void buildTree(TreeNode root,TreeNode p) {

        if(root==null){
            return;
        }
        if(root.val>=p.val){
            if(root.left==null){
                root.left=p;
                return;
            }
            buildTree(root.left,p);
        }else{
            if(root.right==null){
                root.right=p;
                return;
            }
            buildTree(root.right,p);
        }
    }

}