package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class IntersectionOfTwoArrays2 {
    /**
     In this question, intersection means the intersection from Set theory
     It means common numbers between arrays

     This must not be confused with overlapping subarrays arrays which means common adjecent numbers in both arrays
     */

    //TC: O(M+N) m is length of one array & n is the length of another array
    //SC: O(min(m,n)) which ever array has smaller size, we're putting it in the hashmap
    public int[] intersect(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
            return new int[0];

        int[] result = null;
        if(nums1.length < nums2.length)
            result = intersection(nums1, nums2);
        else
            result = intersection(nums2, nums1);

        return result;
    }

    private int[] intersection(int[] smallArray, int[] largeArray) {
        List<Integer> inter = new ArrayList<>();
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for(int num : smallArray) {
            countMap.put(num, countMap.getOrDefault(num, 0)+1); //keeping count of numbers cuz they may appear in the array more than 1 times
        }

        for(int i=0; i<largeArray.length; i++) {
            if(countMap.containsKey(largeArray[i]) && countMap.get(largeArray[i]) > 0) {
                inter.add(largeArray[i]);
                countMap.put(largeArray[i], countMap.get(largeArray[i])-1);
            }
        }

        int[] result = new int[inter.size()];
        for(int i = 0; i<inter.size(); i++) {
            result[i] = inter.get(i);
        }

        return result;
    }
}
