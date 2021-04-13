package com.company.competitiveProgramming;

public class ProductOfArrayExceptSelf {
    /**
     GIVE ARRAY : [1,2,3,4]

     Prod from Left:
     # the very first index of the prodFromLeft array = 1
     # prodFromLeft till index = 1 should be 1 cuz we're include the value 2 (which is at index 1) in that product cuz we want to calculate prod of nums till reaching the index 1
     so
     1. prod[1] = 1 * 1
     2. prod[2] = 1 * 2
     3. prod[3] = 2 * 3

     and now we've reached the end of the array


     Prod from Right:
     1. prod[2] = 1 * 4
     2. prod[1] = 4 * 3
     3. prod[0] = 12 * 2


     --> [1,1,2,6]
     [24,12,4,1] <--

     result: [24,12,8,6]
     */

    /**
     Easy explanation
     giveArray: [1,2,3,4]
     leftProdArray = [1, 1*1, 1*2, 2*3]
     rightProdArray = [12*2, 4*3, 1*4, 1]

     Than prod of leftProdArray & rightProdArray = result
     */
    //read about prefix sum and sufix sum and prefix prod and sufix prob
    //TC O(n)
    //SC O(n) cuz we're not including the answer array which in this code is prodFromLeft array into space complexity
    public int[] productExceptSelf(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[1];

        int[] prodFromLeft = new int[nums.length];
        int[] prodFromRight = new int[nums.length];

        prodFromLeft[0] = 1;
        //we're calcuating product of nums from left till ith index
        //the way acheive this is by putting the very first value in the prodFromLeft array as 1
        int j=0;
        for(int i=1; i<nums.length; i++) {
            prodFromLeft[i] = prodFromLeft[i-1] * nums[j++];
        }


        //setting prodFromRight = 1 cuz when we want to calculate prod from right till index i,
        //we acheive that by setting the very last item in the prodFromRight = 1

        prodFromRight[nums.length-1] = 1;

        j= nums.length-1;
        for(int i=nums.length-2; i>=0; i--) {
            prodFromRight[i] = prodFromRight[i+1] * nums[j--];
        }

        int[] result = new int[nums.length];
        for(int i=0; i<nums.length; i++)
            result[i] = prodFromLeft[i] * prodFromRight[i];

        return result;
    }

    //tc = O(n)
    //SC O(1)
    //wrote completely myself but later saw Errichto video
    //he does and explains it too
    public int[] productExceptSelf_WITH_DIVISION(int[] nums) {
        if(nums == null || nums.length == 0)
            return new int[1];

        int numOfZeros = 0;
        int arrayProduct = 1;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 0)
                numOfZeros++;
            else
                arrayProduct *= nums[i];
        }

        if(numOfZeros > 1) {
            for(int i=0; i<nums.length; i++)
                nums[i] = 0;
        }
        else {
            for(int i=0; i<nums.length; i++) {
                if(numOfZeros == 1) {
                    if(nums[i] == 0)
                        nums[i] = arrayProduct;
                    else
                        nums[i] = 0;
                }
                else {
                    if(nums[i] == 0) {
                        nums[i] = arrayProduct;
                        arrayProduct = 0;
                    }
                    else {
                        nums[i] = arrayProduct/nums[i];
                    }
                }
            }
        }

        return nums;
    }
}
