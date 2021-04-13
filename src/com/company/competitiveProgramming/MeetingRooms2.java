package com.company.competitiveProgramming;

import java.util.*;

public class MeetingRooms2 {
    /**
     * Think of this problem as:
     *  Find MAX number of meetings happening simultaneously
     *  All we care about is if when N meetings start, by the time we reach the end of a meeting that ends last/later than every other meeting during the day, how many MAX rooms were occupied at a certain time during the day
     *
     *  So what we can do is we can sort (ascending) the array based on start time & sort (ascending order) array based on end time
     *  Iterate over the array sorted based on startTime, match the first element in startTime array with the first element in the endTime array
     *  if element from startTimeArray < element from endTimeArray, INCREMENT room count & increment index of startTimeArray
     *  Update the maxRoom variable
     *  if element from startTimeArray > element from endTimeArray, decrement room count & increment index of endTimeArray
     */

    /***
     * LOOK AT THE FOLLOWING EXAMPLE TAKEN FROM GEEKS FOR GEEKS. SAME PRINCIPLE APPLIES TO MEETINGS PROBLEM: https://www.geeksforgeeks.org/minimum-number-platforms-required-railwaybus-station/
     * VIDEO EXAMPLE: https://www.youtube.com/watch?v=118Ie3nPCdc
     * BETTER EXPLANATION: https://www.youtube.com/watch?v=KIKjKlbJUwU
     *
     * arr[]  = {9:00,  9:40, 9:50,  11:00, 15:00, 18:00}
     * dep[]  = {9:10, 12:00, 11:20, 11:30, 19:00, 20:00}
     *
     * All events are sorted by time.
     * Total platforms at any time can be obtained by
     * subtracting total departures from total arrivals
     * by that time.
     *
     *  Time      Event Type     Total Platforms Needed
     *                                at this Time
     *  9:00       Arrival                  1
     *  9:10       Departure                0
     *  9:40       Arrival                  1
     *  9:50       Arrival                  2
     *  11:00      Arrival                  3
     *  11:20      Departure                2
     *  11:30      Departure                1
     *  12:00      Departure                0
     *  15:00      Arrival                  1
     *  18:00      Arrival                  2
     *  19:00      Departure                1
     *  20:00      Departure                0
     *
     * Minimum Platforms needed on railway station
     * = Maximum platforms needed at any time
     * = 3
     *
     */
    public class Interval {
          int start, end;
          Interval(int start, int end) {
              this.start = start;
              this.end = end;
          }
      }

    public void createDataSet() {
//          int[][] intervalsArray = new int[][] {{567707,730827},{166232,719216},{634677,756013},{285191,729059},{237939,915914},{201296,789707},{578258,585240},{164298,218749},{37396,968315},{666722,934674},{742749,824917},{141115,417022},{613457,708897},{343495,994363},{380250,428265},{214441,493643},{588487,811879},{97538,262361},{312269,400232},{119183,598077},{48359,662082},{275411,998607},{732520,813383},{523587,945442},{25499,187818},{384094,677532},{515481,904358},{367073,534689},{74379,285755},{5175,274185},{217306,359251},{157681,697795},{10408,50527},{244728,788413},{60159,513570},{87670,618955},{123002,685804},{379941,544148},{752885,952000},{93326,513158},{724941,998846},{380834,713191},{44977,758923},{82478,863827},{191702,202103},{132379,894865},{33622,873933},{29205,85762},{154893,736522},{65801,673648},{524615,925054},{54903,503215},{184486,923679},{429446,722503},{433374,648218},{221866,866873},{460293,767671},{120556,899800},{471650,884153},{260903,444940},{764956,900171},{309912,608549},{185563,806731},{120163,485407},{418426,787505},{366182,765471},{387482,509524},{269290,965760},{601620,925056},{77986,263210},{307558,385490},{232270,339488},{500796,742417},{380705,468257},{65075,908144},{199833,764292},{236020,666098},{66185,189939},{82749,497671},{191217,375842},{197768,679395},{193098,715861},{441216,949168},{70640,164591},{47205,785067},{488750,598205},{13213,617815},{323318,918171},{414290,772744},{252493,666573},{271755,888520},{127330,511709},{221211,255366},{189693,496201},{59348,213072},{848245,886578},{297360,706720},{416648,713923},{597845,948100},{598216,887392},{291671,885441},{470685,911757},{753936,779842},{402359,607590},{405439,709142},{214403,993931},{410523,809693},{394872,807901},{104075,813021},{726,567120},{118216,440587},{451018,831426},{134313,437745},{580445,723821},{812199,974362},{206646,330279},{76614,396575},{490128,495052},{159918,891113},{317757,944351},{367136,561514},{47693,397141},{624885,944320},{22262,713662},{14887,710022},{887543,997929},{211476,296206},{560776,619572},{49048,602570},{169071,575311},{645076,686241},{577490,777716},{431009,702971},{197437,728985},{62590,339659},{474951,503156},{637923,899120},{973131,976272},{450579,954240},{318272,635074},{68073,677042},{127777,185375},{426756,912534},{370844,592811},{724,630896},{732456,896268},{592795,641974},{321324,337142},{505427,594421},{74917,273591}};
        int[][] intervalsArray = new int[][] {{0,11}, {5,10}, {15,20}, {17, 20}, {19, 20}};

        //sortedByStartTime: (0, 2), (1, 3), (2, 4), (3,5)
        //sortedByEndTime: (0, 2), (1, 3), (2, 4), (3,5)

        //sortedByStartTime: {0,11}, {5,10}, {15,20}, {17, 20}, {19, 20}
        //sortedByEndTime:  {5,10}, {0,11}, {15,20}, {17, 20}, {19, 20}
        minMeetingWithPriorityQueue(intervalsArray);
    }

