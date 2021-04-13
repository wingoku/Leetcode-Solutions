package com.company.competitiveProgramming;

public class UnqiuePath {
    //leetcode accepted
    //backtracking way timesout
    //linear looping way works
    //amazon coding interview
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                //if we're on row 0, there's only 1 way to reach any cell in row 0 cuz we can only move right or down (not up or left), therefore each cell in row 0 has only 1 way to reach any cell in row 0
                if(i == 0)
                    dp[i][j] = 1;
                else
                    //if we're on column 0, there's only 1 way to reach any cell in column 0 cuz we can only move down & right (not up or left)
                    //therefore each cell in column 0 has only 1 way to reach any cell in column 0
                    if(j==0)
                        dp[i][j] = 1;
                    else
                    //to reach a cell that's not in the first row or first column (row = 0, column = 0), there can be dp[i-1][j] + dp[i][j-1]
                    //cuz we can reach that cell either when we come to it from the top cell or left cell
                    //For Example
                    /**
                     0   1  2
                     +--+--+--+
                     0 |  |  |  |
                     +--+--+--+
                     1 |  |  |  |
                     +--+--+--+
                     2 |  |  |  |
                     +--+--+--+

                     if we want to reach cell 1,1
                     one way to reach it is by following the path 0,0 -> 0,1 -> 1,1
                     another way to reach it is by following the path 0,0 -> 1,0 -> 1,1

                     so the total number of ways to reach cell 1,1 is the sum of the number of ways
                     cell 0,1 & cell 1,0 can be reached.

                     same holdes for any other cell in the grid except for row 0 & column 0 cuz we can only move down or right

                     therefore the formula for calculating the ways to reach a cell when i>0 & j > 0 is:
                     //top row cell        //neighboring left cell
                     dp[i][j] = dp[i-1][j]        +    dp[i][j-1]

                     */
                        dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];

        /**
         * Following code executes backtracking method for counting paths that lead to the destination
         */
        // int[] dp2 = new int[1];
        // backtrack(m, n, 0, 0, dp2);
        // return dp[0];
    }


    //the idea behind finding the number of ways to reach the destination using backtracking is
    //we recursively call backtracking for moving DOWN & RIGHT
    //eventually each recursive call will reach the destination,
    //when it reaches, we just increment the counter. This counter tells us how many times destination cell was reached.
    //this solution is slow cuz of recursion but it works
    private void backtrack(int m, int n, int i, int j, int[] dp) {
        if(i >= m || j >= n)
            return;

        if(i == m-1 && j == n-1)
            dp[0]++;

        backtrack(m, n, i+1, j, dp);
        backtrack(m, n, i, j+1, dp);
    }
}
