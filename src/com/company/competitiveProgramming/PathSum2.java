package com.company.competitiveProgramming;


import java.util.ArrayList;
import java.util.List;

public class PathSum2 {

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

  public TreeNode createDataSet(List<Integer> dataSet) {
      TreeNode rootNode = new TreeNode(5);
      rootNode.left = new TreeNode(6);
      rootNode.right = new TreeNode(8);

      rootNode.left.left = new TreeNode(11);
      rootNode.left.right = null;

      rootNode.left.left.left = new TreeNode(7);
      rootNode.left.left.right = new TreeNode(0);

      rootNode.right.left = new TreeNode(13);
      rootNode.right.right = new TreeNode(4);
      rootNode.right.right.left = new TreeNode(5);
      rootNode.right.right.right = new TreeNode(1);
      return rootNode;

  }

  private List<List<Integer>> totalList;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        root = createDataSet(null);
        totalList = new ArrayList<>();
        preOrderTraversal(root, sum, 0, new ArrayList<>());
        return totalList;
    }

    private void preOrderTraversal(TreeNode root, int givenSum, int currentSum, List<Integer> currentList) {
        if(root == null)
            return;

        //adding current node's value to the list
        currentList.add(root.val);

        //checking if node is leaf cuz the requirement is that when the givenSum == calculatedSum, the node should be leaf node
        boolean isLeafNode = root.left == null && root.right == null;
        if(isLeafNode) {
            if(currentSum + root.val == givenSum) {
                //adding the current path that gives us giveSum == calculatedSum to the big list
                totalList.add(new ArrayList<>(currentList));

                //removing the current node from list cuz we're going back up from this node & we don't want this node in our path anymore for finding new path which results into givenSum == calculated sum
                currentList.remove(currentList.size()-1);
                return;
            }
        }

        //standard way of doing DFS using preorder traversal
        preOrderTraversal(root.left, givenSum, currentSum + root.val, currentList);
        preOrderTraversal(root.right, givenSum, currentSum + root.val, currentList);

        //removing the current node from list cuz we're going back up from this node & we don't want this node in our path anymore for finding new path which results into givenSum == calculated sum
        currentList.remove(currentList.size()-1);

        return;
    }
}
