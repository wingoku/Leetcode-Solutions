package com.company.competitiveProgramming;

import java.util.*;

public class BinaryTreeZigZagLevelOrderTraversal {
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

    //TC O(N) cuz we're traversing each node 1
    //SC: O(K) K is the max amount of nodes at a level
    //we're not counting the nodes added to the list than the SC would be O(N)
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null)
            return new ArrayList<>();

        return bfs(root);
    }

    private List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> zigZagList = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.add(root);

        int level = 0;
        int levelSize = 0;

        while(!q.isEmpty()) {
            levelSize = q.size();

            LinkedList<Integer> list = new LinkedList<>();
            for(int i=0; i < levelSize; i++) {
                TreeNode node = q.poll();

                //zig zagging
                if(level % 2 == 0)
                    list.addLast(node.val);
                else
                    list.addFirst(node.val);

                if(node.left != null)
                    q.add(node.left);

                if(node.right != null)
                    q.add(node.right);
            }

            zigZagList.add(list);
            level++;
        }

        return zigZagList;
    }
}
