package com.company.competitiveProgramming;

public class HighestPowerOf2 {
    public void findHighestPowerOf2LessThanOrEqualToGiveNumber(int num) {

        /**
         * Why n & (n - 1) works:
         * 	1. Suppose n is 10 => 10 & (10 - 1) => 10 & 9 => 1010 & 1001 = 1001 => 1000 which is binary form of 8 & since
         * 	8 !=0, 10 can't be calculated with power of 2
         * Suppose n is 8 => 8 & (8 - 1) => 8 & 7 => 1000 & 0111 = 1000 => 0, therefore 8 can be calculated with a power of 2
         */
        int temp = 0;
        while(true) {
            temp = num & (num-1);
            System.out.println("num: "+ num);

            if(temp == 0)
                break;

            num = temp;
        }

        System.out.println("highestPowerOf2: "+ num);
    }
}
