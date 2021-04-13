package com.company.competitiveProgramming.premium;

class Solution {
    public void wallsAndGates(int[][] rooms) {

        for(int i=0; i<rooms.length; i++) {
            for(int j=0; j<rooms[i].length; j++) {
                if(rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    private void dfs(int[][] grid, int i, int j, int distance) {
        //if distance of a particular spot is already less than the current distance we've, there's no point in traversing this node. This also takes care of checking grid[i][j] == 0 i-e; gate thing
        //cuz we don't want to go through a gate and update the gate node to a certain value. Since we pass the distance initially as 0, the starting distance is 0
        //gate value is also 0 so grid[i][j] < distance becomes falls. Once we're past our initial gate then distance value will always be greater than other
        //0 so we'll never go through other gates during recursion
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == -1 || grid[i][j] < distance)
            return;

        grid[i][j] = distance;

        dfs(grid, i-1, j, distance+1);
        dfs(grid, i+1, j, distance+1);
        dfs(grid, i, j-1, distance+1);
        dfs(grid, i, j+1, distance+1);
    }
}