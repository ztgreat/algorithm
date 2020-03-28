package com.github.ztgreat.dfs.leetcode_337.leetcode_199;


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public int rob(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // 选
        int ans1 = dfs(root, true);

        // 不选
        int ans2 = dfs(root, false);
        ans1 = Math.max(ans1, ans2);

        return ans1;
    }

    public int dfs(TreeNode root, boolean select) {

        int ans = 0;
        if (root == null) {
            return ans;
        }

        // 选 root
        if (select) {
            ans += root.val;
            ans = ans + dfs(root.right, false) + dfs(root.left, false);
            return ans;
        } else {
            int t1 = dfs(root.right, false);
            int t2 = dfs(root.right, true);
            if (t1 < t2) {
                t1 = t2;
            }

            int t3 = dfs(root.left, false);
            int t4 = dfs(root.left, true);
            if (t3 < t4) {
                t3 = t4;
            }
            return t1 + t3;
        }
    }

}