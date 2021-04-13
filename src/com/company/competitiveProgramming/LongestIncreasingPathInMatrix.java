package com.company.competitiveProgramming;

public class LongestIncreasingPathInMatrix {
    /**
     The idea is to traverse the matrix with dfs and if we continue dfs if prevNum is < the currentNum
     where prevNum is coming from prevRecursion.

     See how far can we go from curren i,j to find the longest increasing chain of numbers
     and save the length of the path in dp[i][j]

     The reason we save it in dp[][] is cuz we might come across this node i-e; matrix[i][j] from another node
     but instead of recomputing this path again, we just return dp[i][j] since we already calculated the longest path
     from this matrix[i][j]
     */

    //video tutoria: https://www.youtube.com/watch?v=-UeIgUqAFbM

    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;

        int maxLength = 0;
        int[][] dp = new int[matrix.length][matrix[0].length];

        //tc: n2
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[i].length; j++) {
                int length = dfs(matrix, dp, i, j, Integer.MIN_VALUE);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }

    private int dfs(int[][] matrix, int[][] dp, int i, int j, int prevNum) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length || matrix[i][j] <= prevNum)
            return 0;

        //since we already came to this node and calculate the length of path for this node,
        //just return this path length value for thsi node
        if(dp[i][j] != 0)
            return dp[i][j];

        int count = 1;

        //we save the length returned by the recursion of each direction separately cuz we can't merge length of all possible paths
        //we can use the value from only one direction from the current node
        //next node can go in any direction but we'll use length from only the longest path from that node too
        int up = dfs(matrix, dp, i-1, j, matrix[i][j]);
        int down = dfs(matrix, dp, i+1, j, matrix[i][j]);
        int left = dfs(matrix, dp, i, j-1, matrix[i][j]);
        int right = dfs(matrix, dp, i, j+1, matrix[i][j]);

        count += Math.max(up, Math.max(down, Math.max(left, right)));

        dp[i][j] = count;
        return count;
    }
}
