package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupedAnagrams {
    //leetcode accepted
    //amazon coding interview
    //TC: O(n*m)
    public List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> anagramMap = new HashMap<>();

        for(String str : strs) {
            //we're sorting the string characters in ascending order
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);

            //creating a new string based on the sorted character so strings like eta, eta, tea, ate will all look like aet after sorting
            //so we make the sorted string as a key in the map & every string whose sorted character matches with the key in map, we add it
            //to the list for that key

            //the reason we're not using character sum for checking if a string is an anagram is cuz it doesn't ensure if 2 strings
            //are really anagrams eg. sum of characters for the following 2 strings is the same but yet they're not anagrams
            //"duh","ill"
            String ascendingOrderSortedString = new String(charArray);

            List<String> list = anagramMap.getOrDefault(ascendingOrderSortedString, new ArrayList<String>());
            list.add(str);
            anagramMap.put(ascendingOrderSortedString, list);
        }

        List<List<String>> groupedAnagramsList = new ArrayList<>();

        for(String key : anagramMap.keySet())
            groupedAnagramsList.add(anagramMap.get(key));

        return groupedAnagramsList;
    }
}
