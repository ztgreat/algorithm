package com.github.ztgreat.leetcode.problem_538;


/**
 * 思路:
 * 既然是一颗bst,那么中序遍历结果,就是一个有序 序列
 * 比该节点大的值,一定在其右边，因此递归的方式可以先从右子树出发,
 * 进行中序遍历,在回溯的过程中记录更新值
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
public class Solution {

    private  int sum =0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null){
            return null;
        }
        convertBST(root.right);
        sum +=root.val;
        root.val=sum;
        convertBST(root.left);
        return root;
    }


}
