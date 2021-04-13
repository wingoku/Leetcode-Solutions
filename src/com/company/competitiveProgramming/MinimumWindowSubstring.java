package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {
    //INPUT --> ADOBECODEBANC | FIND: ABC :: RESULT -> BANC

    //https://www.youtube.com/watch?v=nMaKzLWceFg
    public String minWindow(String input, String toBeFound) {
        if(input == null || input.isEmpty() || toBeFound == null || toBeFound.isEmpty() || input.length() < toBeFound.length())
            return "";

        //two pointers
        //startPointer, endPointer both start at 0
        //we move right pointer until we've all the characters give in "toBeFound" variable between startPointer & endPointer
        //store the string when the all characters are found
        //if endPointer != lengthOfInput, move the right pointer
        //than check if it's all the characters in the given toBeFound variable
        //if yes, we check if it's smaller than the previously found string
        //if yes, than we store it in smallestSubstring variable
        //if not, we move startPointer forward/inward
        //than we check again in the new windw
        //we repeat the process until we reach the end of the string

        /**
         The idea is to create a map with counts of character given in the toBeFound String

         Than iterate over the string with 2 pointers

         start and i,

         upon every i loop character, we check if the currentCharacter is in the map,
         if yes: we decrement the count for that character in the map

         and we increment a count variable as long as map.get(currentCharacter) >= 0

         when count == toBeFound.length

         than we shrink the window

         and everytime we come across a character that's in our map, we increment its count in the map. We decrement the count and we get out of the inneer loop
         */

        HashMap<Character, Integer> map = new HashMap<>();

        for(Character c : toBeFound.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);

        int minLength = Integer.MAX_VALUE;
        int minStart = 0;
        int start = 0;

        int count = 0;

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);

            if(map.containsKey(c)) {
                map.put(c, map.get(c)-1);

                if(map.get(c) >= 0)
                    count++;
            }


            if(count == toBeFound.length()) {

                while(count == toBeFound.length()) {

                    if(minLength > i-start+1) {
                        minLength = i-start+1;
                        minStart = start;
                    }

                    char cc = input.charAt(start);

                    if(map.containsKey(cc)) {
                        map.put(cc, map.get(cc)+1);

                        if(map.get(cc) > 0) {
                            count--;
                        }
                    }

                    start++;
                }
            }
        }

        if(minLength > input.length())
            return "";

        return input.substring(minStart, minStart+minLength);
    }
}
