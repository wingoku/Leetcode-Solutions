package com.company.competitiveProgramming.premium;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    /**
     https://www.youtube.com/watch?v=DeVu3Ra7sw4
     SOLUTION:

     We need to add boundaries in the list that means left boundaries, bottom boundaries and right boundaries

     leftBoundaries are the nodes that are on the left most side of the tree
     bottomBoundaries are the nodes that are at the bottom of the tree i-e; all the leaf nodes
     rightBoundaries are the nodes that are at the right most side of the tree

     1. In order to get the left boundary nodes,

     we traverse left side of the tree by doing preOrder dfs starting from the root.left node
     if root.left.left == null/ inside the tree node.right.right that means the leftBoundary nodes might be on the root.left.right.left.left... subtree
     Therefore we keep an if else condition and IF THE NODE IS NOT LEAF, we add it to the list

     2. In order to get the bottom boundary nodes i-e; all the leaf nodes,

     we go deep in the root.left subtree & root.right subtree and add all the leaf nodes in the list

     3. In order to get the right boundary nodes,

     we traverse the right side of the tree by doing postOrder dfs starting from root.right node.
     if root.right.right == null/ inside the tree node.right.right is null that means the right most boundary nodes must be in root.right.left... or node.left.right..

     therefore we've an if else condition
     */
    //TC: O(N)
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null)
            return list;

        list.add(root.val);

        dfsLeft(root.left, list);

        getLeafNodes(root.left, list);
        getLeafNodes(root.right, list);

        dfsRight(root.right, list);

        return list;
    }

    private void dfsLeft(TreeNode node, List<Integer> list) {
        if(node == null)
            return;

        if(!isLeaf(node))
            list.add(node.val);

        if(node.left != null) //if node.left is not null that means the left boundary nodes are in the left subtree of current node
            dfsLeft(node.left, list);
        else
            dfsLeft(node.right, list); //since left subtree of current node is null that means the left boundary nodes are in the right subtree of current node
    }

    private void dfsRight(TreeNode node, List<Integer> list) {
        if(node == null)
            return;

        if(node.right != null)
            dfsRight(node.right, list);//since left subtree of current node is null that means the left boundary nodes are in the right subtree of current node
        else
            dfsRight(node.left, list);//if node.left is not null that means the left boundary nodes are in the left subtree of current node

        if(!isLeaf(node)) {
            list.add(node.val);
        }
    }

    private void getLeafNodes(TreeNode node, List<Integer> list) {
        if(node == null)
            return;

        if(isLeaf(node))
            list.add(node.val);

        getLeafNodes(node.left, list);
        getLeafNodes(node.right, list);
    }

    private boolean isLeaf(TreeNode node) {
        if(node == null)
            return true;

        return node.left == null && node.right == null;
    }
}