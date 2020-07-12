package com.company.competitiveProgramming;

public class RotateArray {
    //accepted answer 100% faster leetcode
    // time complexity O(n) cuz we're using linear (non nested for loops) & space complexity O(n) cuz we're creating another array of same size as original array if we were using the same array & do inplace swaping to rotate array, the space complexity would've been
    // O(1)
    public int[] rotateArray(int[] nums, int rotationCounts) {

        if(rotationCounts <= 0 || rotationCounts == nums.length)
            return nums;

        int[] rotatedArray = new int[nums.length];

        int j=0;

        //if rotationCount is greater than given array length than we do rotations only rotationCount % array.length
        // cuz rotating the array N times where N is exactly equal to array.length, we get the digits in the array in the same order as original given array back
        // therefore to reduce cpu time, we just rotate the array based on the value of rotationCount % array.length. Remainder mod (%) returns the remainder
        if(rotationCounts > nums.length)
            rotationCounts = rotationCounts % nums.length;


        //copy items from end of the array i-e; starting from the index nums.length - rotationCount.
        for (int i = nums.length - rotationCounts; i < nums.length; i++) {
            rotatedArray[j++] = nums[i];
        }

        j = 0;
        //copy items from original array 0-> nums.length - rotationCount -1
        for (int i = rotationCounts; i < nums.length; i++) {
            rotatedArray[i] = nums[j++];
        }

        System.arraycopy(rotatedArray, 0, nums, 0, rotatedArray.length);

        return rotatedArray;
    }

}
