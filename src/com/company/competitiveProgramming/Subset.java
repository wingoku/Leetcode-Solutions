package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

    //revise
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();

        findSubsets(nums, subsets, new ArrayList<>(), 0);
        return subsets;
    }

    private void findSubsets(int[] nums, List<List<Integer>> subsets, List<Integer> subset, int index) {

        //adding whatever is in our subset. The reason we're adding it like this cuz we also need to add an empty list as a subset
        //which will be passed to findSubsets() at the start of the very first call
        subsets.add(new ArrayList<>(subset));

        //now we need to simulate adding & not adding certain numbers to create subsets
        for(int i=index; i<nums.length; i++) {
            //add the current num
            subset.add(nums[i]);

            //find all the possible subsets including the number we just added
            findSubsets(nums, subsets, subset, i+1);

            //now remove the number we just added and find the subsets using the next elements in the array in this loop
            subset.remove(subset.size()-1);
        }
    }
}
