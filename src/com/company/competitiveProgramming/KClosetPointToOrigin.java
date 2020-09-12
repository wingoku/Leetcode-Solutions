package com.company.competitiveProgramming;

import java.util.PriorityQueue;

public class KClosetPointToOrigin {

    //leetcode accepted solution
    //amazon coding interview
    //used maxHeap to get rid of the bigger distance points by popping them from the heap
    public int[][] kClosest(int[][] points, int K) {

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((point1, point2) -> {
            //calculating Eucledian distance for point1 from origin & point2 from origin
            //than checking whose distance is bigger than the other

            //following is a technique to use comparator to convert minHeap to maxHeap
            return (point2[0] * point2[0] + point2[1] * point2[1]) - (point1[0] * point1[0] + point1[1] * point1[1]);
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
