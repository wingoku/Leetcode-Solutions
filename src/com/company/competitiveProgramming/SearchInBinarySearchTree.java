package com.company.competitiveProgramming;

public class SearchInBinarySearchTree {
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * IDEA behind solution.
     *
     * We traverse left & right subtrees until we find the node with value we desire. Than we return that node & every recursive call in the execution stack will get the same node in return value
     * & at the end we return the node when reach the recursive call when we reach the root of the node
     */
    //leetcode accepted
    //url: https://leetcode.com/problems/search-in-a-binary-search-tree/
    //recursion
    public TreeNode searchBST(TreeNode root, int val) {
        TreeNode foundNode = dfs(root, val);
        return foundNode;
    }

    private TreeNode dfs(TreeNode node, int val) {
        if(node == null)
            return null;

        if(node.val == val)
            return node;

        TreeNode resultFromLeftSubtree = dfs(node.left, val);
        TreeNode resultFromRightSubtree = dfs(node.right, val);

        if(resultFromLeftSubtree != null)
            return resultFromLeftSubtree;
        else
        if(resultFromRightSubtree != null)
            return resultFromRightSubtree;

        return null;
    }
}
