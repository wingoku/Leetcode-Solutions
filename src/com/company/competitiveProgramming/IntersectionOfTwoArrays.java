package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfTwoArrays {
    /**
     In this question, intersection means the intersection from Set theory
     It means common numbers between arrays

     This must not be confused with overlapping subarrays arrays which means common adjecent numbers in both arrays
     */

    //TC: O(M+N) m is length of one array & n is the length of another array
    //SC: O(min(m,n)) which ever array has smaller size, we're putting it in the hashmap
    public int[] intersection(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        if(nums1.length < nums2.length)
            return findIntersection(nums1, nums2);
        else
            return findIntersection(nums2, nums1);
    }

    private int[] findIntersection(int[] smallArray, int[] largeArray) {
        List<Integer> resultList = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for(int num : smallArray)
            set.add(num);

        for(int i=0; i < largeArray.length; i++) {
            if(set.contains(largeArray[i])) {
                resultList.add(largeArray[i]);
                set.remove(largeArray[i]);
            }
        }

        int[] result = new int[resultList.size()];
        for(int i=0; i<resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
