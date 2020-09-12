package com.company.competitiveProgramming;

import java.util.*;

public class KTopFrequentWords {

    //leetcode accepted
    //amazon coding interview
    //heap problem
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> wordCountMap = new HashMap<>();

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((word1, word2) -> {
            if(word1.getValue().equals(word2.getValue())) {
                return word2.getKey().compareTo(word1.getKey());
            }

            return word1.getValue().compareTo(word2.getValue());
        });

        for(String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0)+1);
        }

        for(Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            minHeap.add(entry);

            if(minHeap.size() > k)
                minHeap.poll();
        }

        List<String> frequentWordsList = new ArrayList<>();

        while(minHeap.size() > 0) {
            frequentWordsList.add(minHeap.poll().getKey());
        }
        Collections.reverse(frequentWordsList);

        return frequentWordsList;
    }
}
