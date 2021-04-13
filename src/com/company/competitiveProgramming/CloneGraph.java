package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CloneGraph {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //leetcode 30 ms
    //TC - O(N)
    //SC  O(N) if we just consider the space consumed by the hashmap
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        HashMap<Integer, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, HashMap<Integer, Node> visited) {
        if(node == null)
            return null;

        //the node is already visited & we've already created a copy of it so just return the copy
        //if we don't have this check wether the current node is already visited or not,
        //than we'd end up in a never ending recursion cuz undirected graph has nodes who's edge is bidirectional meaning
        //node:0  <------> node:1, when we traverse node 1 and we don't keep track of if 0 was visited, from node:0 we'd visit
        //node:1 and than from node:1 we'd visit node:0 and it'll keep going and never end
        if(visited.containsKey(node.val)) {
            return visited.get(node.val);
        }

        //create a copy of current node
        Node copyNode = new Node(node.val);

        //putting the copied node in the map so that during traversal when come across
        //a node who's also a neighbor of this node than we'd just return this copy instance so that that node
        //can put this copied node into its adjecency list
        visited.put(node.val, copyNode);
        List<Node> neighborsList = node.neighbors;

        for(Node neighbor : neighborsList) {
            Node neighborCopy = dfs(neighbor, visited);

            if(neighborCopy != null)
                copyNode.neighbors.add(neighborCopy);
        }

        return copyNode;
    }
}
