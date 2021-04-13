package com.company.competitiveProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    /**
     The idea is to traverse through the given grid as a tree/graph

     We'll choose BFS to do that cuz each rotting node can only rot the nodes that're adjecent to it
     i-e; to it's top, bottom, left and right

     After it's infected the nodes adjecent to it, the infected nodes now infect their adjecent orange
     Therefore BFS fits in this solution cuz only the adjecent children/vertices can be infected by the infected node

     EDGE CASE:
     it could be that we're given a grid that has multiple rotting oranges from the beginning therefore we have to find those
     rotting nodes and put them in the queue before we can start our traversal

     HOW TO DO BFS ON A GRID?
     Think of each cell as a node. In BFS each node first explores its adjecent nodes i-e; its immediate children
     Meaning
     We've a starting node than we put all the nodes adjecent to that node in a queue
     than we put the children of those nodes in the queue

     Similar concept will be used for BFS on grid
     Since in order to navigate over the grid using BFS/DFS, we always needs access to the i and j indexes

     Using dfs it's easier to have those indexes since those indexes are maintained in the recursion stack and upon
     every recursive call we take the previous i,j values and do i-1,i+1,j-1,j+1 on it

     In case of BFS the way we can achieve is that we can create a Node class and put the i,j index of the current node in the node
     object and then put it in the queue and than when we pop the node, we can access the i,j indexes of the popped
     node and than do i-1,i+1,j-1,j+1 on it to explore the node's children

     */

    //amazing explanation: https://www.youtube.com/watch?v=DU3kgZNtdwk
    //TC: O(N)
    //Looking at every cell is O(n). O(n^2) would be: for each cell, look at the entire grid.
    //cuz we're going through all the oranges once for finding rotten oranges in the beginning
    //and once for finding non rotten oranges after bfs
    //TC would have been nxm if we had to check the entire grid for each cell in the grid than it'd n x m
    //SC: O(N) cuz in worst case only 1 orange will be infected and it'll infect all the oranges so all the oranges need to be put in the queue
    public int orangesRotting(int[][] grid) {

        Queue<Node> q = new LinkedList<>();

        //finding all the nodes in the grid that're rotten
        //since there can be more than 1 rotten nodes/oranges give in the grid
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 2) {
                    Node node = new Node(i, j);
                    q.add(node);
                }
            }
        }

        Node currentNode = null;

        //i-1 i+1   j-1   j+1
        //up, down, left, right
        while(!q.isEmpty()) {
            currentNode = q.poll();

            int i = currentNode.i;
            int j = currentNode.j;
            int parentTime = currentNode.time;

            //check if we're not going out of bounds aka going through the roof of the grid
            //and check if the node is 1 since we're only interested in the nodes that're not rotten
            if(i-1 >= 0 && grid[i-1][j] == 1) {
                grid[i-1][j] = 2; //setting the node as rotten cuz the current node infected it

                Node newNode = new Node(i-1, j);
                newNode.time = parentTime + 1; //cuz it took us one more minute to rot this node
                q.add(newNode);
            }

            //check if we're not going out of bounds aka going through the floor of the grid
            //and check if the node is 1 since we're only interested in the nodes that're not rotten
            if(i+1 < grid.length && grid[i+1][j] == 1) {
                grid[i+1][j] = 2; //setting the node as rotten cuz the current node infected it

                Node newNode = new Node(i+1, j);
                newNode.time = parentTime + 1;
                q.add(newNode);
            }

            //check if we're not going out of bounds aka going through the left wall of the grid
            //and check if the node is 1 since we're only interested in the nodes that're not rotten
            if(j-1 >= 0 && grid[i][j-1] == 1) {
                grid[i][j-1] = 2; //setting the node as rotten cuz the current node infected it

                Node newNode = new Node(i, j-1);
                newNode.time = parentTime + 1;
                q.add(newNode);
            }

            //check if we're not going out of bounds aka going through the right wall of the grid
            //and check if the node is 1 since we're only interested in the nodes that're not rotten
            if(j+1 < grid[i].length && grid[i][j+1] == 1) {
                grid[i][j+1] = 2; //setting the node as rotten cuz the current node infected it

                Node newNode = new Node(i, j+1);
                newNode.time = parentTime + 1;
                q.add(newNode);
            }
        }

        int count = 0;

        if(currentNode != null)
            count = currentNode.time;

        //if there are oranges left that are not rotten than we have to return 1 cuz the question asked for it.
        //otherwise we return the time taken to rot all the nodes
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    count = -1;
                    break;
                }
            }
        }

        return count;
    }

    class Node {
        int time;
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
