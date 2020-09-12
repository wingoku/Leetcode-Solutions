package com.company.competitiveProgramming;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];

        int i=0, j=0;

        /**

         It's a DP problem cuz the sum at a particular cell depends on the sum of cells used to reach this path
         Therefore we've to solve those previous cells first to reach the current cell.
         Since the problem requires us to solve previous subproblems to reach the current cell & those subproblems are
         similar in nature to the current problem i-e; to reach cell 0,2; we need to know the sum it took to reach
         cell 0,1 & the sum it took to reach 0,0 (in reality we can't have a sum to reach 0,0 since we've to start from 0,0 but the value of 0,0 cell is used anyway to calculate the sum of the next cells along the path, we consider it as a sum too to simiplify the understanding of the problem), therefore we usd Dynammic programming

         SOLUTION:

         at any given cell we've 3 possible previous paths, Eg:
         if we're at 0,0 than we just use the value of cell 0,0 i-e; dp[i][j] = grid[i][j]
         if we're at 0,1 than we sum the value of 0,0 && 0,1 i-e; dp[i][j-1] since j at 0,1 is > 0
         if we're at 1,0 than we sum the value of 0,0 && 1,0 i-e; dp[i-1][j] since i > 0
         if we're at 1,1 than we've 2 possible previous paths:
         0,1 && 1,0
         i-e; i & j both are > 0                                       //sum to reach prev cell from upper row    value of current cell
         in that case we need to take the minimum of the sum of values dp[i-1][j]                                 + grid[i][j]
         OR
         //sum of prev cell in the same row & left cell      //current cell value
         dp[i][j-1]                                        + grid[i][j]

         */

        for(i=0; i<grid.length; i++) {
            for(j=0; j<grid[i].length; j++) {
                if(i > 0 && j > 0) {
                    dp[i][j] = Math.min(dp[i-1][j]+grid[i][j], dp[i][j-1]+grid[i][j]);
                }
                else
                if(i > 0) {
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                else
                if(j > 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }
                else
                    dp[i][j] = grid[i][j];

            }
        }


        return dp[i-1][j-1];
    }
}
