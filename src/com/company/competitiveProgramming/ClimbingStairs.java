package com.company.competitiveProgramming;

public class ClimbingStairs {
    //accepted by leetcode
    //amazon coding interview
    public int climbStairs(int n) {
        //it's a dynamic programming question
        int[] dp = new int[n+1]; // because we have to add the base case which is how many steps it takes to climb 0 stairs
        dp[0] = 1;//number of ways we can climb zero stairs is 1 that's we can't climb 0 stairs & that's the only way i-e; we can't climb zero stairs
        dp[1] = 1;//number of ways we can climb 1 stairs is 1 that's we can climb one stair only 1 way that's by taking 1 step. We can't climb 1 stair by climbing 2 stairs

        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-1]+ dp[i-2]; //i-2 & i-2 cuz in order to reach the stair 'i', we should've climbed stair i-1 & stair i-2
            // and since we know how many steps it'd take to reach stair i-1 & stair i-2, we just sum them together to get the answer for
            //climbing stair i
        }

        return dp[n];
    }

    //using backtracking & dynammic programming
    private int backtrack(int dp[], int n) {
        //if n <0 that means we had already reached the top & we can't take any further steps
        if(n < 0) {
            return 0;
        }

        //number of ways we can climb zero stairs is 1 that's we can't climb 0 stairs & that's the only way i-e; we can't climb zero stairs
        if(n == 0) {
            return 1;
        }

        //if dp[n] meaning we've already calculate the number of steps taken for Nth step, we just return the value
        if(dp[n] != 0) {
            return dp[n];
        }

        int result = backtrack(dp, n-1) + backtrack(dp, n-2);
        dp[n] = result;

        return result;
    }
}
