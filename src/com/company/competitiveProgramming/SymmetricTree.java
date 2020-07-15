package com.company.competitiveProgramming;

import com.sun.source.tree.Tree;

import java.util.*;

public class SymmetricTree {
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

    public TreeNode createDataSet(List<Integer> dataSet) {
        TreeNode rootNode = new TreeNode(1);
        rootNode.left = new TreeNode(2);
        rootNode.right = new TreeNode(2);

        rootNode.left.left = new TreeNode(4);
        rootNode.left.right = new TreeNode(4);

        rootNode.right.left = new TreeNode(4);
        rootNode.right.right = new TreeNode(3);

        return rootNode;
    }

    //leetcode 1ms
    //AMAZON CODING INTERVIEW
    public boolean isSymmetric(TreeNode root) {
        root = createDataSet(null);
        if(root == null)
            return true;
        boolean isValid = isSymmetric(root.left, root.right);
        System.out.println("is Symetrical: "+ isValid);

        return isValid;
    }

    /**
     * What we're checking here is if the left node's value == right node's value
     * AND
     * if left and right nodes have children,
     * we need to check if leftNode.left.value == rightNode.right.value && leftNode.right.value == rightNode.left.value
     *
     * We can also do this using breadthfirst search but that solution will be too complicated
     */
    private boolean isSymmetric(TreeNode left, TreeNode right) {
         if(left == null || right == null)
             return left == right; //we're doing left == right even for null cuz even though the references are null, they might be the same null object in both subtrees. Therefore if they are not the same null object in both subtrees, the tree won't be symmetric

         if(left.val != right.val)
             return false;

         return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}
