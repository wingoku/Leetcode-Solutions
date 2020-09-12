package com.company.competitiveProgramming;

public class JumpGame {
    boolean reachedEnd = false;

    //linear
    //revise
    //leetcode accepted
    //amazon coding
    //based on https://www.youtube.com/watch?v=Zb4eRjuPHbM
    public boolean canJump(int[] nums) {

        if(nums.length <= 1)
            return true;

        int lastReachedIndex = nums.length - 1;
        for(int i=nums.length-1; i>=0; i--) {

            //if we can jump from currentPosition + jump value & reach the lastReachedIndex
            //than we set lastReachedIndex == currentIndex
            //this way we loop till the end of the array in backwards fashion & when we get out of the loop
            //and the lastReachedIndex != 0 that means we can't reach rightMost/nums.length-1 from the start of the array
            if(i + nums[i] >= lastReachedIndex) {
                lastReachedIndex = i;
            }
        }

        return lastReachedIndex == 0;
    }

    public boolean canJumpBackTracking(int[] nums) {

        if(nums.length <= 1)
            return true;

         canReachEnd(nums, 0);

        return reachedEnd;
    }

    //backtracking
    //working but super slow for larger inputs it times out
    private void canReachEnd(int[] nums, int currentIndex) {

        //if we've reached the last index or if we're beyond the last index of the array than we know that we can reach the end
        if(currentIndex >= nums.length -1) {
            reachedEnd = true;
            return;
        }

        //checking how far can we jump from currentIndex based on the jump value that's nums[currentIndex]
        //doing Math.min(currentIndex+num[currentIndex], nums.length-1) is because
        //imagine we're at position 3 i-e; currentIndex = 3 & nums[3] = 8 & arrayLength == 6
        //if we don't do Math.min it'll mean we will loop even after we've reached the end of the array. We don't want that cuz
        //we just want to reach the end of the array & if we've reached the end of array, there is no point in looping further
        int howFarCanWeJump = Math.min(currentIndex + nums[currentIndex], nums.length - 1);

        for(int position = currentIndex+1; position <= howFarCanWeJump; position++) {
            if(reachedEnd)
                return;

            canReachEnd(nums, position);
        }
    }
}
