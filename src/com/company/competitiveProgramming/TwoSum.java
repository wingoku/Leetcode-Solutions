package com.company.competitiveProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    //twosum with the same logic however the problem wants us to return the indices in ascending order therefore used Math.min & Math.max to get the indices in proper order
    public int[] twoSum(int[] numbers, int target) {

        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<numbers.length; i++)
            map.put(numbers[i], i);

        for(int i=0; i<numbers.length; i++) {
            int diff = target - numbers[i];
            if(map.containsKey(diff)) {
                result[0] = Math.min(i, map.get(diff)) + 1;
                result[1] = Math.max(i, map.get(diff)) + 1;
                break;
            }
        }

        return result;
    }

    public int[] find2NumsThatEqualGivenSum(int[] nums, int target) {
        int[] indices = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);


        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                indices[0] = i;
                indices[1] = map.get(target - nums[i]);
                System.out.println("found indices: "+ i + " "+ map.get(target - nums[i]));
                break;
            }
            map.put(nums[i], i);
        }

        return indices;
    }

}
