package com.github.ztgreat.leetcode.problem_671;


/**
 * 第二最小的数
 * 坑点:左右子树的值可能相同
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    private int a;
    private int b;
    public int findSecondMinimumValue(TreeNode root) {
        a=1000000000;
        b=1000000000;
        search(root);
        if(b==1000000000){
            b=-1;
        }
        return b;
    }

    public void search(TreeNode root){

        if(root==null){
            return;
        }
        search(root.right);
        search(root.left);
        if(a>root.val){
            b=a;
            a=root.val;
        }
        if(root.val!=a &&  b>root.val){
            b=root.val;
        }
    }
}