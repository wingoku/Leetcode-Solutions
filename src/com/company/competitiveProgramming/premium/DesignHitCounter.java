package com.company.competitiveProgramming.premium;

class HitCounter {

    /*

        (1,1), (2,2), (3,3), get(at 4)

        1. find the number of seconds from current time - 5 mins*seconds
        2. based on entries in that range we can get the hit count value

        when hits come in, we can loop from start of the array till the currentTime-5mins*sec
        than loop till given timestamp in seconds and calculate how many items are in between these 2 windows

        hit 1
        hit 1
        hit 1
        hit 300

        getHits at 300 == 4

        hit 300

        getHits at 300  == 5

        hit  301

        getHits at 301 == 3

    */

    /*
        IDEA:


            we need to find the number of hits we got in the past 5 mins i-e; 300 seconds
            in order to find the number of hits in the last 300 seconds
            we need to find the first timestamp whos difference i-e; currentTimeStamp - q.peek().timestamp < 300
            if it's greater than 300 than we need to remove that timestamp
    */


    //TC: O(N) for getting getHits() in worst case. O(1) for inserting
    //SC: O(N)
    private Queue<Integer> q;
    /** Initialize your data structure here. */
    public HitCounter() {
        q = new LinkedList<>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty()) {

            //we need to find the number of hits we got in the past 5 mins i-e; 300 seconds
            //in order to find the number of hits in the last 300 seconds
            //we need to find the first timestamp whos difference i-e; currentTimeStamp - q.peek().timestamp < 300
            // if it's greater than 300 than we need to remove that timestamp
            if(timestamp - q.peek() < 300)
                break;
            else
                q.poll(); //the timestamp/hit lies before the 5 min window
        }

        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */