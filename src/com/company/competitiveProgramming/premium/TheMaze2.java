package com.company.competitiveProgramming.premium;

class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        return bfs(maze, start[0], start[1], destination[0], destination[1]);
    }

    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int bfs(int[][] grid, int start, int end, int destI, int destJ) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(start, end));

        int[][] distance = new int[grid.length][grid[0].length];

        for(int[] dist : distance)
            Arrays.fill(dist, Integer.MAX_VALUE);

        distance[start][end] = 0;

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Node node = q.poll();

                // System.out.println(node.i + ", "+ node.j);


                for(int[] dir : dirs) {

                    Node nodeNextToWall = move(grid, node.i, node.j, dir);

                    int totalDistance = distance[node.i][node.j] + nodeNextToWall.dist;

                    if(totalDistance < distance[nodeNextToWall.i][nodeNextToWall.j]) {
                        distance[nodeNextToWall.i][nodeNextToWall.j] = totalDistance;

                        if(nodeNextToWall.i == destI && nodeNextToWall.j == destJ)
                            continue;

                        q.offer(nodeNextToWall);
                    }
                }
            }
        }

        int shortestDistance = distance[destI][destJ];

        return shortestDistance == Integer.MAX_VALUE ? -1 : shortestDistance;
    }

    private Node move(int[][] grid, int i, int j, int[] dir) {

        int dist = 0;
        while(isValid(grid, i + dir[0], j + dir[1])) {
            i += dir[0];
            j += dir[1];
            dist++;
        }

        Node nodeNextToWall = new Node(i, j);
        nodeNextToWall.dist = dist;
        return nodeNextToWall;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        if(i < 0 || i>=grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 1)
            return false;

        return true;
    }

    class Node{
        int i;
        int j;
        int dist;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}