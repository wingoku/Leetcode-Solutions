package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

    //leetcode 5ms
    //amazon coding interview
    //revise
    public List<Integer> findDuplicates(int[] nums) {
        if(nums == null || nums.length == 1)
            return new ArrayList<>();

        List<Integer> dups = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {
            int absValueFromLoopIndex = Math.abs(nums[i]);
            int indexToCheckForFlip = absValueFromLoopIndex-1; //-1 cuz the array is 0 based however the values are 1->nums.length

            if(nums[indexToCheckForFlip] < 0)
                dups.add(absValueFromLoopIndex);
            else
                nums[indexToCheckForFlip] *= -1;
        }
        return dups;
    }
}
