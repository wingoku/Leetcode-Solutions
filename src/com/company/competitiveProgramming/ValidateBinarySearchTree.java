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
    private boolean atRootNode = true;
    private int rootNodeValue = -1;
    public boolean isValidBST(TreeNode root) {

        root = createDataSet(null);
        if(root == null)
            return true;
        rootNodeValue = root.val;
        boolean isValid = checkIfBST(root, -Double.MAX_VALUE, Double.MAX_VALUE);
        return isValid;
    }

    private boolean checkIfBST(TreeNode root, double minValue, double maxValue) {
        if(root == null)
            return true;

        if(root.val > minValue && root.val < maxValue
           && checkIfBST(root.left, minValue, root.val)
           && checkIfBST(root.right, root.val, maxValue))
            return true;

        return false;
    }
}
