package com.github.ztgreat.dfs.leetcode_116;


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

class Solution {


    public Node connect(Node root) {

        if (root == null) {
            return root;
        }
        connect(null, root);
        return root;
    }

    public void connect(Node parent, Node root) {

        if (root == null) {
            return;
        }

        // 利用父节点next 指针去 找子节点next域
        if (root.next == null && parent != null && parent.next != null) {
            root.next = parent.next.left;
        }

        if (root.left != null) {
            root.left.next = root.right;
        }
        connect(root, root.left);
        connect(root, root.right);


    }
}