package com.company.competitiveProgramming;

import java.util.List;

public class MaxDepthOfTree {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    //leet code accepted solutoin
    //0ms
    //Google Coding interview. It's asked during phone screening
    public int maxDepth(Node root) {
        if(root == null)
            return 0;

        int maxDepth = dfs(root, 0);
        System.out.println("maxDepth: "+ (maxDepth+1));
        return maxDepth+1; //If the root node is null, then it’s depth is 0. If it is a leaf node, then its depth (counting itself as well) is 1.
    }

    private int dfs(Node root, int level) {
        if(root == null)
            return level;

        int maxDepth = level;
        for(Node node : root.children) {
            int maxLevelForThisChild = dfs(node, level+1);
            maxDepth = Math.max(maxDepth, maxLevelForThisChild);
        }

        return maxDepth;
    }
}
