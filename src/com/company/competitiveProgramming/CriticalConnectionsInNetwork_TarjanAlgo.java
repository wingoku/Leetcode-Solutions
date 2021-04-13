package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsInNetwork_TarjanAlgo {

    /**

     0: 1 2
     1: 0 2 3
     2: 0 1
     3: 1
     */

    /**
     *
     * SIMPLE IDEA IS
        1. Create Adjecency List
        2. Do dfs and check
        3. if rank of currentNode > rank of neighbor node
            a. than set ranks[currentNode] = ranks[neighbor]
        4. otherwise if rank of neigbhor node == currentRank+1 // check this after the dfs call so at this stage currentRank would be the currentRank of the parent of this neighbor
        5. If yes, than this is a critical connection
     */
    //https://www.youtube.com/watch?v=RYaakWv5m6o
            //easier solution
    private List<List<Integer>> result;
    private List<List<Integer>> arrayOfAdjecencyList;
    private boolean[] visited;
    private int[] rank;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        if(connections.size() == 1)
            return connections;

        visited = new boolean[n];
        result = new ArrayList<>();
        rank = new int[n];

        arrayOfAdjecencyList = new ArrayList<>();
        createAdjecencyList(n, connections, arrayOfAdjecencyList);

        dfs(-1, 0, 0);

        return result;
    }

    private void dfs(int parentNode, int currentNode, int currentRank) {
        if(visited[currentNode])
            return;

        rank[currentNode] = currentRank;
        visited[currentNode] = true;

        List<Integer> adjecencyList = arrayOfAdjecencyList.get(currentNode);
        for(Integer neighbor : adjecencyList) {

            if(neighbor == parentNode)
                continue;

            dfs(currentNode, neighbor, currentRank + 1);

            if(rank[currentNode] > rank[neighbor])
                rank[currentNode] = rank[neighbor];
            else
            if(rank[neighbor] == currentRank + 1) {
                result.add(Arrays.asList(currentNode, neighbor));
            }
        }
    }

    private void createAdjecencyList(int totalNodes, List<List<Integer>> connections, List<List<Integer>> arrayOfAdjecencyList) {

        for(int i=0; i<totalNodes; i++) {
            arrayOfAdjecencyList.add(new ArrayList<Integer>());
        }

        for(List<Integer> connection : connections) {
            int node1 = connection.get(0);
            int node2 = connection.get(1);

            //since the graph is undirected, each edge means node1 can go to node2 & node2 can go to node1
            arrayOfAdjecencyList.get(node1).add(node2);
            arrayOfAdjecencyList.get(node2).add(node1);
        }
    }
    /*
        private List<List<Integer>> result;
    private List<List<Integer>> arrayOfAdjecencyList;
    private boolean[] visited;
    private int[] vistedTime;
    private int[] lowestVisitedTime;
    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        if(connections.size() == 1)
            return connections;

        visited = new boolean[n];
        result = new ArrayList<>();
        vistedTime = new int[n];
        lowestVisitedTime = new int[n];

        *//**
         think of this instantiation as making array of any other object
         Eg.
         Node[] nodesArray = new Node[size];
         This will create an array of Node objects

         Similarly List arrayOfList = new ArrayList[size];
         *//*
        arrayOfAdjecencyList = new ArrayList<>();

        for(int i=0; i<n; i++) {
            arrayOfAdjecencyList.add(new ArrayList<Integer>());
        }

        createAdjecencyList(connections, arrayOfAdjecencyList);

        dfs(-1, 0);

        return result;
    }

    private void dfs(int parentNode, int currNode) {

        visited[currNode] = true;
        vistedTime[currNode] = time;
        lowestVisitedTime[currNode] = time;
        time++;

        List<Integer> adjecencyList = arrayOfAdjecencyList.get(currNode);
        for(Integer neighbor : adjecencyList) {

            if(neighbor == parentNode)
                continue;

            if(!visited[neighbor]) {
                dfs(currNode, neighbor);

                *//*if(vistedTime[currNode] < lowestVisitedTime[neighbor]) {
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(neighbor);
                    bridge.add(currNode);
                    result.add(bridge);
                }*//*
                if(lowestVisitedTime[currNode] < lowestVisitedTime[neighbor]) {
                    //meaning there's no other way to reach this neighbor but from currentNode
                    //therefore it's a bridge aka critical connection

                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(neighbor);
                    bridge.add(currNode);
                    result.add(bridge);
                }
                else {
                    //its not a bridge
                    lowestVisitedTime[currNode] = lowestVisitedTime[neighbor];
                }
            }
            else
                lowestVisitedTime[currNode] = Math.min(lowestVisitedTime[currNode], vistedTime[neighbor]);
        }
    }

    private void createAdjecencyList(List<List<Integer>> connections, List<List<Integer>> arrayOfAdjecencyList) {

        for(List<Integer> connection : connections) {
            int node1 = connection.get(0);
            int node2 = connection.get(1);

            //since the graph is undirected, each edge means node1 can go to node2 & node2 can go to node1
            arrayOfAdjecencyList.get(node1).add(node2);
            arrayOfAdjecencyList.get(node2).add(node1);
        }
    }*/
}
