package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AmazonQuestion_K_minus_1_DistinctCharacters {

    //https://leetcode.com/discuss/interview-question/877624/Amazon-or-OA-2020-or-Substrings-of-Size-K-with-K-1-Distinct-Chars
    public void kDistinctCharacters() {
        String string = "wawaglknagagwunagkwkwagl";
        int k = 4;

        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0;
        int right = 0;

        //O(N)
       while(right < string.length()) {

           //moving left pointer to shrink the window so that its size == k
           while(right - left + 1 > k) {
               char c = string.charAt(left);

               //since we're shrinking the window by moving the left pointer towards right, we need to decrement the count of characters
               //during shrinking process since they're no longer part of the window
               map.put(c, map.get(c)-1);

               //if count of a character == 0, it means it should be remove from the window
               if(map.get(c) == 0)
                   map.remove(c);

               left++;
           }

           //putting the new character after expanding the window
           char c = string.charAt(right);
           map.put(c, map.getOrDefault(c, 0)+1);

           //
           if(right - left + 1 == k && map.size() == k-1) { //k-1 cuz we can have only 1 duplicate character. Rest of the characters have to be distinct therefore if we've 1 duplicate and rest are distinct
               //than the map size should be k-1 since k is the given size of string that contains on 1 duplicate character
               System.out.println(string.substring(left, right+1));
           }
           right++;
       }
    }


   /* private boolean checkForOneDup(String string, int start, int end) {
        int dups = 0;
        HashMap<Character, Integer> countMap = new HashMap<>();
        //O(N)
        for(int i = start; i <= end; i++) {
             char c = string.charAt(i);

            countMap.put(c, countMap.getOrDefault(c, 0)+1);
             if(countMap.containsKey(c) && countMap.get(c) >= 2) {
                 dups++;
             }
        }

        return dups == 1;
    }*/
}
