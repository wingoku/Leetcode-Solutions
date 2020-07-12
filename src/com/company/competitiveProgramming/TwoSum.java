package com.company.competitiveProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] find2NumsThatEqualGivenSum(int[] nums, int target) {
        int[] indices = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>(nums.length);

        //[2, 7, 11, 13] == 9
        //[11, 7, -1, 13, 5, 3] == 4

//        Arrays.sort(nums);
        /*for(int i : nums) {
            System.out.print(i+", ");
        }*/
        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                indices[0] = i;
                indices[1] = map.get(target - nums[i]);
                System.out.println("found indices: "+ i + " "+ map.get(target - nums[i]));
                break;
            }
            map.put(nums[i], i);
        }
        /*int startPointer = 0;
        int endPointer = 1;

        while(startPointer < nums.length-1) {
            if(endPointer == nums.length) {
                endPointer = startPointer + 1;
                startPointer++;
            }
            else
                if(nums[startPointer] + nums[endPointer] == target) {
                    indices[0] = startPointer;
                    indices[1] = endPointer;
                    System.out.println("found indices: "+ startPointer + " "+ endPointer);
                    break;
                }

            endPointer++;
        }*/

        return indices;
    }


    //acccepted solution but the time complexity is ~ O(n^2) cuz in worst case startPointer starts from 0 & goes till nums.length & upon every increment of startPointer, endPointer starts from startPointer position kinda like nested for loop
    /*public int[] find2NumsThatEqualGivenSum(int[] nums, int target) {
        int[] indices = new int[2];

        //[2, 7, 11, 13] == 9
        //[11, 7, -1, 13, 5, 3] == 4

        int startPointer = 0;
        int endPointer = 1;

        while(startPointer < nums.length-1) {
            if(endPointer == nums.length) {
                endPointer = startPointer + 1;
                startPointer++;
            }
            else
            if(nums[startPointer] + nums[endPointer] == target) {
                indices[0] = startPointer;
                indices[1] = endPointer;
                System.out.println("found indices: "+ startPointer + " "+ endPointer);
                break;
            }

            endPointer++;
        }

        return indices;
    }*/
}
