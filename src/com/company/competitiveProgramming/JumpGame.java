package com.company.competitiveProgramming;

public class JumpGame {
    boolean reachedEnd = false;

    //linear
    //revise
    //leetcode accepted
    //amazon coding
    //based on https://www.youtube.com/watch?v=Zb4eRjuPHbM
    /**
     .The idea is to go from right to left
     The reason is, to solve this problem at a step that doesn't allow us to jump forward, we need to know
     if there were previous steps with higher jump values that we can use to jump over the step next to the current step
     Therefore it's a DP problem.

     In DP solution we'd have maintain states based on the steps we take.

     The solution below is greedy & the way we solve this problem is by going from right to left

     We take the last index of the array and say it's our lastGoodIndex cuz if you've jumped on this index, you're already good

     Than we iterate from right to left & check if value at current index i i-e; nums[i] when summed with index of the array i
     is bigger than or to the last good index.
     If yes, we make the current index i as our last good index
     and keep doing this step until the loop ends

     if by the end of the loop, our lastGoodIndex != 0 that means we can't reach the end by jumping

     */public boolean canJump(int[] nums) {
        int lastGoodIndex = nums.length-1;

        for(int i = nums.length-2; i>=0; i--) {
            if(nums[i] + i >= lastGoodIndex)
                lastGoodIndex = i;
        }

        return lastGoodIndex == 0;
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
