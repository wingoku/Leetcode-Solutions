package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskSchedular {
    /**
     The question is saying if we've two similar tasks one after the other than we've to add a cool down period of N
     otherwise we don't need to add a cool time period to over all number of tasks

     The question is greedy in nature cuz we've to schedule the task that's occuring more than other tasks in such a way that we want to reduce
     the cpu cycles by combining the most occuring task by other tasks in order to reduce the cool down time.

     SOLUTION:
     The idea is to pop a task from the maxHeap and than run a loop N times where N is the cool down time and poll the other tasks in the maxHeap
     maxHeap will not give us the same task again cuz once we poll the task out of it, we don't add it back until we've run the inner loop N times

     Than inside the N loop, we take out the tasks and check if the heap is empty or not, if it is than we get out of the loop
     and add the tasks back in the queue if the count of those tasks in the map is NOT zero.

     afterwards we check again if the maxHeap is empty or not, if it's not than we add (n-i) to the total cycles. The reason we do that is
     cuz if we have given tasks in question like A A A B B B that means once we poll A and B, our heap will be empty until we add A and B back in the heap
     based on the fact that their count in the count map is still greater than ZERO.

     So if pop A before N loop and than pop B in the loop & cool down time is N=2, than the N loop will run only once. That means we still have one cool
     down slot left. We get that by doing n-i i-e; 2-1 which gives us 1.

     We also do cycles++ everytime we pop a task cuz we're told that each tasks regardless it's duplicate or not, will always take 1 unit of time.

     Overall TC would be N log N. You may ask why isn't it N^2 log N. It's cuz the outer loop will only run N times if our heap is not empty
     And if our heap is empty after the inner loop N, we've to add some tasks back into the maxHeap. Since we're just adding the tasks based on their count
     the loop over the popped list will run N times to add the items again & than the maxHeap will run N times again.


     */
    public int leastInterval(char[] tasks, int n) {
        int cycles = 0;

        if(n == 0)
            n = 1;

        HashMap<Character, Integer> countMap = new HashMap<>();

        for(int i=0; i<tasks.length; i++) {
            countMap.put(tasks[i], countMap.getOrDefault(tasks[i], 0)+1);
        }

        System.out.println(countMap.toString());

        //2C+2+2C+2+2C
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> Integer.compare(countMap.get(c2), countMap.get(c1)));
        maxHeap.addAll(countMap.keySet());

        boolean isHeapPopulated = false;
        while(!maxHeap.isEmpty()) {
            List<Character> popped = new ArrayList<>();
            char c = maxHeap.poll();
            countMap.put(c, countMap.get(c)-1);
            popped.add(c);
            cycles++;

            //AB_AB_AB
            int i=0;
            for(i=0; i<n; i++) {
                if(!maxHeap.isEmpty()) {
                    char cc = maxHeap.poll();
                    countMap.put(cc, countMap.get(cc)-1);
                    popped.add(cc);
                    cycles++;
                }
                else
                    break;
            }

            //adding the tasks back in whose count is still not zero
            for(Character chars : popped) {
                if(countMap.get(chars) > 0) {
                    maxHeap.add(chars);
                }
            }

            if(!maxHeap.isEmpty())
                cycles += (n-i);
        }

        return cycles;
    }
}
