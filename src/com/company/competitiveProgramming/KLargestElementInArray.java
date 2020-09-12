package com.company.competitiveProgramming;

import java.util.PriorityQueue;

public class KLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k > nums.length)
            return 0;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int kthLargestValue = Integer.MIN_VALUE;

        //we create a minHeap of size k+1
        /*for(int i=0; i<k+1; i++) {
            minHeap.add(nums[i]);
        }

        for(int i=k+1; i<nums.length; i++) {
            //we remove the elements previously added in minHeap and add new elements until the end of the loop
            //we this trick at the end of the loop our minHeap will still have k elements left.
            minHeap.poll();
            minHeap.add(nums[i]);
        }
        for(int i=0; i<k; i++) {
            kthLargestValue = minHeap.poll();
        }*/

        //we iterate over the array & add elements to the minHeap
        //when the heap size is greater than K, we start removing the elements
        //when the loop ends, the minHeap will still have K elements left in it
        //and the Kth largest element that we want will be at the top/root of the minHeap
        //because we've added all the elements in the minHeap & removed arrayLength-k elements out of it
        //everytime we add/remove elements from heap (min or max heap), heap sorts the items (such that smallest value is at root of minHeap & largest value is at root of maxHeap)
        for(int item : nums) {
            minHeap.add(item);
            if(minHeap.size() > k)
                minHeap.poll();
        }

        kthLargestValue = minHeap.poll();
        System.out.println("kthLargestValue: "+ kthLargestValue);

        return kthLargestValue;
    }
}
