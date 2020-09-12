package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {

    //amazon coding interview
    public String reorganizeString(String S) {
        // HashMap<Character, Integer> map = new HashMap<>();

        /**
         create a map of all characters with counts
         run loop till length of string


         aabb - possible -> abab
         aabcb - possible -> ababc
         aabbcc   abcabc
         */


        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> countMap = new HashMap<>();
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((c1, c2) -> Integer.compare(countMap.get(c2), countMap.get(c1)));
        //calculating counts of each character in the string
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);

            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }

        //putting all the key,value pairs from countMap into the priorityQueue
        maxHeap.addAll(countMap.keySet());

        //we're checking if it's greater than 1 cuz we 2 different characters from the maxHeap upon every iteration of the loo
        //if heap has 0 items left, it means all the characters were placed without having adjecent duplicates i-e; aabbcc => abcabc
        //if heap size == 1 after this loop terminates it means 2 things
        //either the character entry left in the maxHeap has count == 1 or more than 1
        //in case count of that particular character == 1, we add it to the result and we return the string
        //if count of that particular character > 1 than we can't create reorganized string like required in the question
        //so we return empty string
        while(maxHeap.size() > 1) {
            Character c1 = maxHeap.poll();
            Character c2 = maxHeap.poll();

            int c1Count = countMap.get(c1);
            int c2Count = countMap.get(c2);

            if(c1Count > 0) {
                sb.append(c1);

                c1Count -= 1;

                if(c1Count > 0) {
                    countMap.put(c1, c1Count);
                    maxHeap.add(c1);
                }
            }

            if(c2Count > 0) {
                sb.append(c2);

                c2Count -= 1;

                if(c2Count > 0) {
                    countMap.put(c2, c2Count);
                    maxHeap.add(c2);
                }
            }
        }

        //if we end up on this condition
        //only 2 things can happen
        //either the maxHeap size == 1 cuz the upper loop condition says to run the loop until the heapSize > 1 so when heapSize is <=1, the loop termintes
        if(maxHeap.size() == 1) {
            Character c = maxHeap.poll();

            if(countMap.get(c) > 1)
                return "";

            sb.append(c);
        }

        return sb.toString();
    }

    public String reorganizeString_WithMapEntry(String S) {
        // HashMap<Character, Integer> map = new HashMap<>();

        /**
         create a map of all characters with counts
         run loop till length of string


         aabb - possible -> abab
         aabcb - possible -> ababc
         aabbcc   abcabc
         */


        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> countMap = new HashMap<>();
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()));

        //calculating counts of each character in the string
        for(int i=0; i<S.length(); i++) {
            char c = S.charAt(i);

            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }

        //putting all the key,value pairs from countMap into the priorityQueue
        maxHeap.addAll(countMap.entrySet());

        //we're checking if it's greater than 1 cuz we 2 different characters from the maxHeap upon every iteration of the loo
        //if heap has 0 items left, it means all the characters were placed without having adjecent duplicates i-e; aabbcc => abcabc
        //if heap size == 1 after this loop terminates it means 2 things
        //either the character entry left in the maxHeap has count == 1 or more than 1
        //in case count of that particular character == 1, we add it to the result and we return the string
        //if count of that particular character > 1 than we can't create reorganized string like required in the question
        //so we return empty string
        while(maxHeap.size() > 1) {
            Map.Entry<Character, Integer> entry1 = maxHeap.poll();
            Map.Entry<Character, Integer> entry2 = maxHeap.poll();

            int character1Count = entry1.getValue()-1;
            int character2Count = entry2.getValue()-1;

            if(character1Count <= 0)
                countMap.remove(entry1.getKey());
            else {
                countMap.put(entry1.getKey(), character1Count);
                maxHeap.add(entry1);
            }
            sb.append(entry1.getKey());


            if(character2Count <= 0)
                countMap.remove(entry2.getKey());
            else {
                countMap.put(entry2.getKey(), character2Count);
                maxHeap.add(entry2);
            }
            sb.append(entry2.getKey());
        }

        //if we end up on this condition
        //only 2 things can happen
        //either the maxHeap size == 1 cuz the upper loop condition says to run the loop until the heapSize > 1 so when heapSize is <=1, the loop termintes
        if(maxHeap.size() == 1) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();

            if(entry.getValue() > 1)
                return "";

            sb.append(entry.getKey());
        }

        return sb.toString();
    }
}
