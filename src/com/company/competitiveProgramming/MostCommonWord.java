package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();

        for(String bannedWord : banned)
            bannedSet.add(bannedWord);

        Map<String, Integer> countMap = getWordCountMap(paragraph);

        String mostCommonWord = "";
        int maxCount = 0;
        for(String word : countMap.keySet()) {
            if(bannedSet.contains(word))
                continue;
            if(maxCount < countMap.get(word)) {
                mostCommonWord = word;
                maxCount = countMap.get(word);
            }
        }

        return mostCommonWord;
    }

    private Map<String, Integer> getWordCountMap(String word) {
        Map<String, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i);

            if(c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z')
                sb.append(Character.toLowerCase(c));
            else
                //if sb length is not greater than 0 that means we may have a white space or non abc character at this index, so we ignore it
                if(sb.length() > 0) {
                    String cleanWord = sb.toString();
                    map.put(cleanWord, map.getOrDefault(cleanWord, 0)+1);
                    sb.setLength(0);
                }
        }

        //in case we just have one word in the string. By the time the loop ends, we won't be able to add it in the map inside the loop therefore we do it outside
        if(sb.length() > 0) {
            String cleanWord = sb.toString().toLowerCase();
            map.put(cleanWord, map.getOrDefault(cleanWord, 0)+1);
        }

        // System.out.println(map.toString());

        return map;
    }
}
