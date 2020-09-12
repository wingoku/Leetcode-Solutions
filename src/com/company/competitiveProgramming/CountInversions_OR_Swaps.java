package com.company.competitiveProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class CountInversions_OR_Swaps {

    // Function to count the number of inversions
    // during the merge process
    private int mergeAndCount(int[] arr, int l, int m, int r)
    {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        // Fill from the rest of the left subarray
        while (i < left.length)
            arr[k++] = left[i++];

        // Fill from the rest of the right subarray
        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

    // Merge sort function. Divide and conquer
    //solution taken from here: https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
    private int mergeSortAndCount(int[] arr, int l, int r)
    {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }


    //working solution. Wrote on my own based on the question at this link
    //https://www.geeksforgeeks.org/number-subsequences-form-ai-bj-ck/
    public int countInversions(int[] nums) {
/*
        int dup[] = nums.clone();
        long start = System.nanoTime();
        int inversions = mergeSortAndCount(dup, 0, dup.length-1);*/


        if(nums == null || nums.length <= 1)
            return 0;

        HashMap<Integer, Integer> countsMap = new HashMap<>();

        int inversionsCount = 0;

        for(int i=0; i<nums.length; i++) {
                inversionsCount += updateMapCount(nums[i], countsMap);
        }

        return inversionsCount;
    }

    private int updateMapCount(int newNum, HashMap<Integer, Integer> countsMap) {
        if(countsMap.containsKey(newNum))
            return 0;

        int inversionsCount = 0;
        for(int num : countsMap.keySet()) {
            if(newNum < num) {
                countsMap.put(num, countsMap.get(num) + 1);
                inversionsCount++;
            }
        }

        countsMap.put(newNum, 0);
        return inversionsCount;
    }
}
