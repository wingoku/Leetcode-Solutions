package com.company.competitiveProgramming;

import java.util.HashMap;

public class NumberOfMatchingSubsequeneces {
    public int numMatchingSubseq(String S, String[] words) {
        HashMap<Integer, Boolean> matchingSubsequences = new HashMap<>();
        int subsequenceIndex = 0;
        int numOfMatchingSubsequences = 0;
        char[] sCharArray = S.toCharArray();
        for(int i=0; i<words.length; i++) {
            if(matchingSubsequences.containsKey(words[i].hashCode())) {
                numOfMatchingSubsequences++;
                continue;
            }

            int index = -1;
            int tempIndex = 0;
            for(int j=0; j< words[i].length(); j++) {
              tempIndex = S.indexOf(words[i].charAt(j));
              if(tempIndex < index)
                  index = j;
            }

            if(index == words[i].length()) {
                matchingSubsequences.put(words[i].hashCode(), true);
                numOfMatchingSubsequences++;
            }
        }

        return numOfMatchingSubsequences;
    }

    //works but slow
    /*public int numMatchingSubseq(String S, String[] words) {
        HashMap<Integer, Boolean> matchingSubsequences = new HashMap<>();
        int subsequenceIndex = 0;
        int numOfMatchingSubsequences = 0;
        for(int i=0; i<words.length; i++) {
            if(matchingSubsequences.containsKey(words[i].hashCode())) {
                numOfMatchingSubsequences++;
                continue;
            }

            subsequenceIndex = 0;
            for(int j=0; j<S.length() && subsequenceIndex < words[i].length(); j++) {
                if(words[i].charAt(subsequenceIndex) == S.charAt(j))
                    subsequenceIndex++;
            }

            if(subsequenceIndex == words[i].length()) {
                matchingSubsequences.put(words[i].hashCode(), true);
                numOfMatchingSubsequences++;
            }
        }

        return numOfMatchingSubsequences;
    }*/
}
