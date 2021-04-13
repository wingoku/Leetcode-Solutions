package com.company.competitiveProgramming;

import java.util.HashMap;

public class VerifyAlienDictionary {
    //video tutorial about what's lexicographical ordeR: https://www.youtube.com/watch?v=LtlZtFXe8Io

    //TC: O(M * N) where M is the length of words Array and N is the length of each word
    public boolean isAlienSorted(String[] words, String order) {

        if(words == null || words.length == 0 || order == null || order.isEmpty())
            return false;

        HashMap<Character, Integer> posMap = new HashMap<>();

        //putting the alien language characters & their positions in a map
        for(int i=0; i<order.length(); i++) {
            posMap.put(order.charAt(i), i);
        }

        for(int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];

            if(!checkIfOrderd(word1, word2, posMap))
                return false;
        }

        return true;
    }

    private boolean checkIfOrderd(String word1, String word2, HashMap<Character, Integer> posMap) {
        //we iterate till the length of the smallest length
        int length = Math.min(word1.length(), word2.length());
        for(int i=0; i<length; i++) {

            //if letters are similar, don't do anything
            if(word1.charAt(i) == word2.charAt(i))
                continue;

            //compare letters at the same position in both words,
            //if the letter in word1 that occurs in the dictionary later than the letter at same position in word 2
            //the words are not lexicographically sorted
            if(posMap.get(word1.charAt(i)) > posMap.get(word2.charAt(i))) {
                return false;
            }

            //if the very first occurance different letters in word 1 & 2 happen
            //such that the letter in word1 occurs in the dictionary before than the latter in word2
            //than the word is lexicographically sorted

            return true;
        }

        //if letters of the words were sorted lexicographically but length of word1 is > than length of word2
        //than they are not placed in the list in lexicographical order
        //Eg. word1 = "apple", word2 = "app", the first 3 letters match but the length of word1 > word2
        if(word1.length() > word2.length()) {
            return false;
        }

        return true;
    }
}
