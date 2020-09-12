package com.company.competitiveProgramming;

import java.util.Arrays;

public class HouseRobber2 {
    /**
     * The idea is to have max sum of numbers such that the numbers are next to each other
     * so we calculate the sum of alternative numbers & find out the max like that
     * Eg.
     * 1,2,3,4,5,6
     * since we can rob house 1,3,5,
     * or 2,4,6 cuz if we rob house 1,2 it'll alert the police,
     * we calculate the sum of
     * 1,3 & than check if the current sum > the max calculated for previous alternative houses
     *
     */

    //revise
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];

        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        int profit1 = returnMaxProfit(Arrays.copyOfRange(nums, 0, nums.length-1));
        int profit2 = returnMaxProfit(Arrays.copyOfRange(nums, 1, nums.length));

        return Math.max(profit1, profit2);
    }

    //1,3,1,3,100
    private int returnMaxProfit(int[] nums) {
        int[] dp = new int[nums.length+1];

        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 1; i<nums.length; i++) {
            //before we rob house i+1, we want to check if robbing house i+1 would give us the max sum or robbing the house next to i+1 would give us max result
            //remeber we can't rob houses that're adjecent eg. 1,2,1,1,4 -> we can't rob house 1 & 2 however we can rob house next to house 2 if we skip house 2 cuz the onlly condition is we can't rob adjecent/conseucitve houses

            //for robbing house i+1, we check if robbing profit from prev house i-e; house i or robbing profit from house before the prev house i-e; i-1 + the potential profit we can make from robbing current house
            // is max.

            //note that dp[i] doesn't mean the profit calculated for house[i] rather dp[i] means profit calculated for house[i-1]
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
        }

        return dp[nums.length];
    }
}
