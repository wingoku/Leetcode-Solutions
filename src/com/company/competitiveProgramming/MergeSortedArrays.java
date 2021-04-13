package com.company.competitiveProgramming;

public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] temp1 = new int[m];

        for(int i=0; i<m; i++)
            temp1[i] = nums1[i];

        int i1 = 0;
        int i2 = 0;

        int num1 = 0;
        int num2 = 0;
        //i1: 0->1; 0->1; 1->2; 2->3;
        //i2: 0->0; 0->1; 0->1; 0->1; 1->2;
        for(int i=0; i<nums1.length; i++) {
            num1 = Integer.MAX_VALUE; //assigning max value cuz we want the actual array values to be used once one of array's pointer is out of bounds
            num2 = Integer.MAX_VALUE;

            if(i1 < m)
                num1 = temp1[i1];

            if(i2 < n)
                num2 = nums2[i2];

            if(num1 < num2) {
                nums1[i] = num1;
                i1++;
            }
            else {
                nums1[i] = num2;
                i2++;
            }
        }
    }
}
