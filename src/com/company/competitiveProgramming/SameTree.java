package com.company.competitiveProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
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

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return breadthFirstSearch(p ,q);
    }

    private boolean breadthFirstSearch(TreeNode tree1, TreeNode tree2) {
        boolean similar = true;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();

        q1.add(tree1);
        q2.add(tree2);

        while(!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode n1 = q1.remove();
            TreeNode n2 = q2.remove();

            //if both nodes are null than the tree is still similar & since these 2 nodes won't have left/rigth now therefore we just call continue;
            if(n1 == null && n2 == null)
                continue;

            //if one of the two nodes is null or their values don't match, exit the loop
            if((n1 == null || n2 == null || n1.val != n2.val)) {
                similar = false;
                break;
            }

            //we also want to add null objects in queue to make sure the key structure is intact inside the queue
            q1.add(n1.left);
            q2.add(n2.left);
            q1.add(n1.right);
            q2.add(n2.right);
        }

        return similar;
    }
}
