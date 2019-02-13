package com.github.ztgreat.leetcode.problem_107;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 层次遍历 倒过来
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res= new LinkedList<List<Integer>>();
        search(res,root,0);
        Collections.reverse(res);
        return res;
    }

    public void search(List<List<Integer>> v, TreeNode root, int cnt){
        if(root==null)
            return;
        if(v.size()==cnt) {
            List<Integer>vv=new LinkedList<Integer>();
            v.add(vv);
        }
        v.get(cnt).add(root.val);
        search(v,root.left,cnt+1);
        search(v,root.right,cnt+1);
    }
}