package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class ReorderDataInLogFiles {
    /**
     * Letter logs order lexicographicallhy
     1. if both logs are same lexicographically than use log identifier to sort them
     * Digit logs come in their original order


     The idea is to sort word logs using min heap and put the digit logs as is in a separate list

     than iterate over the minHeap to get all the sorted logs and put them in a list and than merge the
     list with digit list.

     */

    //use min heap to arrange the logs lexicographically

    //total TC: O(N log n) N cuz we're iterating over the list and log n is coming from the minHeap
    //SC: O(n) cuz in worst case we'll put all the logs in minHeap in case there are no digit logs
    public String[] reorderLogFiles(String[] logs) {
        if(logs == null || logs.length == 0)
            return new String[0];

        //TC: O(log n)
        PriorityQueue<String> minHeap = new PriorityQueue<>((word1, word2) -> {
            int firstSpaceIndex1 = word1.indexOf(" ");
            int secondSpaceIndex2 = word2.indexOf(" ");
            String ident1 = word1.substring(0, firstSpaceIndex1);
            String ident2 = word2.substring(0, secondSpaceIndex2);

            String logPart1 = word1.substring(firstSpaceIndex1, word1.length());
            String logPart2 = word2.substring(secondSpaceIndex2, word2.length());

            int result = logPart1.compareTo(logPart2);
            if(result == 0) {
                //arrange based on the log identifier part
                return ident1.compareTo(ident2);
            }
            else {
                return result;
            }
        });

        List<String> digLogList = new ArrayList<>();
        List<String> wordLogList = new ArrayList<>();

        //O(N)
        for(String string : logs) {
            if(containsDig(string)) {
                digLogList.add(string);
            }
            else {
                minHeap.add(string);
            }
        }

        while(!minHeap.isEmpty()) {
            wordLogList.add(minHeap.poll());
        }

        wordLogList.addAll(digLogList);

        String[] result = wordLogList.toArray(new String[0]);;
        //O(N)
        // for(int i=0; i<result.length; i++) {
        //     result[i] = wordLogList.get(i);
        // }

        return result;
    }

    private boolean containsDig(String word) {
        int result = word.charAt(word.length()-1) - '0'; //converting character into it's decimal representation

        return result >= 0 && result <= 9; //if the character is a number than it'll like between 0-9
    }
}
