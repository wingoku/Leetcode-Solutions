package com.company.competitiveProgramming;

public class FibonacciNumbers {

    //solve using dynammic programming
    //leetcode
    public int fib(int N) {
                        //N+1 cuz we need to calculate the Fibonacci number for the given N not until N therefore we create a DP array until N+1 to include the Fib of N
        return calcFibo(new int[N+1], N);
    }

    private int calcFibo(int[] dp, int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        //if dp[n] != 0 means we already calculated Fibonacci for number n & we just return the value instead of recalculating it with recursiuon
        if( dp[n] != 0) {
            return dp[n];
        }

        int result = calcFibo(dp, n-1) + calcFibo(dp, n-2);
        dp[n] = result;

        return result;
    }
}