    public int minMeetingWithPriorityQueue(int[][] intervals) {
        if(intervals == null || intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (meeting1, meeting2) -> (meeting1[0] - meeting2[0]));

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((meeting1, meeting2) -> (meeting1[1] - meeting2[1]));

        minHeap.add(intervals[0]);

        for(int i=1; i<intervals.length; i++) {

            //we check if any meeting that's on index i has startTime >= any other meeting that's sitting at the top of minHeap,
            //that means these 2 meetings don't overlap so we need only 1 room for these 2 meetings,
            //so we remove the meeting added in minHeap previously & than add the meeting in minHeap from array that's meetings sorted based on startTime
            //once we exhaust the array containing meetings sorted based on the startTIme,
            //minHeap will have the meetings that are happening simulatenously
            if(!minHeap.isEmpty() && intervals[i][0] >= minHeap.peek()[1])
                minHeap.poll();

            //WE ADD CURRENT MEETING FROM INTERVALS[] WHICH IS THE ARRAY CONTAINING MEETINGS SORTED IN ASCENDING ORDER BASED ON THEIR START TIME
            //BECAUSE WE WANT TO KEEP TRACK OF ALL THE MEETINGS SORTED BASED ON THEIR END TIME TOO
            //CUZ THAT'S HOW WE'RE FIGURING OUT HOW MANY MEETINGS ARE HAPPENING SIMULATEOUSLY
            //IF WE HAD AN ELSE BEFORE MINHEAP.ADD() THAT'D MEAN, WE'D LOSE THE CURRENT MEETING FROM THE STARTTIME ARRAY IF IT WAS USED TO ACCESS IF THE MEETINGS HAVE CONFLICT OR NOT
            minHeap.add(intervals[i]);
        }

        System.out.println("max rooms required: "+ minHeap.size());

        return minHeap.size();
      }

    public int minMeetingRoomsWithoutPriorityQueue(int[][] intervals) {
        // Write your code here

        if(intervals == null || intervals.length == 0)
            return 0;

        int[][] sortedByEndTime = deepCopy(intervals);

        System.out.println("totalMeetings: "+ intervals.length);

        Arrays.sort(intervals, (meeting1, meeting2) -> meeting1[0]-meeting2[0]);
        Arrays.sort(sortedByEndTime, (meeting1, meeting2) -> meeting1[1]-meeting2[1]);

        int maxRooms = 0;
        int rooms = 0;

        int i=0, j=0;
        while(i<intervals.length && j < sortedByEndTime.length) {
            if(intervals[i][0] < sortedByEndTime[j][1]) {
                rooms++;
                i++;
            }
            else if(intervals[i][0] >= sortedByEndTime[j][1]) {
                rooms--;
                j++;
            }
            maxRooms = Math.max(maxRooms, rooms);
        }

        System.out.println("max rooms required: "+ maxRooms);

        return maxRooms;
    }

    public static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }

        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = Arrays.copyOf(original[i], original[i].length);
            // For Java versions prior to Java 6 use the next:
            // System.arraycopy(original[i], 0, result[i], 0, original[i].length);
        }
        return result;
    }
}
