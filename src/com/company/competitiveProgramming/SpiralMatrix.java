package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralMatrix {


    /**
     We've to go in clockwise direction
     meaning
     Right till the end of column.length or we come across a cell we already visited
     than Down till end the of row.length  or we come across a cell we already visited
     than Left till i <= 0  or we come across a cell we already visited
     than UP till j <= 0  or we come across a cell we already visited

     However there's an Edge case

     when we go up and we come across a visited node than we've to turn right immediately,
     if we don't do that than we backtrack until the recursion call which call UP the very first time and than we start going up again
     this results in wrong result

     FOR EXAMPLE:

     if we don't take care of the edge case that KEEP GOING UP UNTIL i<=0 or visited node is reached and than turn right
     than this will happen

     [[1,2,3,4],
     [5,6,7,8],
     [9,10,11,12],
     [13,14,15,16]]

     when we visit 13, after this we go up until 5 than we come across 1 which is already visited.
     Now recursion call returns and it keeps returning until the node value = 14 from inside node value 14, we started going up (after visiting 13), therefore we now will go up and visit 10 that's wrong!!


     Therefore when we go up, we keep going up until EITHER WE REACH i <= 0 or we reach visited
     AND THAN WE IMMEDIATELY TURN RIGHT!
     */

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0)
            return result;

        dfs(matrix, 0, 0, new boolean[matrix.length][matrix[0].length], false, result);

        return result;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited, boolean up, List<Integer> result) {
        if(i < 0 || i>=grid.length || j < 0 || j>= grid[i].length || visited[i][j])
            return;

        visited[i][j] = true;
        result.add(grid[i][j]);

        //if direction is up, keep going up until i <= 0 or visited node is reached and than immediately TURN RIGHT!!!
        if(up) {
            dfs(grid, i-1, j, visited, true, result);
            dfs(grid, i, j+1, visited, false, result);
        }
        else {

            //the order of these calls matter!
            dfs(grid, i, j+1, visited, false, result); //right
            dfs(grid, i+1, j, visited, false, result); //down
            dfs(grid, i, j-1, visited, false, result); //left
            dfs(grid, i-1, j, visited, true, result); //up
        }
    }
}
