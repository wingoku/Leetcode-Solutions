package com.company.competitiveProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class RangeSumOfBST {
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
     The problem just says that we've to calculate the sum of values of nodes whose value >= L && val <= R
     */
    //leetcode 6ms
    //revise
    //amazon coding interview
    //TC: (n) since we're iterating over all the nodes in the tree
    //SC O(n) since we're iterating over all the nodes in the tree
    public int rangeSumBST(TreeNode root, int L, int R) {
        if(root == null)
            return 0;

        return bfs(root, L, R);
    }

    private int bfs(TreeNode node, int L, int R) {

        int sum = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            TreeNode n = q.remove();

            if(n.val >= L && n.val <= R) {
                sum += n.val;
            }

            if(n.left != null)
                q.add(n.left);

            if(n.right != null)
                q.add(n.right);
        }

        return sum;
    }
}
