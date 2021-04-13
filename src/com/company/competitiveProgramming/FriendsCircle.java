package com.company.competitiveProgramming;

public class FriendsCircle {
    /**
     The idea behind adjecency Matrix is the same as Adjecency List

     In case of Adjecency List, we've a node object or we have the a List of adjecency list like

     [[1,2], [0,1], [2,0]]
     0      1      2

     If we've the node object than the object contains the adjecencyList or if we've a list of adjecencyList like above
     than each index in the list signifies a node & at each index the adjecencyList signifies the vertices/nodes that the node at index i
     is connected to

     In each case, we take the first node and than iterate over its adjecencyList and than call dfs on each node in the adjecencyList

     This way all the nodes that are connected i-e; connected components will be visited. However the nodes that are not part of the connected component,
     will not be visited. The only way to figure out which nodes were visited or not based on the adjecencyList is based on the visited[].

     Visited array length will be equal to the number of nodes in the graph.

     In case of adjecencyMatrix

     adjecencyList
     node0: [1,1,0],
     node1: [1,1,0],
     node2: [0,0,1]
     */
    //tc: O(N^2) cuz we traverse the entire grid and than inside the traversal we also do dfs on the grid
    public int findCircleNum(int[][] grid) {
        int friendsCircle = 0;

        boolean[] visited = new boolean[grid.length];

        int unconnectedComponents = 0;

        //looping over the rows of the provided grid to check if any node is not visited i-e; visited[node] == false
        //that means it's a separate component
        for(int node = 0; node < grid.length; node++) {
            if(visited[node] == false) {
                unconnectedComponents++;
                dfs(grid, visited, node);
            }
        }

        return unconnectedComponents;
    }

    private void dfs(int[][] grid, boolean[] visited, int node) {
        if(visited[node] == true)
            return;

        visited[node] = true;

        for(int neighbor = 0; neighbor < grid[node].length; neighbor++) {

            //if the adjecencyList value == 0 that means, it's not the neighbor of curent node
            if(grid[node][neighbor] != 0) {
                dfs(grid, visited, neighbor);
            }
        }
    }
}
