package com.company;


import com.company.competitiveProgramming.QuickSort;

public class te {

    public int[] twoSum(int[] nums, int target) {
        new QuickSort().sort(nums, 0, nums.length-1);
        return findIndices(nums, target);
    }

    // taking inspirationn from binary search to reduce traversal cost
    private static int[] findIndices(int[] x, int target) {
        //find the index of number <= target in array
        int start = 0, end = x.length;
        int arraySubsectionStartIndex = 0;
        int arraySubsectionEndIndex = 0;
        for(int i=start; i<end; i++) {
            int mid = start + (end - start)/2; //to avoid integer overflow on 32 bit systems
            if(x[mid] <= target) {
                arraySubsectionStartIndex = start;
                arraySubsectionEndIndex = mid;
                break;
            }

            if(x[mid] > target) {
                end = mid;
            }
        }

        int[] indices = {};
        if(arraySubsectionStartIndex <= x.length -1) {
            for (int i = arraySubsectionStartIndex; i < arraySubsectionEndIndex; i++) {
                if (x[i] + x[i + 1] == target) {
                    indices = new int[2];
                    indices[0] = i;
                    indices[1] = i + 1;
                }
            }
        }

        return indices;
    }

    private static void print(Object... obj) {
        String printStatement = "";
        for(Object object : obj) {
            printStatement += " "+object.toString();
        }

        System.out.println(printStatement);
    }
}
