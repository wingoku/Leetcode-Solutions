package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    /**
     The idea is to sort the given intervals array based on the first time of every interval so the sorted result looks like

     given:  [[2,6],[1,3],[15,18],[8,10]]
     sorted: [[1,3],[2,6],[8,10],[15,18]]

     than compare prevInterval[1] with currentInterval[0] and currentInterval[1], if prevInterval[1] is greater than either of currentInterval[0] and currentInterval[1] than put the result like this in the final list


     int[] merged = new int[2];
     merged[0] = prevInterval[0];
     merged[1] = Math.max(prevInterval[1], currentInterval[1]);

     mergedIntervalList.add(merged);

     */

    //TC: O(nlogn) //cuz of sorting
    //SC: O(n)
    public int[][] merge(int[][] intervals) {

        if(intervals == null || intervals.length <= 1)
            return intervals;

        Arrays.sort(intervals, (intr1, intr2) -> Integer.compare(intr1[0], intr2[0]));

        List<int[]> mergedIntervalList = new ArrayList<>();

        int[] prevInterval = intervals[0];

        mergedIntervalList.add(prevInterval);
        for(int i=1; i<intervals.length; i++) {

            int[] currentInterval = intervals[i];

            if(prevInterval[1] >= currentInterval[0] || prevInterval[1] > currentInterval[1]) {
                mergedIntervalList.remove(mergedIntervalList.size()-1);

                int[] merged = new int[2];
                merged[0] = prevInterval[0];
                merged[1] = Math.max(prevInterval[1], currentInterval[1]);

                mergedIntervalList.add(merged);

                prevInterval = merged;
            }
            else {
                mergedIntervalList.add(currentInterval);

                prevInterval = currentInterval;
            }
        }

        int[][] result = new int[mergedIntervalList.size()][2];

        int i=0;
        for(int[] mergedInterval : mergedIntervalList) {
            result[i][0] = mergedInterval[0];
            result[i][1] = mergedInterval[1];

            i++;
        }

        return result;
    }
}
