package com.github.ztgreat.dfs.leetcode_108;


/**
 * 已经排好序的数组，转化为一颗二叉搜索树。
 * 高度平衡的二叉搜索数，要求平衡因子不大于1。
 */
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

class Solution {

    public TreeNode sortedArrayToBST(int[] nums) {

        int num = nums.length;
        if(num==0){
            return null;
        }
        TreeNode root=new TreeNode(0);
        buildTree(root,nums,0,num-1);
        return root;
    }

    /**
     * 递归二分建树
     * @param root
     * @param nums
     * @param start
     * @param end
     */
    public void buildTree(TreeNode root,int[] nums,int start,int end) {

        if (start==end){
            root.val = nums[start];
            return;
        }
        if(start<end){
            int mid = (end+start)/2;
            root.val=nums[mid];
            if(start<=mid-1){
                root.left = new TreeNode(0);
                buildTree(root.left,nums,start,mid-1);
            }
            if(mid+1<=end){
                root.right = new TreeNode(0);
                buildTree(root.right,nums,mid+1,end);
            }
        }
    }
}