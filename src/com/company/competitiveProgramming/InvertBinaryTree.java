package com.company.competitiveProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
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
     According to the given example, we just have to swap places of left and right nodes

     so when we're iterating over the tree using BFS, just assign node.left = node.right and node.right = node.left
     The reason for using bfs is cuz it's easier to understand doing calling invert()
     */
    //TC: O(N) cuz we're just iterating over the nodes once
    //SC: O(1) cuz we're not creating new nodes however if we account queue memory consumption than overall SC would be O(N) cuz all the nodes of the tree would end up in the queue during iteration
    public TreeNode invertTree(TreeNode root) {

        if(root == null)
            return null;

        bfs(root);

        return root;
    }

    private void bfs(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        while(!q.isEmpty()) {
            TreeNode node = q.poll();

            invert(node);

            if(node.left != null) {
                q.add(node.left);
            }

            if(node.right != null) {
                q.add(node.right);
            }
        }
    }

    private void invert(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
