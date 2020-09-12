package com.company.competitiveProgramming;

public class MinCostOfClimbingStairs {

    //accepted. Solve with Nick whites video
    //leetcode accepted
    //amazon coding interview
    public int minCostClimbingStairs(int[] cost) {
        //solve via dynamic programming

        int step1Cost = 0;
        int step2Cost = 0;
        int currentStepCost = 0;

        for(int i=cost.length -1; i>=0; i--) {
            currentStepCost = cost[i] + Math.min(step1Cost, step2Cost);

            //now we need to get ready to calculate the cost of next step towards left therefore
            //shifting the steps to left <-
            //step2Cost now becomes the current step1Cost
            //step1Cost now becomes the currentStepCost

            step2Cost = step1Cost;
            step1Cost = currentStepCost;
        }

        return Math.min(step1Cost, step2Cost);
    }
}
