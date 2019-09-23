package com.github.ztgreat.leetcode.problem_938;



class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    public int rangeSumBST(TreeNode root, int L, int R) {
        return order(root,L,R);
    }

    // 中序遍历
    public int order(TreeNode root, int L, int R){
        if(root==null){
            return 0;
        }
        int sum=order(root.left,L,R);
        if(root.val>=L && root.val<=R){
            sum+=root.val;
        }
        sum+=order(root.right,L,R);
        return sum;

    }
}