package com.company.competitiveProgramming;

import java.util.HashMap;

public class ThirdMaxInArray {

    //my solution. accepted but it's only faster than 52.47% submissions
    public int findThirdMax(int[] nums) {
        Integer firstMax = null;
        Integer secondMax = null;
        Integer thirdMax = null;

        for(int n : nums) {
            if(firstMax != null && firstMax == n || secondMax != null && secondMax == n || thirdMax != null && thirdMax == n)
                continue;

            if(firstMax == null || firstMax < n) {
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = n;
            }
            else
                if(secondMax == null || secondMax < n) {
                    thirdMax = secondMax;
                    secondMax = n;
                }
                else
                    if(thirdMax == null || thirdMax < n) {
                        thirdMax = n;
                    }
        }
        int result = 0;

        if(thirdMax == null)
            result = firstMax;
        else
            result = thirdMax;

        System.out.println("result: "+ result);
        return result;
    }
    /*public int findThirdMax(int[] nums) {
        int firstMax, secondMax, thirdMax;
        firstMax = secondMax = thirdMax = Integer.MIN_VALUE;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            //avoiding to deal with duplicate values
            if(map.containsKey(nums[i]))
                continue;

            map.put(nums[i], i);
            if(firstMax == Integer.MIN_VALUE || firstMax < nums[i]) {
                //we need to trickle down any previous maxes to second & third stage before we update the firstMax
                thirdMax = secondMax;
                secondMax = firstMax;
                firstMax = nums[i];
            }
            else
            if(secondMax == Integer.MIN_VALUE || secondMax < nums[i]) {
                //we need to trickle down any previous maxes to third stage before we update the secondMax
                thirdMax = secondMax;
                secondMax = nums[i];
            }
            else
            if(thirdMax == Integer.MIN_VALUE || thirdMax < nums[i]) {
                thirdMax = nums[i];
            }
        }

        System.out.println("first: "+ firstMax + " second: "+ secondMax + " third: "+ thirdMax);

        int result = 0;
        //because if we just have an array full of just same number eg [1,1,1,1,1], in this case, map.size == 1 so we need to just send max value according to leetcode
        if(map.size() <= 2) {
            result = firstMax;
        }
        else
            result = thirdMax;
        System.out.println("result: "+ result);
        return result;
    }*/
}
