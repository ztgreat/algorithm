package com.github.ztgreat.leetcode.problem_590;


import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 后序遍历 n 叉树
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

    public List<Integer> postorder(Node root) {

        List<Integer>res = new LinkedList<Integer>();
        Stack<Node>stack=new Stack<Node>();
        Node p = root;
        if(root==null){
            return  res;
        }
        stack.push(p);
        while (!stack.isEmpty()){
            p=stack.peek();
            if(p.children!=null && p.children.size()>0){
                for (int i = p.children.size() - 1; i >= 0; i--) {
                    stack.push(p.children.get(i));
                }
                // 相比前序,增加这里
                p.children=null;
            }else{
                // 相比前序,增加这里
                res.add(p.val);
                stack.pop();
            }
        }
        return res;
    }
}