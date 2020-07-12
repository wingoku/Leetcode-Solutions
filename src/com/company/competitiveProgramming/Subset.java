package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {
    //no solved  yet according to leetcode
    public List<List<Integer>> subsets(int[] nums) {
        int totalPossibleSubsets = (int) Math.pow(2, nums.length)-1;

        List<List<Integer>> subsets = new ArrayList<>();


        int i=0;
        subsets.add(new ArrayList<>());
        i++;

        List<Integer> completeSubset = new ArrayList<>();
        for(i=0; i<nums.length; i++) {
            completeSubset.add(nums[i]);
            subsets.add(Arrays.asList(nums[i]));
        }

        if(i >= totalPossibleSubsets)
            return subsets;

        subsets.add(completeSubset);
        i++;

        int startPointer = 0;
        int endPointer= 1;

        while(i<totalPossibleSubsets) {
            subsets.add(Arrays.asList(nums[startPointer], nums[endPointer]));

            if(endPointer < nums.length-1) {
                endPointer++;
            }
            else
                if(startPointer < endPointer-1) {
                    startPointer++;
                }
            i++;
        }

        System.out.println("subsetsL "+ subsets.toString());
        return subsets;
    }
}
