package com.company.competitiveProgramming;

import java.util.List;

public class LowestCommonAncestorOfBinaryTree {
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

    public TreeNode createDataSet() {
        TreeNode rootNode = new TreeNode(3);
        rootNode.left = new TreeNode(5);
        rootNode.right = new TreeNode(1);

        p = rootNode.left;

        rootNode.left.left = new TreeNode(6);
        rootNode.left.right = new TreeNode(2);
        rootNode.left.right.left = new TreeNode(7);
        rootNode.left.right.right = new TreeNode(4);

        q = rootNode.left.right.right;
        rootNode.right.left = new TreeNode(0);
        rootNode.right.right = new TreeNode(8);

        return rootNode;
    }
    TreeNode p;
    TreeNode q;
    TreeNode lca = null;

    public TreeNode lowestCommonAncestor() {
        TreeNode root = createDataSet();
        dfs(root, p, q);
        return lca;
    }

    //accepted by leetcode
    //amazon coding interview
    //will traverse all the nodes even when the nodes are found early in the tree
    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return false;
        }

        //if p or q matches with the currentNode than we found one of the nodes
        boolean matchesWithCurrentNode = (root == p || root == q);

        //when we come at the node that matches either p and q, we've found the lca
        if(root == p && root == q) {
            lca = root;
            return true;
        }

        //if p or q is found in left subtree of current node, it'll return true
        boolean foundInLeftSubtree = dfs(root.left, p, q);

        //if p or q is found in right subtree of current node, it'll return true
        boolean foundInRightSubtree = dfs(root.right, p, q);

        int mid = matchesWithCurrentNode ? 1 : 0;
        int left = foundInLeftSubtree ? 1 : 0;
        int right = foundInRightSubtree ? 1 : 0;

        //since we're finding only 2 nodes in the binary tree, there are 2 success possibilities
        //1 node is found in left or right subtree
        //1 node is matching with the current node
        //therefore we've the following condition which checks if the sum of current,left,right == 2 & than sets up the LCA value
        if(mid + left + right == 2)
            lca = root;

        //we're checking if sum of mid, left, right > 0 cuz if we're somewhere deep in left or right subtree
        //& we only found 1 of the nodes from p & q, than we need to return true
        //if we don't find any node that matches p or q, we'll return false since mid+left+right will be = 0
        return matchesWithCurrentNode || foundInLeftSubtree || foundInRightSubtree;
    }

    //accepted working solution
    //amazon coding interview
    //13 ms. Will traverse all the nodes even when the nodes are found early on in the tree
    //not a clean solution. Look at the second attempt above
    /*private boolean dfs(TreeNode root, TreeNode p, TreeNode q, int[] foundCount) {
        if(root == null) {
            return false;
        }

        System.out.println("node: "+ root.val + " lca == null? "+ (lca == null));

        boolean currentNodeMatching = (root == p || root == q);

        if(currentNodeMatching)
            foundCount[0]++;

        boolean foundInLeftSubtree = dfs(root.left, p, q, foundCount);
        boolean foundInRightSubtree = dfs(root.right, p, q, foundCount);


        System.out.println("count: "+ foundCount[0] + " node: "+ root.val);

        if(foundCount[0] >= 2 && ((foundInLeftSubtree && foundInRightSubtree) || (currentNodeMatching && (foundInLeftSubtree || foundInRightSubtree))))  {
            System.out.println("updating lca with root: "+ root.val);
            lca = root;
            foundCount[0] = 0;
            System.out.println("---> lca == null? "+ (lca == null));
        }

        return (currentNodeMatching || foundInLeftSubtree || foundInRightSubtree);
    }*/
}
