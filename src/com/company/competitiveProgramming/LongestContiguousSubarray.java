package com.company.competitiveProgramming;

import javax.sound.midi.SysexMessage;

public class LongestContiguousSubarray {

    //two pointers
    //begining
    //startPointer at zero
    //endPointer at 1
    //keep moving endPointer and add values to the sum
    //if calculatedSum > target,
    //move startPointer to right & subtract the value from the calculated sum
    //if zeros are found, add them to the sum & keep incrementing  the right pointer
    //once sum is found, record the startAndEnd pointer indicies

    //then continue by moving the right pointer to see if any other larger arrays sum match target
    // if we find another array, we check the new array size with the old one and which ever is bigger,
    // we keep those startAndEnd indices

    //if nothing found, return -1
    public int[] findLongestContiguousSubArrayForTargetSum(int[] arr, int s) {
        int L = 0, R = 0, sum = 0;
        int bestLen = 0, bestL = -1, bestR = -1;
        while (true) {
            if (sum == s && R-L > bestLen) {
                bestR = R; bestL = L; bestLen = R-L;
            }
            if (sum > s) sum -= arr[L++];
            else {
                if (R == arr.length) break;
                sum += arr[R++];
            }
        }

        System.out.println("target: " + s + " lies between: " + (bestL+1) + " & " + (bestR));
        return bestLen == 0 ? new int[]{-1} : new int[]{bestL+1,bestR};
    }

    /*public int[] findLongestContiguousSubarrayForTargetSum(int[] nums, int target) {

        if(nums.length == 0)
            return new int[]{-1};

        int[] indices = new int[]{-1};

        int startPointer = 0;
        int endPointer = 1;
        int currentSum = nums[0];

        while(startPointer < nums.length) {
            if(currentSum > target || endPointer == nums.length) {
                currentSum -= nums[startPointer];
                startPointer++;
            }

            if(currentSum == target) {
                if(endPointer < nums.length && startPointer == endPointer && nums[startPointer] != target && nums[endPointer] != target) {

                }
                else {
                    if(indices.length == 1 || endPointer - startPointer > indices[1] - indices[0])
                        indices = new int[] {startPointer+1, endPointer};
                }
            }

            if(currentSum <= target && endPointer < nums.length){
                currentSum += nums[endPointer];
                endPointer++;
            }
        }

        System.out.println("target: " + target + " lies between: " + (indices[0]) + " & " + (indices[1]));
        return new int[]{-1};
    }*/

}
