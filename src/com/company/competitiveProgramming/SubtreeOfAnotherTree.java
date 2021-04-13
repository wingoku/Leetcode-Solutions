package com.company.competitiveProgramming;

public class SubtreeOfAnotherTree {
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

    //leetcode 7ms
    //revise
    //TC O(n*m) cuz for each node of S that matches with the root node of T, we explore that subtree of S & match it with the entire T & in worse case, each node of S can be similar to the root node of T or all nodes of T until on of the S nodes has further children. See the example for this on leetcode
    //amazon coding interview
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return dfs(s, t, false);
    }

    //the reason I've isIdentical() written is because that dfs recursion stops the moment there is a non identical node found
    // however in dfs() we can't stop recursion when left & right subtrees of s & t from current node are not identical
    //and we've to keep doing this dfs() method process until we've exhausted the entire S tree.
    private boolean dfs(TreeNode s, TreeNode t, boolean isSubtree) {
        if(s == null || t == null)
            return s == null && t == null;

        //if values of current nodes are identical, check if left & right subtrees are identical
        if(s.val == t.val) {
            isSubtree = isIdentical(s.left, t.left, true) && isIdentical(s.right, t.right, true);
        }

        //if current nodes are not identical or if they were identical but either their left or right subtrees were not identical
        //than traverse the left & right subtrees of S and than start matching it with left & right subtrees of t.
        if(!isSubtree) {
            isSubtree = dfs(s.left, t, isSubtree) || dfs(s.right, t, isSubtree);
        }

        return isSubtree;
    }

    private boolean isIdentical(TreeNode s, TreeNode t, boolean isSubtree) {
        if(s == null || t == null)
            return s == null && t == null;

        if(!isSubtree)
            return false;

        if(s.val == t.val) {
            isSubtree = isIdentical(s.left, t.left, isSubtree)
                    &&
                    isIdentical(s.right, t.right, isSubtree);
        }
        else
            isSubtree = false;

        return isSubtree;
    }
}
