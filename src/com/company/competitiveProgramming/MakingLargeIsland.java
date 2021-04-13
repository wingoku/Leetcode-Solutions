package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class MakingLargeIsland {
    /**

     CHANGE ONLY one 0 to 1 !!!

     Examples:

     original:
         [1,1,1,1,0,0],
         [0,0,1,0,0,1],
         [0,1,1,0,0,1],
         [0,0,1,1,0,1],
         [0,0,0,1,0,1],
         [1,1,0,0,0,1]

     after marking:
         [2,2,2,2,0,0],
         [0,0,2,0,0,3],
         [0,2,2,0,0,3],
         [0,0,2,2,0,3],
         [0,0,0,2,0,3],
         [4,4,0,0,0,3]

     original:
         [1, 0, 1, 0, 0, 1, 0],
         [0, 1, 1, 1, 0, 1, 0]

     after marking:
         [2 0 3 0 0 4 0]
         [0 3 3 3 0 4 0]
     */

    /**
     SOLUTION:
         Step1:
             The idea is to iterate over the grid like we do in NumberOfIslands question
             Everytime we come across 1 in the loop, we start dfs
             and everytime we come across 1, we replace 1 with an id
             the id is generated everytime we encounter 1 in the loop
             when we come across 0, we end recursion
         Step2:
             After marking the islands, we iterate over the grid again
             Everytime we come across 0, we start dfs
             and sum the sizes of islands neighboring this 0

     */

    //tc: O(n) cuz we iterate over each grid item in step 1 and 2 so tc = O(2N)
    //and than in each recursion we're visiting each node 1 time so tc = O(n) there
    //total tc = O(4n) , 2N cuz of the loops, 1N from the dfs_markIsland and 1N from dfs_mergeIslands
    //tutorial:https://www.youtube.com/watch?v=_426VVOB8Vo&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=22&t=0s
    public int largestIsland(int[][] grid) {

        int maxArea = 0;
        int islandID = 2;
        HashMap<Integer, Integer> sizeMap = new HashMap<>();

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    int area = dfs_markIslands(grid, i, j, islandID);

                    //we're calculating the max here as well cuz from dfs_markIsland() we get the size of each island
                    //so if the entire matrix was full of 1s [[1,1],[1,1]] and we don't find max here, we won't get the maxArea from the second loop
                    //i-e; the loop of dfs_mergeIslands() and hence the maxArea that we'd return would be 0
                    maxArea = Math.max(maxArea, area);
                    sizeMap.put(islandID, area);
                    islandID++;
                }
            }
        }

        // System.out.println("map: "+ sizeMap.toString());

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 0) {
                    int area = dfs_mergeIslands(grid, i, j, sizeMap, true, new HashSet<Integer>()) + 1;//+1 cuz we include 0 as converted island
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea;
    }

    private int dfs_markIslands(int[][] grid, int i, int j, int islandID) {
        if(i < 0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] != 1)
            return 0;

        grid[i][j] = islandID;

        int count = 1;
        count += dfs_markIslands(grid, i-1, j, islandID);
        count += dfs_markIslands(grid, i+1, j, islandID);
        count += dfs_markIslands(grid, i, j-1, islandID);
        count += dfs_markIslands(grid, i, j+1, islandID);

        return count;
    }

    private int dfs_mergeIslands(int[][] grid, int i, int j, HashMap<Integer, Integer> sizeMap, boolean startOfTraversal, Set<Integer> visitedIslands) {
        //if visited already during
        //at some point during
        //recursion, we don't want to add
        //this islands size again in total sum
        if(i < 0 || i>=grid.length || j<0 || j>=grid[i].length || visitedIslands.contains(grid[i][j]) || (grid[i][j] == 0 && startOfTraversal == false))
            return 0;

        //we pass startOfTraversal as true when we call dfs_mergeIslands() when we encounter 0 in the loop in main method
        //if we don't add this boolean, we'll return right away when we call dfs_mergeIslands() from the loop
        startOfTraversal = false;
        int area = sizeMap.getOrDefault(grid[i][j], 0);

        if(area != 0) {
            //put this island in the visited map cuz if we don't do that
            //we may end up adding the size of this island in the total sum
            //at some point during the recursion

            /**
             EG.
             Original:
                 [1,1,1,1,0,0],
                 [0,0,1,0,0,1],
                 [0,1,1,0,0,1],
                 [0,0,1,1,0,1],
                 [0,0,0,1,0,1],
                 [1,1,0,0,0,1]

             After marking:
                 [2,2,2,2,0,0],
                 [0,0,2,0,0,3],
                 [0,2,2,0,0,3],
                 [0,0,2,2,0,3],
                 [0,0,0,2,0,3],
                 [4,4,0,0,0,3]

             so if we're at index grid[1][1]
             we go up and get the size of island mark as 2 - now sum = 10
             than we go to the right from grid[1][1] and add the sum of island 2 again and sum becomes 20
             this is not correct cuz we already added the size of island marked as 2 when we went up from grid[1][1] in recursion
             */
            visitedIslands.add(grid[i][j]);
            //returning cuz we there's no point in recursing over this marked island cuz it'll skew our sum as described in the explanation above & cuz we already know the size of this island
            return area;
        }

        area += dfs_mergeIslands(grid, i-1, j, sizeMap, false, visitedIslands);
        area += dfs_mergeIslands(grid, i+1, j, sizeMap, false, visitedIslands);
        area += dfs_mergeIslands(grid, i, j-1, sizeMap, false, visitedIslands);
        area += dfs_mergeIslands(grid, i, j+1, sizeMap, false, visitedIslands);

        return area;
    }
}
