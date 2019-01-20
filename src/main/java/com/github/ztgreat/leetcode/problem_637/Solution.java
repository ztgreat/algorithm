package com.github.ztgreat.leetcode.problem_637;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 层次遍历 求平均数
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    public List<Double> averageOfLevels(TreeNode root) {

        List<Double> res = new ArrayList<Double>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if(root ==null){
            return res;
        }
        queue.addFirst(root);
        TreeNode p=null;
        int size=0;
        List<Integer> temp =null;
        double sum=0;
        while (!queue.isEmpty()){
            temp = new ArrayList<Integer>(queue.size());
            size = queue.size();
            for(int i=0;i<size;i++){
                p=queue.removeFirst();
                temp.add(p.val);
                if(p.left!=null){
                    queue.addLast(p.left);
                }
                if(p.right!=null){
                    queue.addLast(p.right);
                }
            }
            sum=0;
            for (Integer d : temp){
                sum+=d.intValue();
            }
            res.add((sum*1.0)/(temp.size()));
        }
        return res;
    }
}