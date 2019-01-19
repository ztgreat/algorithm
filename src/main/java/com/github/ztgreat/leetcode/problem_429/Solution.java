package com.github.ztgreat.leetcode.problem_429;


import java.util.*;

/**
 * n 叉树 层次遍历
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
}
class Solution {

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Node>queue = new LinkedList<Node>();
        if(root ==null){
            return res;
        }
        queue.addFirst(root);
        Node p=null;
        int size=0;
        List<Integer> temp =null;
        while (!queue.isEmpty()){
            temp = new ArrayList<Integer>(queue.size());
            size = queue.size();
            for(int i=0;i<size;i++){
                p=queue.removeFirst();
                temp.add(p.val);
                if(p.children!=null  && p.children.size()>0){
                    for (Node pp : p.children){
                        queue.addLast(pp);
                    }
                }
            }
            res.add(temp);
        }
        return res;
    }
}