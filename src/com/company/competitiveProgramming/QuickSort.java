package com.company.competitiveProgramming;

public class QuickSort {
    public int[] sort(int[] x, int start, int end) {
        if(start >= end) // invalid segment of the array cuz of dividing array into sub arrays
            return null;

        int pIndex = partition(x, start, end);
        sort(x, start, pIndex-1);
        sort(x, pIndex+1, end);
        return x;
    }

    private int partition(int[] x, int start, int end) {
        int pivot = x[end];
        int pIndex = start;

        for(int i=start; i<end; i++) {
            if(x[i] < pivot) {
                //swap
                swap(x, i, pIndex);
                pIndex++;
            }
        }

        if(x[pIndex] > pivot) {
            //swap
            swap(x, pIndex, end);
        }
        return pIndex;
    }

    private void swap(int[] x, int indexToPushTowardsRight, int pivotIndex) {
        int temp = x[indexToPushTowardsRight];
        x[indexToPushTowardsRight] = x[pivotIndex];
        x[pivotIndex] = temp;
    }
}
