package com.company.competitiveProgramming;

class Solution {
    int maxMinVal = Integer.MAX_VALUE;
    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int maximumMinimumPath(int[][] A) {

        maxMinVal = bfs(A);

        return maxMinVal == Integer.MAX_VALUE ? -1 : maxMinVal;
    }

    private int bfs(int[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];


        //we prioritize the least/minimum maxEffort took at a cell cuz our goal is to find the path which contains
        //the cell/cells which have the least maxEffort to reach the destination among all the paths & their nodes which lead to destination cell
        PriorityQueue<Node> maxHeapQ = new PriorityQueue<>((n1, n2) -> Integer.compare(n2.maxMinVal, n1.maxMinVal));

        maxHeapQ.offer(new Node(0, 0, grid[0][0]));
        visited[0][0] = true;

        while(!maxHeapQ.isEmpty()) {
            Node node = maxHeapQ.poll();

            if(node.i == grid.length-1 && node.j == grid[node.i].length-1)
                return node.maxMinVal;

            for(int[] dir : dirs) {
                int adjI = node.i + dir[0];
                int adjJ = node.j + dir[1];

                if(!isValid(grid, adjI, adjJ) || visited[adjI][adjJ])
                    continue;

                visited[adjI][adjJ] = true;

                int maxMinVal = Math.min(node.maxMinVal, grid[adjI][adjJ]);

                maxHeapQ.offer(new Node(adjI, adjJ, maxMinVal));
            }
        }

        return -1;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        if(i < 0 || i>= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == Integer.MAX_VALUE)
            return false;

        return true;
    }

    private class Node {
        int i;
        int j;
        int maxMinVal;

        public Node(int i, int j, int maxMinVal) {
            this.i = i;
            this.j = j;
            this.maxMinVal = maxMinVal;
        }
    }

}