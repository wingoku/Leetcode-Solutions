package com.company.competitiveProgramming.premium;

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponentsInUndirectedGraph {

    class Solution {
        public int countComponents(int n, int[][] edges) {

            HashSet<Integer> visited = new HashSet<>();
            HashMap<Integer, List<Integer>> map = new HashMap<>();

            int connectedComponents = 0;

            createAdjecencyMap(edges, map);

            for(int i=0; i<n; i++) {
                if(!visited.contains(i)) {
                    dfs(i, map, visited);
                    connectedComponents++;
                }
            }

            return connectedComponents;
        }

        private void createAdjecencyMap(int[][] edges, HashMap<Integer, List<Integer>> map) {

            for(int[] edge : edges) {
                int node1 = edge[0];
                int node2 = edge[1];

                map.putIfAbsent(node1, new ArrayList<>());
                map.get(node1).add(node2);

                map.putIfAbsent(node2, new ArrayList<>());
                map.get(node2).add(node1);
            }
        }

        private void dfs(int node, HashMap<Integer, List<Integer>> map, HashSet<Integer> visited) {
            if(visited.contains(node))
                return;

            visited.add(node);

            List<Integer> neighbors = map.get(node);

            if(neighbors == null)
                return;

            for(int neighbor : neighbors) {
                dfs(neighbor, map, visited);
            }
        }
    }

    /**
        OLD WAY
     UNION FIND PROCESS

     1. Point parent of one node to the parent of another node based on the given edge pair
     2. Nodes in one tree should share 1 root node
     a. this is call path compression
     b. find method does that recursively
     3. At the end all the nodes in one graph will point to the same parent & hence fall in the same subset
     */
    //TC: O(N + M Log(N)). This TC is achieved using path compression
    //N is the number of nodes
    //M is the number of edges.
    //log(n) is cuz of path compression
    //video tutoria: https://www.youtube.com/watch?v=ymxPZk7TesQ&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=26
    //https://www.youtube.com/watch?v=eTaWFhPXPz4
    public int countComponents(int n, int[][] edges) {

        int[] parents = new int[n];

        //creating array for n nodes & each node will be the parent of itself at this stage
        for(int i=0; i<n; i++)
            parents[i] = i;

        //merge nodes that've edge between them by making them point to a common root parent
        for(int[] edge : edges) {
            unionNodes(edge[0], edge[1], parents);
        }

        //find how many subsets aka connected components are there based on the given edges
        return findUniqueParentsCount(parents);
    }

    private int findUniqueParentsCount(int[] parents) {
        Set<Integer> set = new HashSet<>();

        //adding to set to find unique parents
        for(int node=0; node<parents.length; node++) {
            int parent = findParent(node, parents);

            System.out.println("findUniqueParent(): node: "+ node + " parent: "+ parent);

            set.add(parent);
        }

        return set.size();
    }

    private void unionNodes(int node1, int node2, int[] parents) {
        int parentOfNode1 = findParent(node1, parents);
        int parentOfNode2 = findParent(node2, parents);

        System.out.println("node1Parent: "+ parentOfNode1 + " node2Parent: "+ parentOfNode2);
        System.out.println("parents[parentOfNode1:"+parentOfNode1+"]: "+ parents[parentOfNode1]);

        //point parent of node 1 to parent of node 2
        parents[parentOfNode1] = parentOfNode2;

        System.out.println("node1Parent: "+ parents[parentOfNode1] + " node2Parent: "+ parents[parentOfNode2]);

        System.out.println("------------ union done ---------------");
    }

    private int findParent(int node, int[] parents) {

        //we get the parent of the current node
        int parentOfCurrentNode = parents[node];

        /**
         since we've have a parents array where indices are the nodes
         and values are their parents. If the index doesn't match its value, it means
         that the node is not a parent of itself hence it's not the root parent


         if current node is not the root parent, find the root parent by going to the parent of the
         current node and than their parent until we find the root parent

         Than return the value of the root parent and update the values of all the subsequent parent nodes
         */
        if(node != parentOfCurrentNode) {
            int rootParent = findParent(parentOfCurrentNode, parents);
            parentOfCurrentNode = rootParent;
        }

        return parentOfCurrentNode;
    }
}
