package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementInBST {
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
    public int kthSmallest(TreeNode root, int k) {

        List<Integer> sortedList = new ArrayList<>();

        dfs(root, sortedList, k);

        return sortedList.size() > 0 ? sortedList.get(k-1) : -1;
    }

    private void dfs(TreeNode node, List<Integer> list, int k) {
        if(node == null)
            return;

        if(list.size() >= k) //an optimization. We don't want to traverse the entire tree if our list size >= k cuz than our desired kth value will be within the current list
            return;

        dfs(node.left, list, k);
        list.add(node.val);
        dfs(node.right, list, k);
    }
}
