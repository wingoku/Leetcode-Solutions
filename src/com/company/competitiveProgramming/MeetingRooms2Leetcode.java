package com.company.competitiveProgramming;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingRooms2Leetcode {
    //TC: O(N logN)
    public int minMeetingRooms(int[][] intervals) {


        int[] startTimes = new int[intervals.length];
        int[] endTimes = new int[intervals.length];

        for(int i=0; i< intervals.length; i++) {
            startTimes[i] = intervals[i][0];
            endTimes[i] = intervals[i][1];
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int roomsNeeded = 0;

        int i=0, j = 0;

        while(i < intervals.length && j < intervals.length) {
            if(startTimes[i] < endTimes[j]) {
                roomsNeeded++;
            }
            else {
                j++;
            }

            i++;//keep incrementing startTimes cuz if startTime < endTime than we'd increment roomsNeeded, if it's not than currentStart time is of no
            //conflict, so move on to the next startTime until we find the conflict in order to increment roomsNeeded count
        }

        return roomsNeeded;
    }
    //TC: O(N logN)
    public int minMeetingRooms_With_PQ(int[][] intervals) {

        PriorityQueue<Integer> minHeapStartTime = new PriorityQueue<>();
        PriorityQueue<Integer> minHeapEndTime = new PriorityQueue<>();

        for(int i=0; i<intervals.length; i++) {
            minHeapStartTime.add(intervals[i][0]);
            minHeapEndTime.add(intervals[i][1]);
        }

        int roomsNeeded = 0;
        while(!minHeapStartTime.isEmpty() && !minHeapEndTime.isEmpty()) {
            if(minHeapStartTime.poll() < minHeapEndTime.peek()) {
                roomsNeeded++;
            }
            else
                minHeapEndTime.poll();
        }

        return roomsNeeded;

    }
}
