package com.company.competitiveProgramming.premium;

class Solution {
    /*

        A tree is a graph which has
        1. No CYCLES!!
        2. All nodes are connected that means the graph has JUST 1 COMPONENT!

        We can use the same strategy as in other graph problems for finding cycles
        If we find cycle, that means the grah is not a tree

        But in order to make sure the graph has just 1 component, at the end we run a loop over the visited array and check if it's any UNVISITED nodes in it, if yes that means there are more than 1 components in this graph hence it's not a tree

    */
    private int UNVISITED = 0;
    private int PROCESSING = 1;
    private int PROCESSED = 2;

    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> adjList = new ArrayList<>();
        createAdjList(edges, n, adjList);

        int[] visited = new int[n];

        //we call detect cycle only one the root node
        //if this graph is a tree than all the nodes in this graph will be visited and won't have any cycles
        //therefore we don't need to run a loop since tree is supposed to have ONLY 1 component
        if(detectCycle(0, -1, visited, adjList))
            return false;

        //checking for unvisited nodes. if there are unvisited nodes, it means the graph is not a tree since it has more than 1 component
        for(int i=0; i<visited.length; i++){
            if(visited[i] == UNVISITED)
                return false;
        }

        return true;
    }

    private boolean detectCycle(int node, int parent, int[] visited, List<List<Integer>> adjList) {
        if(visited[node] == PROCESSING)
            return true;

        if(visited[node] == PROCESSED)
            return false;

        visited[node] = PROCESSING;

        List<Integer> neighbors = adjList.get(node);

        for(int neighbor : neighbors) {

            //don't want to visit parent node since parent node is also the neighbor of current node
            //we just need to go deeper in the tree.
            if(neighbor == parent)
                continue;

            if(detectCycle(neighbor, node, visited, adjList))
                return true;
        }

        visited[node] = PROCESSED;
        return false;
    }

    private void createAdjList(int[][] edges, int n, List<List<Integer>> adjList) {
        for(int i=0; i<n; i++)
            adjList.add(new ArrayList<>());

        for(int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];

            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
    }
}