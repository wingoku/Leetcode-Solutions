package com.company.competitiveProgramming;

public class SumOfLeftLeaves {
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

    //leetcode 0ms
    //tc O(n)
    //sc: recursion stack space which is equal to number of nodes in the tree in worst case so O(N)
    public int sumOfLeftLeaves(TreeNode root) {
        int sum = dfs(root);
        return sum;
    }

    //without global sum variable
    private int dfs(TreeNode node) {
        if(node == null)
            return 0;

        int sum = 0;

        //checking if the node we're standing on right now wether it has a left child node, if yes: wether that left child node a leaf node or not
        //if yes, than we need to add that left child node's value to the sum
        if(node.left != null && isLeafNode(node.left))
            sum += node.left.val;
        else
            //if current node's left child node isn't a leaf node than we need to traverse the left tree
            //since this recursive method will trigger the above condition at some point & return a value, therefore we've sum+= next to this left tree dfs method
            sum+=dfs(node.left);
        sum += dfs(node.right);

        return sum;
    }

    int leftLeafNodesSum = 0;
    //with global sum variable
    private void dfsWithGlobalSumVariable(TreeNode node) {
        if(node == null)
            return;

        //checking if the node we're standing on right now wether it has a left child node, if yes: wether that left child node a leaf node or not
        //if yes, than we need to add that left child node's value to the sum
        if(node.left != null && isLeafNode(node.left))
            leftLeafNodesSum += node.left.val;
        else
            //if current node's left child node isn't a leaf node than we need to traverse the left tree
            //since this recursive method will trigger the above condition at some point & return a value, therefore we've sum+= next to this left tree dfs method
            dfs(node.left);

        dfs(node.right);
        return;
    }

    private boolean isLeafNode(TreeNode node) {
       return  node.left == null && node.right == null;
    }
}
