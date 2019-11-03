package com.github.ztgreat.dfs.leetcode_100;


/**
 * 判断两颗二叉树 是否相同
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if((p==null && q!=null) ||(p!=null && q==null)) {
            return false;
        }
        if(p.val==q.val) {
            if(isSameTree(p.left,q.left)) {
                return isSameTree(p.right,q.right);
            }
            return false;
        }
        else {
            return false;
        }
    }
}