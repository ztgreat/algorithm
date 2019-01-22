package com.github.ztgreat.leetcode.problem_606;


/**
 * 将一个颗树 拼成一个字符串表达式
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    //StringBuffer 线程安全
    //StringBuilder 线程不安全
    //不要使用 String "+" 连接符
    private StringBuilder builder;
    public String tree2str(TreeNode t) {
        builder = new StringBuilder();
        travelTree(t);
        return builder.toString();
    }

    public void travelTree(TreeNode root) {

        if(root==null)
            return;
        builder.append(root.val);
        if(root.left!=null){
            builder.append("(");
            travelTree(root.left);
            builder.append(")");
        }else if(root.right!=null){
            builder.append("()");
        }
        if(root.right!=null){
            builder.append("(");
            travelTree(root.right);
            builder.append(")");
        }
    }
}