package com.company.competitiveProgramming;

public class CountingBits {

    //using Dynamic programming
    //inspired by this video's algorithm

    /**
     * The idea is to calculate number of bits in each number upto the given number based on the bits calculated previously for previous numbers
     * when the number is even, we can use the value of previously calculated number that's equal to currentEvenNumber/2
     * when the number is odd, we can use the value of previously calculated number that's equal to  currentOddNumber/2 => take the integer value & leave the decimal value, For example: 7/2 = 3, take the bit count for 3 and add 1 to it
     * Num     Binary  BitsCount
     * 0        0       0
     * 1        01      1
     * 2        10      1       dp[2] = dp[2/2] => dp[2] = 1
     * 3        11      2       dp[3] = dp[3/2] => dp[3] = dp[1]+1 => dp[3] = 1+1
     * 4        100     1
     * 5        101     2
     * 6        110     2
     * 7        111     3
     * 8        1000    1
     * 9        1001    2
     * 10       1010    2
     * 11       1011    3
     * 12       1100    2
     * 13       1101    3
     * 14       1110    3
     * 15       1111    4
     *
     * */
    public int[] countBits(int num) {
        int[] dpBitsArray = new int[num+1];

        if(num == 0) {
            return dpBitsArray;
        }

        dpBitsArray[1] = 1;

        for(int i=2; i<=num; i++) {
            if(i % 2 == 0) {
                dpBitsArray[i] = dpBitsArray[i/2];
            }
            else
                dpBitsArray[i] = dpBitsArray[i/2]+1;
        }

        return dpBitsArray;
    }

    //this solutoin is based on bit manipulation
    //accpted by leetcode
    public int[] countBitsUsingBitManipulation(int num) {
        int count =0;
        int[] bitsArray = new int[num+1];
        int n = 0;
        for(int i=0; i<=num; i++) {
            n = i;
            while (n > 0) {
                n = n & (n - 1);
                count++;
            }

            System.out.println("number of set bits in "+ i+" : "+ count);
            bitsArray[i] = count;
            count = 0;
        }

        return bitsArray;
    }
}
