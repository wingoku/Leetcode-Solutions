package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.List;

public class WordLadder {

    /*
        1. find if endWord exists in the array
        2. find if the a word similar to beginWord exists in the array
            a. Meaning the first & last character of the beginWord match with at least 1 word in the array
        3. Than find a word that's 2 letters matching with the word that was a match with begin word


        NOTE:
        we are not gurranteed that a word similar to beginWord exists
        we assume that words in the list are not jumbled meaning that hit->hot, hot can't be at the end of the list, it'll appear before the word that's a potential match for endWord
        ["hot","dot","dog","lot","log","cog"] - possible
        ["lot","log","cog","hot","dot","dog"] - not possible

        beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]

           beginWord
        =>     hit  -> hot cuz 2 letters match

           beginWord
        =>     hot  -> dot cuz 2 letters match

           beginWord
        =>     dot  -> dog cuz 2 letters match

           beginWord
        =>     dog  -> cog cuz 2 letters match

        loop over the list
        than loop over each character in the word from the list
        when 2 letter match, the new word becomes the beginWord

        TC: N*t


     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //if list size <=1 means we can only match begin word potential & endWord won't be found
        if(wordList == null || wordList.size() <=1)
            return 0;

        HashMap<String, Integer> tempMap = new HashMap<>();

        int countOfMatchingLetters = 0;
        int matchingSequences = 0;

        /*
         beginWord = "hit",
        endWord = "cog",
        wordList = ["hot","dot","dog","lot","log","cog"]
         */

        for(int j = 0; j<wordList.size(); j++) {
            String word = wordList.get(j);

            //if the word after current word matches the endWord, than we increment and end the loop
            if(j+1 < wordList.size() && endWord.equals(wordList.get(j+1))) {
                matchingSequences++;

                tempMap.put(word, j+1);
                System.out.println("output: "+ matchingSequences + " map: "+ tempMap.toString());
                return matchingSequences;
            }

            for(int i=0; i<word.length(); i++) {
                if(beginWord.charAt(i) == word.charAt(i))
                    countOfMatchingLetters++;

                if(countOfMatchingLetters == beginWord.length()-1) {
                    matchingSequences++;
                    tempMap.put(word, j);
                    beginWord = word;
                    countOfMatchingLetters=0;
                }
            }
        }

        if(beginWord.equals(endWord)) {

            System.out.println("output: "+ matchingSequences + " map: "+ tempMap.toString());
            return matchingSequences;
        }

        System.out.println("RETURNING 0 output: "+ matchingSequences + " map: "+ tempMap.toString());
        return 0;
    }
}
