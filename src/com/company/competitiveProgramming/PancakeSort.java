package com.company.competitiveProgramming;

import java.util.Arrays;

public class PancakeSort {

    //revise
    public void flip(int[] arr, int k) {
        int temp = 0;
        /*for(int i=k; i>0; i--) {
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
            index++;
        }*/

        int j = k;
        for(int i=0; i<k; i++) {
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
            j--;

            //cuz both value on both index i & j is the same and we've reached the middle of the swap so no need to continue
            if(i == j)
                break;
        }

//        int[] tempA = Arrays.copyOfRange(arr, 0, k+1);
//        for(int i=0; i<tempA.length; i++)
//            arr[i] = tempA[tempA.length-i-1];
    }

    public int findLargestNumberIndex(int[] arr, int limit) {
        int max = arr[0];
        int index = 0;

        for(int i=1; i<limit; i++) {
            if(max < arr[i]) {
                index = i;
                max = arr[i];
            }
        }

        return index;
    }

    public int[] pancakeSort(int[] arr) {
        for(int i=0; i<=arr.length; i++) {
            int k = findLargestNumberIndex(arr, arr.length-i);
            flip(arr, k);
            System.out.println("flip K");
            printArray(arr);

            flip(arr, arr.length-i-1);

            System.out.println("\nflip entire");
            printArray(arr);
            System.out.println("\n=============================");
        }

        return arr;
    }

    private void printArray(int[] arr) {
        for(int i : arr) {
            System.out.print(i+", ");
        }
    }
}
