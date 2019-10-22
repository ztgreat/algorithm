package com.github.ztgreat.dfs.leetcode_559;


import java.util.List;

/**
 * n 叉树 最大深度
 */
class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}

class Solution {

    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        return maxDepth(root, 1);
    }

    public int maxDepth(Node root, Integer deep) {

        if (root == null) {
            return deep;
        }
        Integer temp;
        Integer temp2 = deep;
        for (int i = root.children.size() - 1; i >= 0; i--) {
            temp = maxDepth(root.children.get(i), deep + 1);
            if (temp > temp2) {
                temp2 = temp;
            }
        }
        return temp2;
    }
}