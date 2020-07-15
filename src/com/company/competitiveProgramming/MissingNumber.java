package com.company.competitiveProgramming;

public class MissingNumber {
    //leetcode accepted it
    // 1 ms
    // AMAZON CODING INTERVIEW

    /**
     * The idea is to find one missing number in the given array
     * So if we've an array which has the largest number = 9,
     * and one item is missing
     * That means the missing number should be from 0 -> 9
     * We just create a boolean array & set the numbers that're in the array as true
     * The one that's not in the array will by default in boolean array, it'll be false
     */
    public int findMissingNumber(int[] nums) {
        if(nums.length == 0)
            return -1;
       boolean[] visitedNumbers = new boolean[nums.length+1];

        for(int n : nums) {
            visitedNumbers[n] = true;
        }

        for(int i=0; i<visitedNumbers.length; i++)
            if(visitedNumbers[i] == false)
                return i;
        return -1;
    }

    /**
     * gaussian formula: for calculating the sum from 1 -> N, the formula is n * (n+1)/2
     * Since we're missing a number that we want to find out.
     * We sum all the numbers given in nums array.
     * Than we subtract that sum from sum calculated using Gaussian formula,
     * the result is the missing number
     */

    //accepted leetcode
    public int findMissingNumberWithGaussionSum(int[] nums) {
        int sum = 0;
        for(int i=0; i < nums.length; i++) {
            sum += nums[i];
        }

        int totalNumbersInRange = nums.length; // NOT DOING nums.length + 1 cuz the nums.length returns the length in terms of 1th index so if an array has 9 items in it, it's length would be 10 & values in the array can be 0 -> 9 or 1-> 10
        // so if the missing number is zero, the expectedSum & the sum calculated using nums array will be equal & subtracting them will give us 0
        int expectedSum = totalNumbersInRange * (totalNumbersInRange + 1) / 2; // gaussian formula: for calculating the sum from 1 -> N, the formula is n * (n+1)/2
        int missingNumber = expectedSum - sum;
        return missingNumber;
    }

    /*public int findMissingNumber(int[] nums) {
        if(nums.length == 1)
            return nums[0] == 0 ? 1 : 0;

        int missing = nums.length;
        boolean tempNums[] = new boolean[nums.length+1]; //cuz one is missing

        *//*for(int i:nums) {
            tempNums[i] = true;
        }

        for(int i=0; i<tempNums.length; i++)
            if(!tempNums[i]) {
                missing = i;
                break;
            }*//*



        *//*for(int i=0; i<nums.length; i++) {
            missing ^= nums[i];
        }

        System.out.println("missing is: "+ missing);
        if((missing & 1) == 1)
            missing -=1;*//*
        *//*else
            missing +=1;*//*
        *//*if(missing == -1)
            missing = i;*//*

        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            missing += nums[i];
            sum+=i;
        }


        System.out.println("nums.length is: "+ nums.length);
        System.out.println("missing is: "+ (missing-sum));
        return missing;
    }*/
}
