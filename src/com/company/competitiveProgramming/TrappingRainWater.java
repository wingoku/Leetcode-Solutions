package com.company.competitiveProgramming;

public class TrappingRainWater {
    /**

     The concept to solve this problem is called minimum of local maximum

     1. We go from left to right and find the max upon each step
     2. than we from right to left and find the max upon each step
     3. Than we iterate over both arrays and find the minimum upon each index

     than we subtract the input array from the array found in step 3

     0 1 1 2 2 2 2 3 3 3 3 3 max left -> right
     3 3 3 3 3 3 3 3 2 2 2 1 max right -> left
     ---------------------------
     0 1 1 2 2 2 2 3 2 2 2 1 min upon each index from above 2 arrays
     0 1 0 2 1 0 1 3 2 1 2 1 input array
     ------------------------
     0 0 1 0 1 2 1 0 0 1 0 0  difference

     */
    //TC: O(N)
    //SC: O(N)
    public int trap(int[] height) {

        if(height == null || height.length == 0)
            return 0;

        int[] leftToRightMax = new int[height.length];
        int[] rightToLeftMax = new int[height.length];

        //finding the max upon each step from left to right
        int max = 0;
        for(int i=0; i<height.length; i++) {
            max = Math.max(max, height[i]);
            leftToRightMax[i] = max;
        }

        //reseting max cuz we're starting to find max from right to left
        max = 0;
        //finding max upon each step from right to left
        for(int i=height.length-1; i>=0; i--) {
            max = Math.max(max, height[i]);
            rightToLeftMax[i] = max;
        }

        //finding minimum upon each step's maximum
        int[] minOfLocalMaxima = new int[height.length];
        for(int i=0; i<height.length; i++) {
            minOfLocalMaxima[i] = Math.min(leftToRightMax[i], rightToLeftMax[i]);
        }

        //finding difference between minimum of maximum upon each step calculated above and subtracting it from given array
        int result = 0;
        for(int i=0; i<height.length; i++) {
            result += minOfLocalMaxima[i] - height[i];
        }

        return result;
    }
}
