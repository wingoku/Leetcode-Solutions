package com.company.competitiveProgramming;

import java.util.PriorityQueue;

public class KMessedArraySort {
    //pramps question
    //accepted
    public int[] sortKMessedArray(int[] arr, int k) {
        int startPointer = 0;
        int endPointer = k;
        int sortingIndex = 0;

        if(arr.length <= 1)
            return arr;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //1,0,3,2  k=1
        //0 1 3 2
        //0,1,0,3

        //1,0
        //1
        //4
        //5
        //cond 1 =true
        //endPointer+1
        //

        /*
            we need a minHeap of size k+1. The reason we need a heap of size k+1 is because we want to compare the item at the current index with the items at till k including
            the current item therefore k+1
            By default heap sorts the elements inside it upon adding/removing items

         */


        //trick: if we've a maxHeap & we put values as negatives in the heap, it'll act like minHeap
        // 5 4 3 2 1 in maxHeap
        //if we push them with negatives in the heap like this
        // -5 -4 -3 -2 -1
        //maxheap will order them like this everytime we pop
        // -1 -2 -3 -4 -5
        //this trick essentially turns maxHeap into minHeap


        for(int item : arr) {
            minHeap.add(item);
            if(minHeap.size() > k) {
                arr[sortingIndex++] = minHeap.poll();
            }
        }

        while(minHeap.iterator().hasNext())
            arr[sortingIndex++] = minHeap.poll();

        /*for(int i=0; i< k+1; i++)
            minHeap.add(arr[i]);

        for(int i=k+1; i<arr.length; i++) {
            arr[sortingIndex++] = minHeap.poll();
            minHeap.add(arr[i]);
        }

        while(minHeap.iterator().hasNext()) {
            arr[sortingIndex++] = minHeap.poll();
        }*/
        return arr;
    }

    /*public int[] sortKMessedArray(int[] arr, int k) {
        int startPointer = 0;
        int endPointer = k;
        int sortingIndex = 0;

        if(arr.length <= 1)
            return arr;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //1,0,3,2  k=1
        //0 1 3 2
        //0,1,0,3

        //1,0
        //1
        //4
        //5
        //cond 1 =true
        //endPointer+1
        //

        for(int i=0; i< k+1; i++)
            minHeap.add(arr[i]);

        for(int i=k+1; i<arr.length; i++) {
            arr[sortingIndex++] = minHeap.poll();
            minHeap.add(arr[i]);
        }

        while(minHeap.iterator().hasNext()) {
            arr[sortingIndex++] = minHeap.poll();
        }
        return arr;
    }*/
}
