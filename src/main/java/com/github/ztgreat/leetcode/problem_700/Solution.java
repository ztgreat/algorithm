package com.github.ztgreat.leetcode.problem_700;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 前序遍历 n 叉树
 * tips:题目不建议用递归方式
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

    public List<Integer> preorder(Node root) {

        List<Integer>res = new LinkedList<Integer>();
        Stack<Node>stack=new Stack<Node>();
        Node p = root;
        if(root==null){
            return  res;
        }
        stack.push(p);
        while (!stack.isEmpty()){
            p=stack.pop();
            res.add(p.val);
            if(p.children!=null){
                for (int i = p.children.size() - 1; i >= 0; i--) {
                    stack.push(p.children.get(i));
                }
            }
        }
        return res;
    }
}