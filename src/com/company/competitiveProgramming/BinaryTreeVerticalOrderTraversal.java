package com.company.competitiveProgramming;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
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

        Node newRoot = new Node(root, 0);
        Queue<Node> q = new LinkedList<>();
        q.add(newRoot);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Node shellNode = q.poll();

                List<Integer> list = map.getOrDefault(shellNode.distance, new ArrayList<Integer>());
                list.add(shellNode.node.val);
                map.put(shellNode.distance, list);

                if(shellNode.node.left != null) {
                    Node node = new Node(shellNode.node.left, shellNode.distance-1);
                    q.add(node);
                }

                if(shellNode.node.right != null) {
                    Node node = new Node(shellNode.node.right, shellNode.distance+1);
                    q.add(node);
                }
            }
        }

        List<Integer> distanceList = new ArrayList<>();

        Set<Integer> set = map.keySet();
        Iterator<Integer> iterator = set.iterator();

        while(iterator.hasNext()) {
            distanceList.add(iterator.next());
        }

        Collections.sort(distanceList);

        for(Integer distance : distanceList)
            result.add(map.get(distance));
    }

    class Node {
        TreeNode node;
        int distance;

        public Node(TreeNode node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

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
}
