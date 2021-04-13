package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestIncreasingSubsequence_DP {
    /*
        IDEA:
            We've to find the MAX number of elements that are increasing in number & they don't have to be continuous subsequence aka subarray

            [5 4 3 2 1]

            If we've an array like this than the longest increasing subsequence will only be 1
            cuz
                1. each element in the array is a subsequence
                2. there's no number after every number that's greater than it

            Therefore we can also call the above array a strictly decreasing array

            Eg. we've this array

            [3,4,-1,0,6,2,3]

            The longest increasing subsequence is -1,0,2,3 cuz it's has 4 numbers that're in increasing order
            -1,0,6 is not the longest cuz it has 3 nums

        SOLUTION:

            The idea is to use dynamic programming with 2 pointers
            1. We create a dp array of size = the given array size
            2. Fill it with 1s cuz each element alone is also a subsequence
            3. Than we've 2 nested loops, i, j
            4. Loop i starts from 1 & goes till nums.length
            5. Loop j is inside loop i and loop j starts from 0 and goes till i

        Explanation:
            in the very beginning, i = 1, j = 0

            if nums[j] < nums[i] it means the number is in increasing order
            than we check if in the DP array if at dp[i] <= dp[j], we do dp[i] = 1 + dp[j]
            The reason we do this is because

            since value at nums[j] < nums[i], and dp[j] already includes the longest increasing subsequence until index j,
            and since nums[j] < nums[i], if we include num[i] into that longest increasing subsequence, dp[i] will become longest increasing subsequence for element at index i

    */

    //n log n TC
    public int lengthOfLIS(int[] nums) {

        /**
         In this approach, we scan the array from left to right. We also make use of a dpdp array initialized with all 0's. This dpdp array is meant to store the increasing subsequence formed by including the currently encountered element. While traversing the numsnums array, we keep on filling the dpdp array with the elements encountered so far. For the element corresponding to the j^{th}j
         th
         index (nums[j]nums[j]), we determine its correct position in the dpdp array(say i^{th}i
         th
         index) by making use of Binary Search(which can be used since the dpdp array is storing increasing subsequence) and also insert it at the correct position. An important point to be noted is that for Binary Search, we consider only that portion of the dpdp array in which we have made the updates by inserting some elements at their correct positions(which remains always sorted). Thus, only the elements upto the i^{th}i
         th
         index in the dpdp array can determine the position of the current element in it. Since, the element enters its correct position(ii) in an ascending order in the dpdp array, the subsequence formed so far in it is surely an increasing subsequence. Whenever this position index ii becomes equal to the length of the LIS formed so far(lenlen), it means, we need to update the lenlen as len = len + 1len=len+1.

         Note: dpdp array does not result in longest increasing subsequence, but length of dpdp array will give you length of LIS.

         Consider the example:

         input: [0, 8, 4, 12, 2]

         dp: [0]

         dp: [0, 8]

         dp: [0, 4]

         dp: [0, 4, 12]

         dp: [0 , 2, 12] which is not the longest increasing subsequence, but length of dpdp array results in length of Longest Increasing Subsequence.
         */

        if(nums == null || nums.length == 0)
            return 0;

        //THIS DOES NOT CONTAIN THE INCREASING SUBSEQUENCE ELEMENTS
        //IT ONLY HELPS IN FINDING LIS and at the end the size of this dp is = LIS
        List<Integer> dp = new ArrayList<>();

        for(int i=0; i<nums.length; i++) {

            int insertionPoint = Collections.binarySearch(dp, nums[i]);

            /**
             binary search method returns
             1. index where the number is found
             2. If the number is not found, it returns
             a. -(index where the number should be inserted) - 1

             So if we have an array like

             1 2 3 4 7
             Collections.binarySearch(array, 6) would return -5
             which means

             Math.abs(-5) - 1 => index 4 (0 based as array indices are)
             So the end result would be
             1 2 3 4 6
             */
            if(insertionPoint < 0)
                insertionPoint = Math.abs(insertionPoint) - 1;

            //if the insertionPoint is equal the current size of the list, than just insert the element
            //this could happen when we've an empty list or an later in the search for LIS
            if(insertionPoint == dp.size())
                dp.add(nums[i]);
            else
                dp.set(insertionPoint, nums[i]);
        }

        return dp.size();
    }




    //HOW TO COUNT LONGEST INCREASING SUBSEQUENCE: Tushan Roy: https://www.youtube.com/watch?v=CE2b_-XfVDk
    public int lengthOfLIS_NSquareTC(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        int[] dp  = new int[nums.length];
        Arrays.fill(dp, 1);

        int longestIncreasingSubsequenceLength = 1;
        for(int i=1; i<nums.length; i++) {
            for(int j=0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], 1+dp[j]);

                    longestIncreasingSubsequenceLength = Math.max(longestIncreasingSubsequenceLength, dp[i]);
                }
            }
        }

        return longestIncreasingSubsequenceLength;
    }
}
