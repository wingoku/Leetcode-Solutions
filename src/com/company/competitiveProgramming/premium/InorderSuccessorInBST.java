package com.company.competitiveProgramming.premium;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /**
     In order to find the inOrder successor from a certain node, there are 2 things to consider.

     1. Find P node
     2. Than if P node has right node than take the right node and then traverse the left subtree of that right node
     until we reach leaf node
     The successor of a node p is the node with the smallest key greater than p.val.

     and every step of the way keep assuming the currentNode whose value is greater than p node value is our in order successor. The reason we
     make this assumption to set currentNode as inOrderSuccessor when currentNode value > pNode val, is because
     inOrder successor will always be greater than p nodes value
     */

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {

        // iterative();
        dfs(root, p);
        return successor;
    }

    private TreeNode iterative(TreeNode node, TreeNode p) {
        TreeNode successor = null;

        while(node != null) {
            if(p.val < node.val) {
                successor = node;
                node = node.left;
            }
            else
                node = node.right;
        }

        return successor;
    }

    TreeNode successor = null;
    private TreeNode dfs(TreeNode node, TreeNode p) {
        if(node == null)
            return null;

        // TreeNode successor = null;
        if(p.val < node.val) {
            successor = node;
            dfs(node.left, p);
        }
        else
            dfs(node.right, p);

        // if(successor == null) {
        //     if(node.val > p.val)
        //         return node;
        // }

        return successor;
    }
}