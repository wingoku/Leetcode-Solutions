package com.company.competitiveProgramming;

import java.util.PriorityQueue;

public class SortArrayByParity {

    //leetcode 1ms
    //TC: O(n)
    //SC: O(1) cuz we're not allocating new memory
    //I came up with this solution too but Kevin's video also explains the same algo
    //https://www.youtube.com/watch?v=KMaQjKaeBIE&list=PLi9RQVmJD2fZgRyOunLyt94uVbJL43pZ_&index=32&t=0s
    public int[] sortArrayByParityWithoutUsingPriorityQueues(int[] A) {
        if(A == null || A.length == 0)
            return new int[]{};

        int swapIndex = 0;
        for(int i=0; i<A.length; i++) {

            int num = A[i];

            //if we the current num is even, than move it to the begining of the array by swapping the element in the beginning with element at current index i
            if(num %2 == 0) {
                int temp = A[swapIndex];
                //we increment swapIndex cuz if we've swapped element at i=5 which is an even number, with element at index i=0,
                //the next time we come across an even element at index i=6 & if we swap that with index i=0,
                //we will bring the even number we place at index 0 in previous iteration(s), will again be back towards the end of the list
                A[swapIndex++] = A[i];
                A[i] = temp;
            }
        }

        return A;
    }

    //leetcode accepted: 14ms
    //amazon coding interview
    //TC: O(n)
    //SC: O(n)
    public int[] sortArrayByParity(int[] A) {
        if(A == null || A.length == 0)
            return new int[]{};

        PriorityQueue<Integer> parityHeap = new PriorityQueue<>((i1, i2) -> {

            //if both are even, we don't swap
            if(i1 % 2 == 0 && i2 % 2 == 0) {
                return 0;
            }


            //if i1 (which is to the left of i2) is odd, than we swap i1 with i2
            if(i1 % 2 != 0) {
                return 1;
            }

            //otherwise just don't swap
            return -1;
        });

        for(int i : A) {
            parityHeap.add(i);
        }

        int index = 0;
        while(!parityHeap.isEmpty()) {
            A[index++] = parityHeap.remove();
        }

        return A;
    }
}
