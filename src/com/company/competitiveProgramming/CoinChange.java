package com.company.competitiveProgramming;

import java.util.Arrays;

public class CoinChange {
    //accepted
    //revise
    //leetcode 1 ms
    //amazon coding interview
    //based off of the following 2 videos
    //https://www.youtube.com/watch?v=Y0ZqKpToTic
    //https://www.youtube.com/watch?v=jaNZ83Q3QGc
    //https://www.youtube.com/watch?v=jaNZ83Q3QGc
    public int coinChange(int[] coins, int givenAmount) {

        int[] dp = new int[givenAmount+1]; //because we're going to calculate number of coins needed for each amount from 0 till amount
        //since we're including 0 therefore we're making an array of size amount+1

        Arrays.fill(dp, givenAmount+1); //filling the array with something invalid
        //givenAmount+1 will be invalid cuz it won't take givenAmount+1 coins to make givenAmount
        //Eg. if givenAmount = 12, we fill the array with 13, it doesn't make sense that it'll take 13 different coins to make a coin of value 12 even if the coins given to us in coins[] is 1, it'll take 12 one coins to make a coin/amount == 12

        dp[0] = 0; //it takes adding 0 coins to get a coin of value 0

        for(int amount=0; amount < dp.length; amount++) {
            for(int j=0; j<coins.length; j++) {

                //checking if it's possible to find how many coins it takes to create current amount - "amount" using the coins we're given
                //therefore we need to check if the amount <= coin at index j, if coin[j] is greater than amount, we can't find
                //how many coins it'll take to calculate the amount using the coin[j]
                //eg. amount from the outer loop is 1 but coin[j] is point to coin 2, it's not possible
                //to calculate coin of value 1 with coin of value 2 unless we're subtracting & we're not doing that here
                //we're checking using the coins array, how many coins from coins[] can be used to make the "amount" from outer loop
                //once we're calculated amounts upto givenAmount -1, we'll be able to find how many coins from coins[] it takes to calculate givenAmount
                if(coins[j] <= amount) {
                    dp[amount] = Math.min(dp[amount], 1 + dp[amount - coins[j]]); //checking if previously calculated dp[amount] which contains the number of coins it takes from coins[] to calculate amount is less than 1+dp[amount - coins[j]]
                    /**
                     1+dp[amount - coins[j]]
                     For example, we want to calculate how many coins from coins[] it takes to calculate amount 1,
                     the given coins[] = [1,2,5].
                     when we're in the second loop, we start from coin 1
                     it takes dp[1-1] -> dp[0] = 0 so it takes 0 coins to make coin value 1 which is not correct cuz we need 1 coin of value 1 to make a coin of value 1. therefore we add +1 to it so it becomes
                     1+dp[1-1] -> 1+ dp[0] = 1+0 = 1 which is correct

                     Now lets find out how many coins it takes to make a coin of value 2
                     amount = 2 from outer loop

                     inner loop starts from coin 1 & goes till 5

                     if(1 <= 2) {
                     //dp[2] will originally contain Integer.MAX cuz we filled it with it.
                     dp[2] = Math.min(Integer.Max_Integer, 1 + dp[2-1]) -> 1 + dp[1] -> 1 + 1 = 2
                     dp[2] = 2
                     }

                     than next iteration of inner loop

                     if(2 <= 2) {
                     dp[2] = Math.min(dp[2], 1+dp[2-2]) -> 1+dp[0] -> 1+0 = 1
                     //2 came out to the number of coins needed to make amount 2 if the coin value is 1
                     dp[2] = Math.min(2, 1)
                     dp[2] = 1;
                     }
                     */
                }
            }
        }
        return (dp[givenAmount] == givenAmount+1) ? -1 : dp[givenAmount];
    }
}
