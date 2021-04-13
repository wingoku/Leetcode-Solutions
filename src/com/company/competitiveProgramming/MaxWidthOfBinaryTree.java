package com.company.competitiveProgramming;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaxWidthOfBinaryTree {
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
        rootNode.left = new TreeNode(3);
        rootNode.right = new TreeNode(2);

        rootNode.left.left = new TreeNode(5);
        rootNode.left.right = new TreeNode(6);

        rootNode.right.left = null;
        rootNode.right.right = new TreeNode(9);
        return rootNode;

    }

    /**
     SOLUTION:
     The idea is to assign each node a value based on the child node finding formula for binary tree
     leftChild = 2 * parentIndex
     rightChild = 2 * parentIndex + 1

     The root node would be 1

     Than upon each level traversal, we take the difference between the values of the firstNode & lastNode value. The difference +1 is
     equal to the number of nodes on that level which is = with cuz width = no. of nodes on a level

     if we don't go with this approach
     Than think of 1 other solutions both of them are extremly complicated:
     1. If a level's left most node & right most nodes are present
     2. calculate the width of the tree by using the formula width = Math.pow(2, levelValue);
     3. It's complicated solution cuz if first node is missing or last node is missing and other nodes are present
     than we've to maintain states to calculate the level width wether using the formula or the number of nodes in the queue for that level
     */

    //tc: O(N) cuz we iterate over all the nodes only once
    //SC: O(N) cuz we add each node in the tree in the queue at some point
    public int widthOfBinaryTree(TreeNode root) {

        root = createDataSet(null);
        return maxWidth(root);
    }
    //SC: O(K) K is the max amount of nodes at a level
    private int maxWidth(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();

        //assigning the root node value = 1 cuz we're going to assign child nodes values based on the Tree node's child finding formula
        root.val = 1;
        q.add(root);

        int maxWidth = 1;

        TreeNode firstNodeAtLevel = null;
        TreeNode lastNodeAtLevel = null;

        while(!q.isEmpty()) {
            int levelSize = q.size();

            //resetting first and last node for this current level
            firstNodeAtLevel = null;
            lastNodeAtLevel = null;

            for(int i=0; i<levelSize; i++) {
                TreeNode node = q.poll();

                if(firstNodeAtLevel == null) {
                    firstNodeAtLevel = node;
                }
                else {
                    //the very last time this iteration runs for a particular level, lastNodeAtLevel will contain reference to node.
                    //later we'll use values of firstNodeAtLevel and lastNodeAtLevel to calculate the width of a level
                    lastNodeAtLevel = node;
                }

                if(node.left != null) {
                    node.left.val = getNodeIndex(node.val, true);
                    q.add(node.left);
                }

                if(node.right != null) {
                    node.right.val = getNodeIndex(node.val, false);
                    q.add(node.right);
                }
            }

            //check if either of them are null than we can't calculate the level width. LastNodeAtLevel will be null at the zeroth level meaning soon after we pop the root node or if a tree is a linked list like [1,3,null,5,null,6,null,7]
            if(firstNodeAtLevel != null && lastNodeAtLevel != null) {
                int levelWidth = lastNodeAtLevel.val - firstNodeAtLevel.val +1;
                maxWidth = Math.max(maxWidth, levelWidth);
            }
        }
        return maxWidth;
    }

    //gives left & right node's index based on the parent's index value
    private int getNodeIndex(int parentIndex, boolean isLeft) {
        if(isLeft) {
            return 2 * parentIndex;
        }
        else {
            //right node
            return 2 * parentIndex +1;
        }
    }
}
