package com.github.ztgreat.leetcode.problem_563;


/**
 * 对于二叉树中的每一个节点,计算其左右子树节点和 的差值(绝对值),累加
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    private  int sum =0;
    public int findTilt(TreeNode root) {
        sum=0;
        postorder(root);
        return sum;
    }
    /**
     * 后序遍历
     * @param root
     * @return
     */
    public int postorder(TreeNode root) {

        if(root==null){
            return 0;
        }
        if(root.left == root.right && root.left ==null){
            return root.val;
        }
        int left=postorder(root.left);
        int right=postorder(root.right);

        if(left>=right){
            sum+=left-right;
        }else{
            sum+=right-left;
        }
        return left+right+root.val;
    }
}