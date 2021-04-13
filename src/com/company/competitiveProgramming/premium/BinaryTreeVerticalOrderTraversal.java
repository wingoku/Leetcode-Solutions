package com.company.competitiveProgramming.premium;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    /**
     The idea is to maintain a distance integer between each parent and its child nodes

     all the nodes with similar distance id will be end up in the same list after we're done doing bfs over the tree

     SOLUTION:
     We create a wrapper class, Node. It's member variables TreeNode and distance

     TreeNode contains the nodeObject of the given tree & distance will contain the value of distance with respect to this node's parent
     Eg.

     We assign root node the distance value = 0. So it's left child distance would be root.distance -1 & right child distance will root.distance +1

     We also put these nodes in a hashmap. The key in the hashMap is the distance and the value is an ArrayList which contains values of the nodes
     which have the same distance value.

     Once we're done with traversal, we sort the keyset of the map cuz we need to return the lists in ascending order distance.

     */

    //TC: O(NlogN) cuz of the sorting of the distance integer in the map.
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if(root == null)
            return result;

        bfs(root, result);

        return result;
    }

    private void bfs(TreeNode root, List<List<Integer>> result) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int min = 0;
        int max = 0;

        Queue<Node> q = new LinkedList<>();
        Node rootNode = new Node(root, 0);

        q.add(rootNode);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Node parent = q.poll();

                map.putIfAbsent(parent.dist, new ArrayList<>());
                map.get(parent.dist).add(parent.node.val);

                if(parent.node.left != null) {
                    Node left = new Node(parent.node.left, parent.dist-1);
                    q.add(left);
                    min = Math.min(min, parent.dist-1);
                }

                if(parent.node.right != null) {
                    Node right = new Node(parent.node.right, parent.dist+1);
                    q.add(right);
                    max = Math.max(max, parent.dist+1);
                }
            }
        }

        for(int i=min; i<=max; i++) {
            result.add(map.get(i));
        }
    }

    class Node {
        TreeNode node;
        int dist;

        public Node(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
    /**

     left child = 2*parentIndex+1
     right child = 2*parentIndex+2
     */
}