package com.company.competitiveProgramming;

public class RemoveElement {

    //simple working solution from Kevin Naughtons channel
   /* public int removeElement(int[] nums, int val) {
        int index = 0;

        for(int i : nums) {
            if(i != val)
                nums[index++] = i;
        }

        return index;
    }*/


    //working solution accepted by leetcode
    //this solution is complicated cuz it moves the val to the end of the array
    public int removeElement(int[] nums, int val) {
        int totalValsFound = 0;
        int indexOfNonVal = -1;
        int prevIndexofNonVal = -1;

        for(int i=0; i<nums.length; i++)
            if(nums[i] == val)
                totalValsFound++;

        if(nums.length - totalValsFound == 0)
            return 0;

        for(int i=0; i<nums.length; i++) {
            if(nums[i] == val) {
                for(int j=i; j<nums.length; j++) {
                    if(nums[j] != val) {
                        indexOfNonVal = j;
                        break;
                    }
                }

                if(prevIndexofNonVal != indexOfNonVal) {
                    nums[i] = nums[indexOfNonVal];
                    nums[indexOfNonVal] = val;
                }
            }

            prevIndexofNonVal = i;
            indexOfNonVal = i;
        }

        System.out.println("no. of nonVals found: "+ totalValsFound);

        for(int i : nums)
            System.out.print(i+", ");

        return nums.length - totalValsFound;
    }
}
