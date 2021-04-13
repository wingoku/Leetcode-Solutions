package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class RussianDollEnvelopes {
    /**

     [[2,3], [5,4],[6,4],[6,7]]

     The idea is to sort the envelopes based on the following criteria.

     sort the envelopes based on the width in ascending order
     so smaller width envelopes come before bigger width envelopes

     however the edge case is

     if the width of 2 envelopes is the same than we need to put
     the envelope with bigger height before the evelope with smaller height

     2 reasons to do that:
     if we put the smaller height envelope after the envelop with same width but bigger height

     we increase the chance of envelop with smaller height to get fit into an envelop that's on its right side
     i-e; the envelop on its right side with have bigger width & also potentially bigger height

     The other reason is, if we don't arrange envelopes with same width & different heights such that the one
     with bigger height comes before the one with smaller height,
     our LIS function will not work!

     Consider this example from leetcode:

     Consider an input [[1, 3], [1, 4], [1, 5], [2, 3]]. If we simply sort and extract the second dimension we get [3, 4, 5, 3],            which implies that we can fit three envelopes (3, 4, 5). The problem is that we can only fit one envelope, since envelopes            that are equal in the first dimension can't be put into each other.

     In order fix this, we don't just sort increasing in the first dimension - we also sort decreasing on the second dimension,             so two envelopes that are equal in the first dimension can never be in the same increasing subsequence.

     Now when we sort and extract the second element from the input we get [5, 4, 3, 3], which correctly reflects an LIS of one.
     */

    //revise!!!
    //TC: n log n. n log n for sorting and our LIS also works in nlogn
    //SC: O(N)
    public int maxEnvelopes(int[][] envelopes) {

        if(envelopes == null || envelopes.length == 0)
            return 0;
        Arrays.sort(envelopes, (env1, env2) -> {

            int width1 = env1[0];
            int width2 = env2[0];
            int height1 = env1[1];
            int height2 = env2[1];

            //if widths are same than we need to put
            //these envelopes based on the their heights in terms of descending order.
            if(width1 == width2) {
                return Integer.compare(height2, height1);
            }

            return Integer.compare(width1, width2);
        });

//         for(int[] x : envelopes) {
//             System.out.println(x[0]+", "+x[1]);
//         }

        int lisWidth = lis(envelopes, true);
        int lisHeight = lis(envelopes, false);

        int result = Math.min(lisWidth, lisHeight);

        return result;
    }

    //classic longest increasing subsequence using binary search code!
    private int lis(int[][] env, boolean isLISForWidth) {

        List<Integer> dp = new ArrayList<>();
        int index = 1;

        if(isLISForWidth)
            index = 0;

        for(int i=0; i<env.length; i++) {
            int insertionPoint = Collections.binarySearch(dp, env[i][index]);

            if(insertionPoint < 0)
                insertionPoint = Math.abs(insertionPoint) - 1;

            if(insertionPoint == dp.size())
                dp.add(env[i][index]);
            else
                dp.set(insertionPoint, env[i][index]);
        }

        return dp.size();
    }
}
