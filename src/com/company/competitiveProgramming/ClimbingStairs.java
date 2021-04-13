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


    //using recursion
    private int countPaths(int steps, int[] dp) {
        if(steps < 0)
            return 0;

        //because we can only reach the top of the stair case ONCE
        if(steps == 0)
            return 1;

        //if we've already calcualted how many ways we can take STEPS steps, we just return the result instead of recalculating
        if(dp[steps] != 0)
            return dp[steps];

        //from every stair, we've two ways to climb to the next stair, either we take 1 step or we take 2 steps
        //if we take 1 step, it means we can reduce 1 from the current steps eg. we've 3 steps given, if we take 1 step out of 3, we're left with 2 steps
        //similarly if we take 2 steps, we do steps - 2 i-e; if we've 3 steps given and if we take 2 steps, we're left with 3-2 steps that we can take further
        dp[steps] = countPaths(steps-1, dp) + countPaths(steps-2, dp);

        return dp[steps];
    }
}
