package com.company.competitiveProgramming;

public class KadaneAlgoMaxSubarray {

    public int maxContiguousSubArray(int[] num) {

        /**
         [-2,1,-3,4,-1,2,1,-5,4]

         cMax = -2, gMax = -2;

         max(num, cMax+num)
         max(1, 1-2) cMax = 1
         max(-3, -3+1) cMax = -2
         max(4, -2+4) cMax = 4
         max(-1, 4-1) cMax = 3
         max(2, 3+2) cMax = 5
         max(1, 5+1) cMax= 6
         max(-5, 6-5) cMax = 1
         max(4, 1+4) cMax = 5
         */

        int cMax = num[0];
        int gMax = num[0];

        for(int i=1; i<num.length; i++) {

            //cMax can contain 2 possible values
            //sum of num[i-1]+prevSum or
            //previous num from array i-e num[i-1], if it was greater than num[i-1]+prevSum
            //eg:
            // for iteration i=4, the situtation would be max(-1, 4-1) cMax = 3
            //where 4 is the cMax coming from prev iteration
            //this helps us in the situtation that if the from previous iterations the sum is less than the current num vale
            //than we won't be able to achieve max sum if keep using prev sum.
            //the only way we can achieve max sum is if we start from current value cuz current value is already bigger
            //than the sum of currentValue+prev sum
            cMax = Math.max(num[i], cMax+num[i]);
            gMax = Math.max(gMax, cMax);
        }

        return gMax;
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
