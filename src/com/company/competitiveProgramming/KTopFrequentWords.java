package com.company.competitiveProgramming;

import java.util.*;

public class KTopFrequentWords {

    //leetcode accepted
    //amazon coding interview
    //heap problem

    /**
     *
     * GIVEN EXAMPLES:
     *
     * Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
     * Output: ["i", "love"]
     * Explanation: "i" and "love" are the two most frequent words.
     *     Note that "i" comes before "love" due to a lower alphabetical order.
     *
     *
     * Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
     * Output: ["the", "is", "sunny", "day"]
     * Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
     *     with the number of occurrence being 4, 3, 2 and 1 respectively.
     */

    //TC: O(n log K)
    public List<String> topKFrequent(String[] words, int k) {

        HashMap<String, Integer> wordCountMap = new HashMap<>();

        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((word1, word2) -> {

            //if the count of both words is the same
            //and since the question asked us to return results in alphabetical order, we put the words with same frequency to be put
            //such that the word that starts with a character that occurs later in letters a-z
            //is put before the word that starts with a character that occurs earlier in letters a-z
            //before returning the results, we'll reverse the list
            if(word1.getValue().equals(word2.getValue())) {
                return word2.getKey().compareTo(word1.getKey());
            }

            //if words count is not the same than we want them to arranged in minHeap fashion so that we can just pop the less frequent words
            return word1.getValue().compareTo(word2.getValue());
        });

        for(String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0)+1);
        }

        for(Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            minHeap.add(entry);

            //question said we want our code to run in O(n log k) time.
            //since the the poll operation on heap is O(n log N) where N is the number of elements in the heap
            //we achieve O(n log K) by keeping the number of elements == K all the time
            //so as soon as the minHeap.size() > k, we just poll an element to keep the minHeap size == k
            if(minHeap.size() > k)
                minHeap.poll();
        }

        List<String> frequentWordsList = new ArrayList<>();

        while(minHeap.size() > 0) {
            frequentWordsList.add(minHeap.poll().getKey());
        }

        //we reverse the list cuz we added the words (with similar frequency) in minHeap in reverse order
        //so in order to return them in correct order, we've to reverse them again
        Collections.reverse(frequentWordsList);

        return frequentWordsList;
    }
}
