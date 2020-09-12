package com.company.competitiveProgramming;

import java.util.Stack;

public class FloodFill {
    //leetcode accepted
    //revise
    //amazon coding interview
    //SIMILAR to Number Of Islands leetcode problem
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        /*

        [[1,1,1],
         [1,1,0],
         [1,0,1]]
        */

        int valueToReplace = image[sr][sc];
        dfs(image, sr, sc, newColor, valueToReplace);

        return image;
    }

    private void dfs(int[][] image,  int r, int c, int newColor, int valueToReplace) {
        if(r < 0 || r >= image.length || c < 0 || c >= image[r].length || image[r][c] == newColor || image[r][c] != valueToReplace)
            return;

        image[r][c] = newColor;

        dfs(image, r-1, c, newColor, valueToReplace);
        dfs(image, r+1, c, newColor, valueToReplace);
        dfs(image, r, c-1, newColor, valueToReplace);
        dfs(image, r, c+1, newColor, valueToReplace);
    }
}
