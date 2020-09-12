package com.company.competitiveProgramming.incomplete;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//not working/
// use dynamic programming
public class MatrixChainMultiplicationProblem {
    //balloon numbers are provided in an array nums
    //burst all ballons
    //num[-1] & nums[n] = 1 and can't be burst
    // burst the balloon
    // it's between left & right
    // so burst balloon num i = num[left] num[i] num[right]
    //coins = num[left] x num[i] x num[right]


    //solution:
    //2 pointers
    //start and end
    //burst balloon at startPointer +1
    //when nums.length ==2, & we want to burst balloon at num[0] than the coin calculation is like 1 * num[0] * num[num.length-1]
    //when num.length == 1 than coin == 1 * num[0] * 1
    public int maxCoins(int[] nums) {
        //[3,1,5,8]
        if(nums == null || nums.length == 0) {
            return 0;
        }

        if(nums != null && nums.length == 1) {
            return nums[0];
        }

        Arrays.sort(nums);

        List<Integer> numsList = new ArrayList<>();
        for(int i : nums)
            numsList.add(i);

        int coins = 0;

        //[3,1,5,8]
        //3 1 5
        // pop value 1 from array
        //[3,5,8]
        // pop vlaue 5 from array
        // [3,8]


        //[1,5]
        while(numsList.size() > 2) {
            //3*1*5 = 15
            //3*5*8 = 120
            //
            coins += numsList.get(0) * numsList.get(1) * numsList.get(2);
            System.out.println("coin: "+ coins);
            numsList.remove(1);
        }

        coins += numsList.get(0) * numsList.get(1);
        numsList.remove(0);
        coins += numsList.get(0);
        System.out.println("coin: "+ coins);

        return coins;
    }
}
