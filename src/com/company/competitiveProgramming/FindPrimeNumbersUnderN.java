package com.company.competitiveProgramming;

import javax.sound.midi.SysexMessage;
import java.util.Arrays;

public class FindPrimeNumbersUnderN {

    /*
    2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173, 179, 181, 191, 193, 197, 199,
     */

    //https://www.youtube.com/watch?v=PypkiVlTRa4&feature=youtu.be
    //accepted solution based off of sieve of eratosthenes algo. Faster than 95 solutoins. Easier to understand.
    //TC: O(n log log n)
    public int countPrimes(int n) {

        if(n <= 2)
            return 0;

        if(n == 3)
            return 1;

        boolean[] multiples = new boolean[n];
        multiples[0] = true;
        multiples[1] = true;

        //this loop will go over the numbers until n such that num*num < n
        for(int i=2; i*i < n; i++) {

            //if we've already calculated the multple of num i, no need to recalculate its multiples again
            if(multiples[i] == true)
                continue;

            //the inner loop will calculate the multiples of current i
            //lets say n = 10
            //if i = 2,
            //j = 4, since 4 < 10. we do j+i which is equal to 6. Since 6 < 10, we do j+i=6+2=8. Than since j+i=8+2=10 is not less than 10, we get out of this inner loop
            for(int j=i*i; j<n; j+=i) {
                multiples[j] = true;
            }
        }

        int primes = 0;

        for(boolean b : multiples) {
            if(b == false)
                primes++;
        }

        return primes;
    }

    //accepted solution based off of sieve of eratosthenes algo. Faster than 96.58 solutoins.
   /* public int findPrimeNumbers(int n) {
        if(n<=2)
            return 0;
        if(n==3)
            return 1;
        if(n==4)
            return 2;

        int primeCount = 0;
        boolean[] tempBooleanArray = new boolean[n];

        for(int i=2; i*i<n; i++) {
            if(!tempBooleanArray[i])
                for(int j=i*i; j<n; j+=i) {
                    if(!tempBooleanArray[j]) {
                        primeCount++;
                        tempBooleanArray[j] = true;
                    }
                }
        }

      *//*  for(int i=2; i<n; i++)
            if(!tempBooleanArray[i])
                primeCount++;
*//*
      System.out.println("count "+ (primeCount));
      System.out.println("total: "+ (n-primeCount-2));
        return primeCount;
    }*/

    // my working solution BUT IT"S SUPER SLOW
    /*public int findPrimeNumbers(int n) {
        if(n <= 2) {
            return 0;
        }

        if(n == 3)
            return 1;
        if(n == 4)
            return 2;

        int primeNumbersCount = 2;


        *//*for(long i=n; i>=7; i--) {
            if(i%2 >= 1 && i%3 >= 1 && i%5 >= 3 && i%7 >= 1) {
                System.out.println(i+" is a prime");
                primeNumbersCount++;
            }
        }

        if(n>7)
            primeNumbersCount+=4;*//*

        long remainder = 1;
        int j=2;
        for(long i=4; i<n; i++) {
            for(j=2; j<=i/2 && remainder != 0; j++) {
//                System.out.println(i+"%"+j+"= "+ (i%j));
                remainder = (i%j);
            }

            if(remainder != 0) {
//                System.out.println(i+" is prime");
                primeNumbersCount++;
            }
            remainder = 1;
        }

        System.out.println("total Primes: "+ primeNumbersCount);

        return primeNumbersCount;
    }*/

   /* private long calculatePascalEntryInRow(long row, long entry) {
        long result = 0;
        System.out.println("row: "+ row + " col: "+ entry);
        System.out.println("calculateFactorial(entry): "+ calculateFactorial(entry));
        System.out.println("calculateFactorial(row-entry): "+ calculateFactorial(row-entry));
        result = calculateFactorial(row) / (calculateFactorial(entry) * calculateFactorial(row-entry));
        return result;
    }

    private long calculateFactorial(long num) {
        long result = 1;
        for(long i=num; i>0; i--)
            result *= i;
        return result;
    }*/
}
