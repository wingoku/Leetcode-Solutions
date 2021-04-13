package com.company.competitiveProgramming;

import java.util.HashMap;

public class SubarraySumEqualK {
    /**
     The idea is to solve the problem with cumulative sum
     How does cumulative sum works?


     Consider the following array:

     array:   10 5 7 1 2 5 3
     indexes: 0  1 2 3 4 5 6

     sum from index 0 till index 1 inclusive is 15
     sum from index 0 till index 4 inclusive is 25

     if we want to find what's the sum of subarray from index 2 till index 4

     we need to subtract the sum until index 4 & sum until index 1

     i-e; 25 - 15 = 10. This way we don't have to calculate the sum of subarray 7+1+2.

     We can also say that after index 1, we've GAINED a sum that's equal to 10


     Using this idea, we'll find how many times a subarray occurs in the give subarray whose sum is equal to a give value

     For example:
     Let's take the same array again:

     array:   10 5 7 1 2 5 3
     indexes: 0  1 2 3 4 5 6

     We want to FIND HOW MANY SUBARRAYS are in the given array whose sum == 15

     array:           10   5   7   1   2   5   3
     indexes:         0    1   2   3   4   5   6
     ---------------------------------------------
     cumulativeSum:   10   15  22  23  25  30  33

     In the given array there are 2 subarrays whose sum == 15

     subarray 1: from index 0 -> 1 i-e; 10 + 5         = 15
     subarray 2: from index 2 -> 5 i-e; 7 + 1 + 2 + 5  = 15

     or in terms of cumulative sum,
     cumulativeSum till index 5 - cumulativeSum till index 0
     25             -       10   = 15

     or we could also say 25 - the given value K
     i-e; 25 - 15 = 10

     meaning if we remove 10 from the cumulative sum we've calculated till index 5, we get the value K
     or we can also say if we gain 15 from index 0, we get the sum = 25 which is the cumulative sum at index 5

     Using this concept we keep putting the cumulative sum we've at each index in a map
     and we also add the number of times that cumulative sum value was calculated when going through the array
     Maintaining the count of cumulative sum at each index is helpful WHEN we're given arrays with negative values
     in such arrays the cumulative sum might happen again

     For example:

     find subarray where k = 7

     Given array:   3   4   7   2   -3   1   4   2
     Indexes:       0   1   2   3    4   5   6   7
     ----------------------------------------------------
     cumulativeSum: 3   7   14  16   13  14  18  20

     In this example cumulative sum 14 repeats twice. WHich means 2 subarrays are there whose sum = 7
     cuz we gained a sum of 7 at index 2 and hence the cumulative sum at indx 2 = 14
     and since 14 - K = 7, it means we gained 7 and that means if 14 happens again it'll mean we gained 7 again and hence there's another
     subarray whose sum = 7

     therefore we maitain the count of cumulative sum at each index
     */

    //tc: O(N)
    //tutorial WITH CLEAR EXPLANATION: https://www.youtube.com/watch?v=MHocw0bP1rA
    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> prefixSumMap = new HashMap<>();

        //there could be an instance that there's a standalone number in the give array that's = k
        //and since we're finding subarrays whose sum = k using sum-k, we'll get 0 cuz given k matches sum
        //consider followin example
        //Eg. [4,-4, 7], k = 7
        //cumulative sum (which is sum variable in our code) after nums[1] will be zero, after sum += nums[2], sum = 7
        prefixSumMap.put(0, 1);

        int sum = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];

            //doing sum - k cuz the sum will certainly get bigger than k if the array has at least SOME positive values!
            if(prefixSumMap.containsKey(sum - k)) {
                count += prefixSumMap.get(sum - k);
            }

            prefixSumMap.put(sum, prefixSumMap.getOrDefault(sum, 0)+1);
        }

        return count;
    }
}
