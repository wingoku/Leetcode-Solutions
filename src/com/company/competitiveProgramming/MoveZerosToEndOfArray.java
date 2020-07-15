package com.company.competitiveProgramming;

public class MoveZerosToEndOfArray {
    //accepted leetcode 1ms
    public void moveZeroes(int[] nums) {
        if(nums.length == 0)
            return;

        int temp = -1;
        int startPointer = 0;
        int endPointer = 1;
        while(endPointer < nums.length) {
            if(nums[startPointer] == 0 && nums[endPointer] != 0) {
                temp = nums[endPointer];
                nums[startPointer] = temp;
                nums[endPointer] = 0;
                startPointer++;
            }
            //if startPointer is pointing at zero than we want startPointer to increment and iterate over the array
            else if(nums[startPointer] != 0)
                startPointer++;

            endPointer++;
        }
    }
}
