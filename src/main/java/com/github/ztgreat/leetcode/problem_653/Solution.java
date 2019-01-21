package com.github.ztgreat.leetcode.problem_653;


import java.util.HashSet;

/**
 * 在一颗bst 中,给定一个元素k,判断bst 中是否有两个元素的和等于k
 *
 * 方法很多,bst 树 是有序的,可以进行减枝优化,我这里就做得很随意了
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    private boolean flag;
    public boolean findTarget(TreeNode root, int k) {
        flag=false;
        HashSet<Integer>elements = new HashSet<Integer>();
        travelTree(root,k,elements);
        return flag;
    }

    public void travelTree(TreeNode root, int k, HashSet<Integer>elements) {

        if(root ==null){
            return;
        }
        if(elements.contains(k-root.val)){
            flag=true;
            return;
        }else {
            elements.add(root.val);
        }
        if(!flag){
            travelTree(root.left,k,elements);
            travelTree(root.right,k,elements);
        }
    }
}