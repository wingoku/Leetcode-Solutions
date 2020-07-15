package com.company.competitiveProgramming;

public class MaximumDepthOfBinaryTree {
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

    private int maxDepth = 1;
    //accepted leetcode solution. 0MS
    //AMAZON CODING INTERVIEW
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        findMaxDepth(root, 1);
        return maxDepth;
    }

    private void findMaxDepth(TreeNode root, int currentMaxDepth) {
        if(root == null) {
            return;
        }

        if(root.left == null && root.right == null && currentMaxDepth > maxDepth) {
            maxDepth = currentMaxDepth;
        }

        findMaxDepth(root.left, currentMaxDepth+1);
        findMaxDepth(root.right, currentMaxDepth+1);

        return;
    }
}
