package com.company.competitiveProgramming;

public class IslandPerimeter {

    /**
     *[[0,1,0,0],
     *  [1,1,1,0],
     *  [0,1,0,0],
     *  [1,1,0,0]]
     *
     *  We're given the above adjecency matrix & we've to find out how many edges of a square are touching the water & not the land.
     *  1: land
     *  0: water
     *
     *  We do DFS on the give grid
     *
     *  How to do DFS on an adjecency matrix/grid?:
     *
     *  We start from an index i in the provided matrix. Usually we start from index[0][0] i-e; top left
     *  Than we check if the value at this index is 1
     *  If yes: this means it's a land & now we need to find out if any other lands/1s are adjecent to it in 4 directions aka top,down,left,right
     *  DFS does the exact same thing. It starts from a node, goes down till leaf node than comes back up & goes left/right to find its unvisited siblings.
     *  We're using the idea of DFS here.
     *
     *  So let's say we are at index[1][1],
     *  1. We check if it's 1
     *  2. Than we call dfs()
     *  3. Inside DFS(), we've a base case since our DFS method is recursive & recursion methods always need at least ONE base case to get out of recursion
     *  4. In this case our base case is if are out of the grid Eg. grid[-1][0] or grid[-1][-1] or grid[grid.length][grid.length] or grid[[grid.length+1][grid.length] or if the current value at
     *  grid[whatever_X][whatever_Y] is 0, we end recursion cuz we only care about adjecent land which in this question is represented by 1
     *  5. After this condition, we set the value at the current index in grid[whatever_X][whatever_Y] to ANY VALUE except 1. In this case we're setting it to 0, but we can also set it 2,3 etc
     *  The reason we're setting the current index value as 0 or anything but 1 is to signify that this index/piece of land is already visited. This helps us avoid miscalculations & avoid a non ending recursion
     *  7. Than we call dfs() 4 times cuz we want to check in 4 directions from the current index, top, down, left, right. We can call dfs in any order eg. left, right, top, down etc
     *  8. Once the recursion is finished, we call DFS again if we encounter 1 in the loop that's iterating over the given grid
     *  9. At the end we've explored the entire grid
     *
     */
    //leetcode question:
    //https://leetcode.com/problems/island-perimeter/
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        for(int i=0; i<grid.length; i++)
            for(int j=0; j<grid[i].length; j++)
                if(grid[i][j] == 1) // cuz we only want to explore the parts of grid that're land
                    count = dfs(grid, i, j, 0);
        return count;
    }

    private int dfs(int[][] grid, int i, int j, int count) {
        if(i<0 || j<0 || i>= grid.length || j>=grid[i].length || grid[i][j] == 0)
            return count + 1;

        if(grid[i][j] == 2)
            return count;

        grid[i][j]=2; //setting it to 2 or anything besides 1 to make sure not to revisit this land

        //sending count variable inside recursive calls once they enounter 0 or end/go out of grid bounderies, we consider it as the piece of land touched water & we increment it by 1
        count = dfs(grid, i-1, j, count); //top
        count = dfs(grid, i+1, j, count);//down
        count = dfs(grid, i, j-1, count);//left
        count = dfs(grid, i, j+1, count);//right

        return count;
    }
}
