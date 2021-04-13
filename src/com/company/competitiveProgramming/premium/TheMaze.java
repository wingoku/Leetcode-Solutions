package com.company.competitiveProgramming.premium;

class Solution {

    //TC: O(MxN)
    private int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        return dfs(maze, start[0], start[1], destination[0], destination[1], new boolean[maze.length][maze[0].length]);
    }

    private boolean dfs(int[][] grid, int i, int j, int destI, int destJ, boolean[][] visited) {
        if(visited[i][j])
            return false;

        if(i == destI && j == destJ)
            return true;

        //marking the starting point as visited cuz we don't want to restart the rolling in all 4 directions from the cell we already visited
        visited[i][j] = true;

        for(int[] dir : dirs) {
            int ii = i;
            int jj = j;

            //rolling the ball horizontally or vertically (if dir[0] == 0 than dir[1] will be non zero that's how dirs[][] array is written. Therefore at a given point we will be moving in 1 direction) in one direction at a time until it hits a wall
            while(isValid(grid, ii + dir[0], jj+dir[1])) {
                ii += dir[0];
                jj += dir[1];
            }

            //we come here when we're right next to the wall and the ii, jj values are still within the boundaries of the mze
            if(dfs(grid, ii, jj, destI, destJ, visited))
                return true;
        }

        return false;
    }

    private boolean isValid(int[][] grid, int i, int j) {
        if(i<0 || i>= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 1)
            return false;

        return true;
    }
}