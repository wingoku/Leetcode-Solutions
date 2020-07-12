package com.company.competitiveProgramming;

public class ArrayMaxConsecurtiveSum2 {

    public int findConsecutiveSubarray(int[] nums) {
        int currentMax = 0;
        int globalMax = 0;

        globalMax = currentMax = nums[0];

        for(int i=1; i<nums.length; i++) {
            currentMax = Math.max(nums[i], currentMax + nums[i]);
            globalMax = Math.max(globalMax, currentMax);
        }

        return globalMax;
    }

    //this one fails. The reason is explained here:
   /* public int findConsecutiveSubarray(int nums[]) {
        int currentSum = 0;
        int max =Integer.MIN_VALUE;;

        int i=0;
        while(i < nums.length) {
            currentSum += nums[i];

            if(max < currentSum)
                max = currentSum;

            if(max < nums[i]) {
                max = nums[i];
                currentSum = nums[i];
            }

            i++;
        }
        System.out.println("maxSum : "+ max);
        return max;
    }*/
}
