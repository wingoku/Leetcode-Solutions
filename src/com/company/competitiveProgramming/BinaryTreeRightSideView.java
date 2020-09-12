package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
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

    //leetcode 1ms
    //amazon, facebook, microsoft coding interview
    public List<Integer> rightSideView(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        return bfs(root);
    }


    /**
     The idea is to add the last element on the current level into the list
     Why? 2 reasons, Root node is the technically the last element on its level & we've to add it to the list according to the given example
     similarly if we've a single node of the root node, we'd add it to the list too

     BESIDES:
     on any level of the tree, the last element is always the right element when we do BFS

     WHY are we doing BFS & not DFS
     cuz
     it's easier to visualize adding right elements using bfs since it goes level by level
     SECOND:
     there's also a hint in the question which says TOP TO BOTTOM:
     BFS always goes TOP to BOTTOM i-e; it process nodes at the current level & adds their children in the Queue & than goes
     one level down to process those children & their children
     */
    private List<Integer> bfs(TreeNode node) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(node);

        List<Integer> list = new ArrayList<>();

        while(!q.isEmpty()) {
            //WHY WE"VE INNER LOOP?
            /**
             ANSWER:
             In the beginning, we'd have only 1 element in the queue that's the ROOT element so the queue size would be 1
             than we loop over the current elements in the queue (which in the beginning would be only 1 i-e; root element)
             So the internal loop would run only 1 time & add the children of the root node. It gets out of the inner loop
             Since the queue is not empty & now the queue size is 2, it'll get into the inner loop again & run 2 times & add its children

             For example: if the tree had only 1 element than the outer loop would run once & inner loop would run once & the program terminates
             If the tree had 3 nodes, the outer loop would run since we've root element in the queue. Than we run inner loop once, add its 2 children & end up in the outer loop. Now the queue size == 2, the inner loop iterates 2 times & now the queue is empty so when we get out of the inner loop, the outer loop would check if queue is empty, since it's empty the outer loop would also terminate & program ends
             */
            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode currentNode = q.remove();

                if(i == size -1) {
                    list.add(currentNode.val);
                }

                if(currentNode.left != null) {
                    q.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    q.add(currentNode.right);
                }

            }
        }

        return list;
    }
}
