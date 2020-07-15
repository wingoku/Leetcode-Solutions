package com.company.competitiveProgramming;


public class PathSum {
    
//      Definition for a binary tree node.
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

      //accepted leetcode 1ms
    //AMAZON CODING INTERVIEW
    public boolean hasPathSum(TreeNode root, int sum) {
        return preOrderTraversal(root, sum, 0, false);
    }

    //we're doing DFS to find the leaf node such that sum of values from rootNode to that leaf node == given sum
    private boolean preOrderTraversal(TreeNode root, int givenSum, int currentSum, boolean sumFound) {
        if(root == null || sumFound)
           return sumFound;

        currentSum += root.val;
        boolean isLeafNode = root.left == null & root.right == null;
        if(isLeafNode)
            if(currentSum == givenSum) {
                return true;
            }
            else
                currentSum -= root.val;

        sumFound = preOrderTraversal(root.left, givenSum, currentSum, sumFound);
        sumFound = preOrderTraversal(root.right, givenSum, currentSum, sumFound);
        return sumFound;
    }
}
