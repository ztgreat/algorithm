package com.github.ztgreat.dfs.leetcode_114;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {


    // 临时指针
    private TreeNode temp;
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        temp = root;
        // 切分根左右两个子树
        TreeNode rl = root.left;
        TreeNode rr = root.right;
        root.right = null;
        root.left = null;
        dfs(rl);
        dfs(rr);

    }

    public void dfs(TreeNode root) {

        if (root == null) {
            return;
        }

        //　注意这里要先记录l,r 不然后续会出问题
        TreeNode l = root.left;
        TreeNode r = root.right;
        temp.right = root;
        temp = root;
        dfs(l);
        root.left = null;
        dfs(r);
    }

}