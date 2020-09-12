package com.company.competitiveProgramming;

import java.util.List;

public class ValidateBinarySearchTree {
    public class TreeNode {
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

    public TreeNode createDataSet(List<Integer> dataSet) {
        TreeNode rootNode = new TreeNode(0);
        /*rootNode.left = new TreeNode(5);
        rootNode.right = new TreeNode(15);

        rootNode.right.left = new TreeNode(6);
        rootNode.right.right =  new TreeNode(20);*/

        return rootNode;

    }

    //revise
    //amazon coding interview
    public boolean isValidBST(TreeNode root) {

        root = createDataSet(null);
        if(root == null)
            return true;
        boolean isValid = isBST(root, null, null);
        return isValid;
    }
    /**
     The idea is to check if each node in the tree lies within a range.
     The range is defined by the following rules:

     1. The left side should be less than its parent
     2. The right side should be greater than its parent
     ---- ESSENTIAL REQUIREMENT ----
     3. Left subtree should be less than the root node in the tree
     4. Right subtree should be greater than the root node in the tree

     The gist condition is: if a node is less or greater than min or max respectively, it's not a BST

     CODE CONDITION:
     if(node.val < min || node.val > max)
     return false; //cuz these condition shouldn't be true for a BST

     Now the question is: how can we keep track of root node at all times based on the constraint that's which subtree (from root node)
     is being traversed at the moment

     Therefore when we make a recursive call for traversing left side, we set the max value
     &
     when we make a recursive call for traversing right side, we set the min value

     However what would be do when we're traversing left & right subtree of another subtree since that subtree could be
     in the left or right subtree with respect to the root node


     */

    private boolean isBST(TreeNode root, Integer max, Integer min) {
        if(root == null)
            return true;

        if(max != null && root.val > max
                ||
                min != null && root.val < min
        )
            return false;

        return isBST(root.left, root.val, min) && isBST(root.right, max, root.val);
    }
}
