package com.company.competitiveProgramming;

import java.util.HashMap;

public class SumInRange {
    public int sumInRange(int[] nums, int[][] queries) {
        int sum = 0;
        int mod = 1000000007;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            map.put(i, sum);
        }

        sum = 0;
        for(int i=0; i<queries.length; i++) {
            if(queries[i][0] == 0)
                sum = sum% mod + map.get(queries[i][1])% mod;
            else
                sum = sum%mod + map.get(queries[i][1]) - map.get(queries[i][0]-1) % mod;
        }
        if(sum < 0)
            sum = mod + (sum % mod);
        System.out.println("total: "+ sum);
        return sum;
    }

}
