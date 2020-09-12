package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.PriorityQueue;

public class MinimumDominoRotationForEqualRow {
    //leetcode 31ms
    //revise
    //amazon, google coding interview
    //consume less memory compared to the priority queue implementation below.
    //in this implementation we're finding the most frequently occuring number without using priority queue since the only purpose of priority queue in the other implementation was to find the frequently ocfuring numer
    public int minDominoRotationsWithoutPriorityQueue(int[] A, int[] B) {

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        int frequentNum1 = 0;
        int frequentNum2 = 0;

        //get the most frequently occuring number in both arrays
        int freqNum1Count = 0;
        int freqNum2Count = 0;

        for(int i=0; i<A.length; i++) {
            map1.put(A[i], map1.getOrDefault(A[i], 0)+1);
            map2.put(B[i], map2.getOrDefault(B[i], 0)+1);
        }

        //finding the frequent number based on it count
        for(int key : map1.keySet()) {
            int temp = Math.max(freqNum1Count, map1.get(key));
            //if temp != prev value of freqNum1Count that means we've a new number that's occuring more frequently
            if(temp != freqNum1Count) {
                frequentNum1 = key;
            }

            freqNum1Count = temp;
        }

        //finding the frequent number based on it count
        for(int key : map2.keySet()) {
            int temp = Math.max(freqNum2Count, map2.get(key));

            //if temp != prev value of freqNum2Count that means we've a new number that's occuring more frequently
            if (temp != freqNum2Count) {
                frequentNum2 = key;
            }

            freqNum2Count = temp;
        }

        int rotations = 0;
        int numToSwap = 0;

        // System.out.println("frequentNum1: "+frequentNum1+" A.length - freqNum1Count : "+ (A.length - freqNum1Count ));
        // System.out.println("frequentNum2: "+frequentNum2+" B.length - freqNum2Count : "+ (B.length - freqNum2Count));

        //if the count of most frequently occuring number in Array A is higher than
        //than the count of the most frequently occuring number in Array B
        //such that countOfFrequentNumberInArrayA - A.length < countOfFrequentNumberInArrayB - B.length
        // this condition will only be true if difference of frequentNumACount - A.length is less than that of B
        //than it means do the swaps for the frequentNumber found in A & it'll give us less swaps
        if(A.length - freqNum1Count < B.length - freqNum2Count) {
            numToSwap = frequentNum1;
            rotations = getRotations(A, B, numToSwap);

            //this condition will be false
            //only if we could swap the frequentA number == number of times frequentNumberA is not present in array A
            //if this condition is true
            //it means array B doesn't have frequentNumA in it at the same positions where frequentNumA is missing from array A
            //therefore we couldn't swap & fill the indexes in array A where frequentNumA wasn't present.
            if(rotations != A.length - freqNum1Count)
                return -1;
        }
        else {
            numToSwap = frequentNum2;
            rotations = getRotations(B, A, numToSwap);

            if(rotations != B.length - freqNum2Count)
                return -1;
        }

        return rotations;
    }

    //leetcode 45ms
    //amazon, google coding interview
    //consumes more space cuz of priorityQueue which is a heap
    //in this method we're using priorityQueue only to get the frequently occuring number easily. Other than that the maxHeap is serving no other purpose
    public int minDominoRotationsWithPriorityQUeue(int[] A, int[] B) {

        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        PriorityQueue<Integer> maxHeap1 = new PriorityQueue<>((i1, i2) -> Integer.compare(map1.get(i2), map1.get(i1)));
        PriorityQueue<Integer> maxHeap2 = new PriorityQueue<>((i1, i2) -> Integer.compare(map2.get(i2), map2.get(i1)));

        for(int i=0; i<A.length; i++) {
            map1.put(A[i], map1.getOrDefault(A[i], 0)+1);
            map2.put(B[i], map2.getOrDefault(B[i], 0)+1);
        }

        maxHeap1.addAll(map1.keySet());
        maxHeap2.addAll(map2.keySet());

        int frequentNum1 = maxHeap1.poll();
        int frequentNum2 = maxHeap2.poll();

        int freqNum1Count = map1.get(frequentNum1);
        int freqNum2Count = map2.get(frequentNum2);

        int rotations = 0;
        int numToSwap = 0;

        // System.out.println("frequentNum1: "+frequentNum1+" A.length - freqNum1Count : "+ (A.length - freqNum1Count ));
        // System.out.println("frequentNum2: "+frequentNum2+" B.length - freqNum2Count : "+ (B.length - freqNum2Count));

        if(A.length - freqNum1Count < B.length - freqNum2Count) {
            numToSwap = frequentNum1;
            rotations = getRotations(A, B, numToSwap);

            if(rotations != A.length - freqNum1Count)
                return -1;
        }
        else {
            numToSwap = frequentNum2;
            rotations = getRotations(B, A, numToSwap);

            if(rotations != B.length - freqNum2Count)
                return -1;
        }
        // if(freqNum1Count + freqNum2Count < A.length)
        //     return -1;

//         if(freqNum1Count > freqNum2Count) {
//             rotations = getRotations(A, B, frequentNum1);

//             if(rotations != frequentNum2)
//                 return -1;
//         }
//         else if(freqNum1Count < freqNum2Count) {
//             rotations = getRotations(B, A, frequentNum1);

//             if(rotations != frequentNum1)
//                 return -1;
//         }

        return rotations;
    }

    private int getRotations(int[] A, int[] B, int frequentNum) {

        // System.out.println("frequentNum: "+ frequentNum);

        int rotations = 0;
        for(int i=0; i<A.length; i++) {
            if(A[i] != frequentNum && B[i] == frequentNum) {

                // System.out.println("A[i]: "+ A[i] + " index: "+i);
                rotations++;
            }
        }

        // System.out.println("rotations: "+ rotations);
        return rotations;
    }
}
