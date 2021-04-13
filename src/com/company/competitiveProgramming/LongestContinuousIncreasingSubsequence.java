package com.company.competitiveProgramming;

public class LongestContinuousIncreasingSubsequence {
    /**
        Given example:
         Input: [1,3,5,4,7]
         Output: 3
         Explanation: The longest CONTINUOUS increasing subsequence is [1,3,5], its length is 3.
         Even though [1,3,5,7] is also a CONTINUOUS increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
     */
    /**
     The idea is to match prevNum with currNum and if prevNum > currNum
     we start count the subarray/subsequence again from 1

     The reason we start from count=1 is cuz a single number is also a CONTINUOUS subsequence/subarray

     Eg.
     [2,2,2] in this case the max increasing subsequence is only 1 cuz 2 after 2 is not an increase
     */
    //TC: O(N)
    //SC: O(1)
    public int findLengthOfLCIS(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        int prev = nums[0];
        int max = 1; //cuz a single number is also a subsequence/subarray so max would be 1
        int count = 1; //cuz a single number is also a subsequence/subarray

        for(int i=1; i<nums.length; i++) {
            int currNum = nums[i];
            if(prev < currNum) {
                count++;
            }
            else
                count = 1;

            prev = currNum;
            max = Math.max(max, count);
        }

        return max;
    }
}
