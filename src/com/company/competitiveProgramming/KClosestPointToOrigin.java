package com.company.competitiveProgramming;

import java.util.PriorityQueue;

public class KClosestPointToOrigin {
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((point1, point2) -> {
            if(point1[0] < point2[0])
                return 1;
            return -1;
        });

        for(int[] point : points) {
            minHeap.add(point);

            if(minHeap.size() > K)
                minHeap.poll();
        }

        int i=0;
        int[][] kClosesPoints = new int[minHeap.size()][2];
        while(minHeap.size() > 0) {
            kClosesPoints[i] = minHeap.poll();
            i++;
        }

        return kClosesPoints;
    }
}
