package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    /**
     A = [[0,2],[5,10],[13,23],[24,25]],
     B = [[1,5],[8,12],[15,24],[25,26]]

     Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]
     */
    //https://www.youtube.com/watch?v=Qh8ZjL1RpLI
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        //0 2 5 10 13 23 24 25
        //1 5 8 12 15 24 25 26
        if(A.length == 0 || B.length == 0)
            return new int[][]{};


        int aIndex = 0;
        int bIndex = 0;

        List<int[]> result = new ArrayList<>();

        // A = [[0,2],[5,10],[13,23],[24,25]],
        // B = [[1,5],[8,12],[15,24],[25,26]]
        while(aIndex < A.length && bIndex < B.length) {


            int intersectionStart = Math.max(A[aIndex][0], B[bIndex][0]);
            int intersectionEnd = Math.min(A[aIndex][1], B[bIndex][1]);

            if(intersectionStart <= intersectionEnd)
                result.add(new int[]{intersectionStart, intersectionEnd});

            if(A[aIndex][1] < B[bIndex][1]) {
                aIndex++;
            }
            else
                bIndex++;
        }

        return result.toArray(new int[result.size()][2]);
    }
}
