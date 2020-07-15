package com.company.competitiveProgramming;

import java.util.HashSet;

public class BestTimeToBuyAndSellStocks2 {

    //accepted leetcode solutoin
    // AMAZON CODING INTERVIEW
    //the essense of this question is to check
    // if number at current index < number at index+1
    // if yes, calculate difference & save it in a variable
    // than you buy stock on the next day which is still currentIndex + 1
    // so you calculate the difference
    // NOTE THAT THE QUESTION DIDN'T SAY THAT WE CAN'T BUY & SELL THE STOCKS ON THE SAME DAY
    // THE ONLY REQUIREMENT IS WE BUY FIRST AND THAN SELL
    // THEREFORE FOR A PRICE ARRAY LIKE THIS
    //[7, 1, 5, 3, 6, 4]
    // WE BUY ON DAY 2 AT PRICE 1 AND SELL ON DAY 3 WITH PRICE 5
    // THAN ON DAY 3 IF WE BUY THE STOCK AT 5, WE CAN'T SELL IT AT A PROFIT ON DAY 4 CUZ PRICE 5 > PRICE 3
    // THAN WE BUY ON DAY 4 WITH PRICE 3 & SELL ON DAY 5 WITH PRICE 6
    public int maxProfile(int[] prices) {
        int profit = 0;
        for(int i=0; i<prices.length-1; i++) {
            if(prices[i+1] > prices[i])
                profit += (prices[i+1] - prices[i]);
        }
        return profit;
    }
    /**
     *  while(startPointer < prices.length-1) {
     *             if(prices[startPointer] > prices[startPointer+1]) {
     *                 startPointer++;
     *                 if(!visitedPrices.contains(startPointer)) {
     *                     visitedPrices.add(startPointer);
     *                     endPointer = startPointer + 1;
     *                 }
     *             }
     *             if(endPointer < prices.length-1 && prices[endPointer] < prices[endPointer+1] && !visitedPrices.contains(endPointer+1) && prices[startPointer] < prices[endPointer]) {
     *                 sum += (prices[endPointer] - prices[startPointer]);
     *
     *                 visitedPrices.add(endPointer);
     *             }
     *             endPointer++;
     *         }
     */
}
