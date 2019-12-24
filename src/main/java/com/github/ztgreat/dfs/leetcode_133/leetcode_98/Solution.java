package com.github.ztgreat.dfs.leetcode_133.leetcode_98;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
    }

    public Node(int _val, List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

class Solution {

    // 用于记录 是否访问过，因为节点的数据可能为负数，因此这里不使用数组
    private HashMap<Integer, Node> map;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Node root = new Node();
        root.neighbors = new ArrayList<>();
        map = new HashMap<>(128);
        dfs(root, node);
        return root;
    }

    public void dfs(Node root, Node target) {

        if (target == null) {
            return;
        }
        map.put(target.val, root);
        root.val = target.val;
        if (target.neighbors == null || target.neighbors.isEmpty()) {
            return;
        }
        for (Node node : target.neighbors) {

            // 判断是否访问过
            if (map.get(node.val) != null) {
                root.neighbors.add(map.get(node.val));
                continue;
            }
            Node temp = new Node();
            temp.neighbors = new ArrayList<>();
            root.neighbors.add(temp);
            dfs(temp, node);
        }
    }
}