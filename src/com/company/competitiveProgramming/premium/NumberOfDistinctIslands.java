package com.company.competitiveProgramming.premium;

class Solution {
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, sb);

                    set.add(sb.toString());
                    sb.setLength(0);
                }
            }
        }

        return set.size();
    }

    private void dfs(int[][] grid, int i, int j, StringBuilder sb) {
        if(i < 0 || i>= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            sb.append("O");
            return;
        }

        grid[i][j] = 0;

        sb.append("U");
        dfs(grid, i-1, j, sb);
        sb.append("D");
        dfs(grid, i+1, j, sb);
        sb.append("L");
        dfs(grid, i, j-1, sb);
        sb.append("R");
        dfs(grid, i, j+1, sb);
    }
}