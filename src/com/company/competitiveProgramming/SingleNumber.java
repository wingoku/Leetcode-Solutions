package com.company.competitiveProgramming;

import java.util.HashMap;

public class SingleNumber {
    //all solutions accepted!

    //fastest solution
    // AMAZON CODING INTERVIEW
    public int returnNonDuplicateNumberInArray(int[] nums) {
        int nonDuplicate = 0;
        //4,1,2,1,2
        for(int i:nums) {
            nonDuplicate ^= i;
        }

        System.out.println("nonDuplicate: "+ nonDuplicate);
        return nonDuplicate;
    }

    //with hashtables/map
   /* public int returnNonDuplicateNumberInArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int lastNonDup = -1;
        int nonDuplicate = -1;

        HashMap<Integer, Integer> map = new HashMap<>(nums.length);
        for(int i:nums) {

            map.put(i, map.getOrDefault(i, 0)+1);
        }

        System.out.println("map: "+ map.toString());

        for(int i : map.keySet()) {
            if(map.get(i) == 1) {
                nonDuplicate = i;
                break;
            }
        }
        System.out.println("nonDuplicate: "+ nonDuplicate);
        return nonDuplicate;
    }*/

   //sliding window but looping can happen even with single loop 0(n^2) cuz of moving pointers
    /*public int returnNonDuplicateNumberInArray(int[] nums) {
        if(nums.length == 1)
            return nums[0];

        int startPointer = 0;
        int endPointer = 0;
        int nonDuplicate = 0;
        while(startPointer < nums.length && endPointer < nums.length) {
            if(startPointer == endPointer) {
                endPointer++;
                continue;
            }

            if((nums[startPointer] ^ nums[endPointer++]) == 0) {
                endPointer = 0;
                startPointer++;
            }
            else
                nonDuplicate = nums[startPointer];
        }
        System.out.println("nonDuplicate: "+ nonDuplicate);
        return nonDuplicate;
    }*/
}
