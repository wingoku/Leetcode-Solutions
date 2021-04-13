package com.company.competitiveProgramming;

class Solution {
    public int twoSumLessThanK(int[] nums, int k) {
        int left = 0;
        int right = nums.length-1;

        Arrays.sort(nums);

        int max = -1;

        while(left < right) {
            int sum = nums[left] + nums[right];

            if(sum < k)
                max = Math.max(max, sum);

            if(sum >= k)
                right--;
            else
                left++;
        }

        return max;
    }
}