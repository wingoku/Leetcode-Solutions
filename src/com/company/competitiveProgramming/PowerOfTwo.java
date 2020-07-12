package com.company.competitiveProgramming;

public class PowerOfTwo {
    //acepted solution. MORE EXPLANATION: https://stackoverflow.com/a/600306/1250107
    // AMAZON CODING INTERVIEW
    public boolean isPowerOfTwo(int n) {
        // why will this bitwise operation work for finding if a number is power of 2
        /**
         * 0 is not a power of 2 therefore we've (n > 0) condition
         * since & operation returns 0 if bits if the 1 & 0 bits are not alligned
         * So for example if we want to check if 5 can be calculated using a power of 2,
         * we do:
         * 5 & (5-1)
         * 5 & 4
         * in bits
         * 101 & 100 = 100 and 100 is the binary form of 4 which is != 0
         *
         * Lets take another example:
         * 16 & (16 -1)
         * 16 & 15
         * 100000 & 1111 = 100000 and 100000 is binary form of 16 therefore it's not equal to 0
         */
        return n > 0 && (n & (n -1)) == 0;
    }

    // a slower method
    public boolean isPowerOfTwo_(int n) {

        /**
         * This solution will also work in finding if the given number can be calculated using power of 2
         * The way it works is:
         * we start looping & multiplying the variable i with 2. i starts from 1
         * It's the same way as multiplying 2 N times to calculate a number that can be calculated using power of 2
         * Eg. given number is 8
         * we start i with 1
         * i *= 2 = 1*2= 2
         * than   = 2*2 = 4
         * than   = 4*2 = 8
         * And since we've this condition in the loop that i<n that means when i value becomes 8 the loop condition will be false & we'll get out of the loop
         * than we check if the calculated number == the given number, if yes than the given number can be calculated using power of 2
         *
         * Another example:
         * give number is 12
         *
         * i *= 2 = 1 * 2 = 2
         *        = 2 * 2 = 4
         *        = 4 * 2 = 8
         *        = 8 * 2 = 16
         *
         *  Now the loop condition is false since 16 < 12,
         *  now we match 16 with the given number 12, 16 == 12? false
         *  therefore 12 can't be calculated using power of 2.
         */
        int i = 1;
        while(i < n) {
            i *= 2;
        }

        return i == n;
    }
}
