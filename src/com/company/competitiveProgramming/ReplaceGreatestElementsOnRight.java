package com.company.competitiveProgramming;

import java.util.Arrays;

public class ReplaceGreatestElementsOnRight {
    public void replace(int[] num) {
        for(int i= num.length-1; i >0; i--) {
            if(num[i] > num[i-1]) {
                num[i-1] = num[i];
            }
        }

        int[] finalArray = new int[num.length];
        System.arraycopy(num, 1, finalArray, 0, num.length-1);
        finalArray[finalArray.length-1] = -1;

        System.out.println("after replacements");
        for(int i : finalArray) {
            System.out.print(i+", ");
        }
    }
}
