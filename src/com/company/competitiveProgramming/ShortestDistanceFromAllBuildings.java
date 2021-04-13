package com.company.competitiveProgramming;
class Solution {
    /**

     calcuating distance to reach all the buildings from building 0,0

     1 - 0 - 2 - 0 - 1   [.,1,.,5,.]
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0   [1,2,3,4,5]
     |   |   |   |   |
     0 - 0 - 1 - 0 - 0   [2,3,.,5,6]


     calcuating distance to reach all the buildings from building 0,4

     1 - 0 - 2 - 0 - 1   [.,5,.,1,.]
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0   [5,4,3,2,1]
     |   |   |   |   |
     0 - 0 - 1 - 0 - 0   [6,5,.,3,2]


     calcuating distance to reach all the buildings from building 2,2

     1 - 0 - 2 - 0 - 1   [.,3,.,3,.]
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0   [3,2,1,2,3]
     |   |   |   |   |
     0 - 0 - 1 - 0 - 0   [2,1,.,1,2]


     total distance for reaching all cells from every building

     1 - 0 - 2 - 0 - 1   [.,9,.,9,.]
     |   |   |   |   |
     0 - 0 - 0 - 0 - 0   [9,8,7,8,9]
     |   |   |   |   |
     0 - 0 - 1 - 0 - 0   [10,9,.,9,10]


     for(int i=0; i<reach.length; i++) {
     for(int j=0; j<reach[i].length; j++) {
     System.out.print(dp[i][j] + ":"+reach[i][j] + ", ");
     }
     System.out.println();
     }

     System.out.println("--------------------");

     inspired by: https://leetcode.com/problems/shortest-distance-from-all-buildings/discuss/76891/Java-solution-with-explanation-and-time-complexity-analysis

     The question is asking us to find an empty spot in the grid that's the shortest distance from all the buildings

     In order to find out that spot, we can take 2 routes. We start searching the grid when come across a zero and than search for all
     the buildings by doing BFS

     This will take a lot of CPU time cuz we may come across lots of zeroes in the grid.

     2nd option is when we come across a 1 i-e; a building, we start searching for all the buildings using BFS
     This will have much less cpu consumption cuz if we've lots of obstacles or buildings or even empty spots aka 0s, we wont have to traverse for a longer
     time.

     So we iterate over the grid and when we come across a building aka 1, we start bfs until we've reached all the nodes
     We put the level and how many times a cell has been reached by a building in a grid.

     after we've traversed the entire grid for all the buildings that we come across in the loop,

     we find the minimum value in the distance grid and also check if the reach[][] for that particular index matches the number
     of buildings in the grid cuz if the distance[][] has the smallest value but not all the buildings can reach that spot which
     we'll find out by the value stored in reach[][] than that doesn't satisfy our requirement which says all the buildings should be reachable from a spot
     with the smallest distance
     */
    public int shortestDistance(int[][] grid) {

        if(grid == null || grid.length == 0)
            return -1;

        int[][] distance = new int[grid.length][grid[0].length];
        int[][] reach = new int[grid.length][grid[0].length];

        int totalNumOfBuildings = 0;

        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[i].length; j++) {
                if(grid[i][j] == 1) {
                    bfs(grid, distance, reach, i, j);
                    totalNumOfBuildings++;
                }
            }
        }

        int minDistance = Integer.MAX_VALUE;

        for(int i=0; i<distance.length; i++) {
            for(int j=0; j<distance[i].length; j++) {

                if(reach[i][j] == totalNumOfBuildings) {
                    minDistance = Math.min(minDistance, distance[i][j]);
                }
            }
        }

        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }


    private void bfs(int[][] grid, int[][] distance, int[][] reach, int ii, int jj) {
        Queue<Node> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        q.offer(new Node(ii, jj));
        visited[ii][jj] = true;

        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        int level = 1;
        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                Node node = q.poll();

                for(int[] dir : dirs) {
                    int iDir = node.i + dir[0];
                    int jDir = node.j + dir[1];

                    if(isValid(grid, iDir, jDir, visited)) {

                        q.offer(new Node(iDir, jDir));
                        visited[iDir][jDir] = true;

                        reach[iDir][jDir]++;
                        distance[iDir][jDir] += level;
                    }
                }
            }

            level++;
        }
    }

    private boolean isValid(int[][] grid, int i, int j, boolean[][] visited) {
        //grid[i][j] != 0 cuz if it's 1 or 2 we can't proceed cuz we can't pass through building aka 1 and obstacle aka 2
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 0 || visited[i][j] == true)
            return false;

        return true;
    }

    class Node {
        int i;
        int j;

        public Node(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }





























}