package com.company.competitiveProgramming;

import java.util.Arrays;
import java.util.List;

public class MinimumTimeDifference {

    /*
   Question says
    FIND MINIMUM DIFFERENCE BETWEEN ***ANY*** TWO TIME POINTS IN THE LIST. IT DOESN'T SAY MIN DIFFERENCE BETWEEN CONSECUTIVE i-e; ADJECENT TIMES IN THE LIST

    SOLUTION:
    0. we create a boolean array of 1440 indexes cuz in 24 hours we've 1440 minutes
    1. We calculate convert the given time stamps into minutes
    2. we set the bool array at index = the time we calculated in step 2 = true
        a. After this loop ends, we'll have the time stamps already in a sorted manner. This will make finding min diff alot easier
    3. We've time stamps sorted in the boolean array. The reason is we're asked to find time difference between any two time points in the list
        a. so we're given 6 times in the array, it could be difference between times at index 0 & 4, 1 & 6, 0 & 1 or 6 & 1
    4. we take difference between the time points based on the indexes of the boolean array where it's value is true
    5. After the loop ends
        a. We also calculate the difference between the very last entry in the sorted time array & the very first entry
        b. the reason we do that is to simulate the situation:
        c.  if the given times were 00:00, 23:59, the min difference inside the loop would be 1439
        d. however the difference between 23:59 - 00:00 would be 1
        e. therefore in order to check if the difference between the last entry in the sorted time array & first entry is LESS
           than the min difference we've calculate so far, we calculate difference outside the loop on last time too.
   */

    //tc: O(n)

    /**
     *
     * TC: O(n)
     * SC: O(1440) or O(1) cuz the space complexity of our solution remains constant regardless how big the timePoints list is
     */
    public int findMinDifferenceIn_LINEAR_TIME(List<String> timePoints) {
        if(timePoints == null)
            return 0;

        boolean[] buckets = new boolean[24*60];//cuz there are 1440 minutes in 24 hours and we're given time stamps in 24 hours too, so we create 1440 buckets for true false
        //true for the times given in the timePoints list
        //false otherwise

        for(int i=0; i<timePoints.size(); i++) {
            String time = timePoints.get(i);
            String[] splitTime = time.split(":");

            int hours = Integer.valueOf(splitTime[0]);
            int mins = Integer.valueOf(splitTime[1]);

            int hoursInMins = hours * 60;
            int totalMinutes = hoursInMins + mins;

            //if we have duplicate times than the difference between them will obviously be 0
            //and since the bucket[totalMinutes] is already true, it means we already came across this time stamp in previous iteration at some point
            if(buckets[totalMinutes] == true)
                return 0;

            buckets[totalMinutes] = true;
        }

        int minTimeDiff = Integer.MAX_VALUE;

        int prevTime = -1;
        int currTime = -1;
        int firstTimeOfTheDayGivenInTimePointsList = -1;
        for(int i=0; i<buckets.length; i++) {

            if(buckets[i] == false)
                continue;

            if(firstTimeOfTheDayGivenInTimePointsList == -1) {
                firstTimeOfTheDayGivenInTimePointsList = i;
                prevTime = i;
                currTime = i;
            }
            else {
                currTime = i;
                minTimeDiff = Math.min(minTimeDiff, currTime - prevTime);

                prevTime = i;
            }
        }

        int lastTimePointGivenInTimePointsList = currTime;

        // After the loop ends
        // a. We also calculate the difference between the very last entry in the sorted time array & the very first entry
        // b. the reason we do that is to simulate the situation:
        // c.  if the given times were 00:00, 23:59, the min difference inside the loop would be 1439
        // d. however the difference between 23:59 - 00:00 would be 1
        // e. therefore in order to check if the difference between the last entry in the sorted time array & first entry is LESS
        //    than the min difference we've calculate so far, we calculate difference outside the loop on last time too.
        //so we add 24 hours in minutes to the very first time stamp in the minutes array & subtract it from the very last item in the minutes array
        //24*60
        minTimeDiff = Math.min(minTimeDiff, 1440 + firstTimeOfTheDayGivenInTimePointsList - lastTimePointGivenInTimePointsList);

        return minTimeDiff;
    }

    /*
   Question says
    FIND MINIMUM DIFFERENCE BETWEEN ***ANY*** TWO TIME POINTS IN THE LIST. IT DOESN'T SAY MIN DIFFERENCE BETWEEN CONSECUTIVE i-e; ADJECENT TIMES IN THE LIST

    SOLUTION:
    1. We calculate convert the given time stamps into minutes
    2. Save them in array
    3. SORT THEM! we sort cuz we're asked to find time difference between any two time points in the list
        a. so we're given 6 times in the array, it could be difference between times at index 0 & 4, 1 & 6, 0 & 1 or 6 & 1
    4. we take difference between the time points from the sorted array
    5. After the loop ends
        a. We also calculate the difference between the very last entry in the sorted time array & the very first entry
        b. the reason we do that is to simulate the situation:
        c.  if the given times were 00:00, 23:59, the min difference inside the loop would be 1439
        d. however the difference between 23:59 - 00:00 would be 1
        e. therefore in order to check if the difference between the last entry in the sorted time array & first entry is LESS
           than the min difference we've calculate so far, we calculate difference outside the loop on last time too.
   */

    //tc: O(n log n) cuz of the Arrays.sort

    /**
     * WITH TC: O(N LOG N)
     * SC: O(N)
     * ABOVE SOLUTION IS BETTER
     */
    public int findMinDifference(List<String> timePoints) {
        if(timePoints == null)
            return 0;

        int[] minutes = new int[timePoints.size()];

        for(int i=0; i<timePoints.size(); i++) {
            String time = timePoints.get(i);
            String[] splitTime = time.split(":");

            int hours = Integer.valueOf(splitTime[0]);
            int mins = Integer.valueOf(splitTime[1]);

            int hoursInMins = hours * 60;

            minutes[i] = hoursInMins + mins;
        }

        //we sort the array cuz we're told to find minimum time difference between ANY TWO TIME POINTS IN THE LIST
        //we're **NOT** asked to calculate minimum time difference between CONSECUTIVE TIME POINTS IN THE LIST
        Arrays.sort(minutes);

        int minTimeDiff = Integer.MAX_VALUE;

        for(int i=0; i<minutes.length-1; i++) {
            minTimeDiff = Math.min(minTimeDiff, minutes[i+1] - minutes[i]);
        }

        // After the loop ends
        // a. We also calculate the difference between the very last entry in the sorted time array & the very first entry
        // b. the reason we do that is to simulate the situation:
        // c.  if the given times were 00:00, 23:59, the min difference inside the loop would be 1439
        // d. however the difference between 23:59 - 00:00 would be 1
        // e. therefore in order to check if the difference between the last entry in the sorted time array & first entry is LESS
        //    than the min difference we've calculate so far, we calculate difference outside the loop on last time too.
        //so we add 24 hours in minutes to the very first time stamp in the minutes array & subtract it from the very last item in the minutes array
        minTimeDiff = Math.min(minTimeDiff, 1440+minutes[0] - minutes[minutes.length-1]);

        return minTimeDiff;
    }
}
