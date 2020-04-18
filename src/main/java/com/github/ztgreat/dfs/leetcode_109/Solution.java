package com.github.ztgreat.dfs.leetcode_109;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode sortedListToBST(ListNode head) {

        if (head == null) {
            return null;
        } else if (head.next == null) {
            return new TreeNode(head.val);
        }

        // 找中间节点
        ListNode pre = head;
        ListNode q = pre.next.next;
        while (q != null && q.next != null) {
            pre = pre.next;
            q = q.next.next;
        }
        ListNode p = pre.next;
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;

    }


}