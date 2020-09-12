package com.company.competitiveProgramming;

import java.util.PriorityQueue;

public class LastStoneWeight {
    //leetcode 1ms
    //did myself
    //revise
    //amazon coding interview
    // tc: O(n)
    // sc: O(n) in worst case
    public int lastStoneWeight(int[] stones) {

        /**
         The problem says we've to choose two heaviest stones among all the stones everytime
         & than smash them.
         Making sure we always select the 2 heaviest stones can only be ensured by maxHeap

         Solution:

         First we add all the stones given in the array into the maxHeap
         than we remove 2 stones upon every loop iteration & if x stone is > y stone than we just save the difference of x-y
         back into the heap.

         we keep doing this until either the heap has 1 or 0 items left
         */

        if(stones == null || stones.length == 0)
            return 0;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((i, j) -> Integer.compare(j,i));

        for(int s : stones)
            maxHeap.add(s);

        int x = 0;
        int y = 0;

        //cuz if we've 1 item left in the heap, we can't remove 2 items
        // & logically we can't smash the remaining 1 stone with anything cuz we don't have another stone
        //therefore we've this condition to end the loop & also it's explanable with the given example in the question
        while(maxHeap.size() > 1) {
            x = maxHeap.remove();
            y = maxHeap.remove();

            if(x > y) {
                maxHeap.add(x-y);
            }

        }
        return maxHeap.isEmpty() ? 0 : maxHeap.remove();
    }
}
