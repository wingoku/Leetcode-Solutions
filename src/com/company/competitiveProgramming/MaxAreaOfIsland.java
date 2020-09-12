package com.company.competitiveProgramming;

public class MaxAreaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j, 0));
                }
            }
        return maxArea;
    }


    private int dfs(int[][] grid, int i, int j, int area) {

        if(grid == null|| i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] != 1)
            return area;


        area++;
        grid[i][j] = 0;

        area = dfs(grid, i-1, j, area);
        area = dfs(grid, i+1, j, area);
        area = dfs(grid, i, j-1, area);
        area = dfs(grid, i, j+1, area);

        return area;
    }
}
