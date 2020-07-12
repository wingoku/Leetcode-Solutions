package com.company.competitiveProgramming;

public class MissingNumber {

    public int findMissingNumber(int[] nums) {
        if(nums.length == 1)
            return nums[0] == 0 ? 1 : 0;

        int missing = nums.length;
        boolean tempNums[] = new boolean[nums.length+1]; //cuz one is missing

        /*for(int i:nums) {
            tempNums[i] = true;
        }

        for(int i=0; i<tempNums.length; i++)
            if(!tempNums[i]) {
                missing = i;
                break;
            }*/



        /*for(int i=0; i<nums.length; i++) {
            missing ^= nums[i];
        }

        System.out.println("missing is: "+ missing);
        if((missing & 1) == 1)
            missing -=1;*/
        /*else
            missing +=1;*/
        /*if(missing == -1)
            missing = i;*/

        int sum = 0;
        for(int i=0; i<nums.length; i++) {
            missing += nums[i];
            sum+=i;
        }


        System.out.println("nums.length is: "+ nums.length);
        System.out.println("missing is: "+ (missing-sum));
        return missing;
    }
}
