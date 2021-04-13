package com.company.competitiveProgramming;

public class FirstMisingPositive {
    //awesome explanation: https://www.youtube.com/watch?v=9SnkdYXNIzM&list=PLtQWXpf5JNGJagakc_kBtOH5-gd8btjEW&index=15&t=0s
    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0)
            return 1;

        boolean containsOne = false;

        //first we need to check if the give array contains 1
        //we iterate over the array and check if current index == 1
        //if not we turn that index into 1 if it's <= 0 or greater than nums.length. The reason we check for > nums.length
        //is cuz if array contains all numbers from 1->nums.length than the first missing positive number would be nums.length+1
        //eg. [1,2,3,4] - first missing positive number is 5

        //STEP 1
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1)
                containsOne = true;
            else
            if(nums[i] <= 0 || nums[i] > nums.length)
                nums[i] = 1;
        }

        //since the array didn't contain 1, we know 1 is the missing positive number so we end here by saying 1 is the missing positive numer
        if(containsOne == false)
            return 1;

        //this trick is similar to the trick we used in finding positive duplicate numbers in an array question LEETCODE QUESTION: Find All Duplicates in Array
        //we iterate over the array
        //we get the value at each loop index
        //we absolute that value cuz it could have become negative cuz of this loop
        //than we use that extracted index & subtract 1 cuz array indexes are 0 based
        //if the number at nums[extractedIndex - 1] is not negative, we flip it by turning it to negative
        //this will help us in finding the missing number
        //HOW?
        //if all the elements from 1->nums.length are in this array than by the end of this loop, all the values in this array would be negative
        //if one of the values from 1->nums.length is missing, the number at that index won't be flipped aka turned negative
        //EG.
        //give array: [1,2,-1,4]
        // after step 1 the array would be [1,2,1,4]
        // after this loop (step 2), the array would be [-1,-2,1,-4]
        // so after step 3 we find out that num 3 is missing cuz the value at index 2 is still positive

        //STEP2
        for(int i=0; i<nums.length; i++) {
            int extractedIndex = Math.abs(nums[i]);

            if(nums[extractedIndex-1] > 0)
                nums[extractedIndex-1] *= -1;
        }

        int missingPositive = 0;
        for(int index = 0; index<nums.length; index++) {
            if(nums[index] > 0) {
                missingPositive = index+1; //cuz array indexes are 0 based
                break;
            }
        }

        if(missingPositive == 0)
            missingPositive = nums.length+1; //cuz all the elements existed from 1->nums.length so the first missing positive number is nums.length+1

        return missingPositive;
    }
}
