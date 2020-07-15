package com.company.competitiveProgramming;

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
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
        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(9);
        rootNode.right = new TreeNode(20);

        rootNode.right.left = new TreeNode(15);
        rootNode.right.right = new TreeNode(7);

        return rootNode;
    }

    //leetcode accepted solution. 1ms
    //AMAZON coding interview
    public List<List<Integer>> levelOrder(TreeNode root) {


        root = createDataSet(null);

        if(root == null)
            return new ArrayList<>();
        List<List<Integer>> value = breadthFirstSearch(root);
        return breadthFirstSearch(root);
    }

    private List<List<Integer>> breadthFirstSearch(TreeNode root) {
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        nodesQueue.add(null);

        List<List<Integer>> nodesNumbersList = new ArrayList<>();
        List<Integer> subsetList = new ArrayList<>();
        int level=0;

        while(!nodesQueue.isEmpty()) {
            TreeNode node = nodesQueue.poll();

            //the idea to calculate the level of the tree during BFS is to add a null value after popping the children of a particular level
            //so at level 0, we add rootNode in queue and than add null cuz we've only root node on that level
            //Everytime we pop from the queue, we check if the popped value is NULL or not. If it's it means we've popped all the children enqueued for this level
            //For example, the popped value from queue will be null only when we've popped the root node.
            // the popped value from queue will be null only when we've visited/popped (1 or 2) nodes on level 1, provided level 1 has 1 or 2 children.
            //WE SHOULDN'T ENQUEUE THE NODE.LEFT & NODE.RIGHT IF THEY'RE NULL OTHERWISE THE ALGO FOR CALCULATING LEVEL NUMBER BASED ON PUSHING NULL AT THE END OF EACH LEVEL WILL NOT WORK!
            if(node == null) {
                level++;
                nodesQueue.add(null);
                nodesNumbersList.add(subsetList);

                if(nodesQueue.peek() == null)
                    break;

                subsetList = new ArrayList<>();
                continue;
            }

            subsetList.add(node.val);

            if(node.left != null)
                nodesQueue.add(node.left);

            if(node.right != null)
                nodesQueue.add(node.right);

        }
        return nodesNumbersList;
    }

    private double log2(int n)
    {
        return (Math.log(n) / Math.log(2));
    }
}
