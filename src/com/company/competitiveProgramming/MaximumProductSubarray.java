package com.company.competitiveProgramming;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {

        /**
         BRUTE FORCE:
         int max = Integer.MIN_VALUE;

         for(int i=0; i<nums.length; i++) {
         int prod = 1;
         for(int j=i; j<nums.length; j++) {
         prod *= nums[j];

         max = Math.max(max, prod);
         }
         }

         return max;
         */
        if(nums == null || nums.length == 0)
            return 0;

        if(nums.length == 1)
            return nums[0];

        int prevMax = nums[0];
        int prevMin = nums[0];
        int gMax = nums[0];

        /**
         we need to keep track of prevMin & prevMax
         cuz if prevMin was negative & current Num is also negative than we'd get a positive result
         and if prevMax was a big number and current number is negative, the we'd still get positive result cuz of the expression we've written

         Geeks for geeks video explains it well
         https://www.youtube.com/watch?v=keVevSvaDKo
         */
        for(int i=1; i<nums.length; i++) {
            int currentNum = nums[i];

            int currentMin = Math.min(nums[i], Math.min(nums[i]*prevMin, nums[i]*prevMax));
            int currentMax = Math.max(nums[i], Math.max(nums[i]*prevMin, nums[i]*prevMax));

            gMax = Math.max(gMax, currentMax);

            prevMin = currentMin;
            prevMax = currentMax;
        }

        return gMax;
    }
}
