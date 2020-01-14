package com.github.ztgreat.dfs.leetcode_199;


import java.util.ArrayList;
import java.util.List;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

/**
 * 优先遍历右子树
 * 遍历的时候记录深度信息，如果是最新的深度则需要记录结果
 */
class Solution {

    private Integer maxRightDepth;
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        maxRightDepth = -1;
        rightSideView(root, ans, 0);
        return ans;
    }

    public void rightSideView(TreeNode root, List<Integer> ans, int depth) {

        if (root == null) {
            return;
        }
        if (maxRightDepth < depth) {
            maxRightDepth = depth;
            ans.add(root.val);
        }
        rightSideView(root.right, ans, depth + 1);
        rightSideView(root.left, ans, depth + 1);
    }
}