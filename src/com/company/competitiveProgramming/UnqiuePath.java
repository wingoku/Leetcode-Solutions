package com.company.competitiveProgramming;

public class UnqiuePath {
    //leetcode accepted
    //backtracking way timesout
    //linear looping way works
    //amazon coding interview
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        //fill the first row with 1 cuz there's only one way to reach any cell in the first row from any other elements of the first row without going into other rows
        for(int i=0; i<n; i++)
            dp[0][i] = 1;


        //fill the first column with 1 cuz there's only one way to reach any cell in the first column from any other elements of the first column without going into other column
        for(int i=0; i<m; i++)
            dp[i][0] = 1;

        backtrack(dp, 1, 1);
        System.out.println("count: "+count);

        count = 0;
        //this way is faster than recursion
         for(int i=1; i<m; i++)
             for(int j=1; j<n; j++) {
                 count++;
                 //ways to reach cell i,j is the sum of ways to reach the cell at (i-1, j)-> top & (i, j-1)->same row left column
                 dp[i][j] = dp[i-1][j] + dp[i][j-1];
             }

        System.out.println("count: "+count);
        return dp[m-1][n-1];
    }

    int count = 0;
    private void backtrack(int[][] dp, int i, int j) {
        if(i>=dp.length || j>= dp[i].length)
            return;

        System.out.println("i: "+ i + " j: "+ j + " dp[i][j]: "+dp[i][j]);
        count++;
        dp[i][j] = dp[i-1][j] + dp[i][j-1];

        backtrack(dp, i+1, j);
        backtrack(dp, i, j+1);
    }
}
