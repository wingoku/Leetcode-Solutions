package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class FindSubstring {

    public void test() {
        findLongestSubstring();
        int size = lengthOfLongestSubstring("ppwwkew");
        System.out.println("length is: "+ size);
    }

     private void findLongestSubstring() {
        String input = "abcabcbb";
//        String input = "pwwkew";
//        String input = "bbbbbbbbbbb";
        long start = System.nanoTime();
        char lastChar = input.charAt(0);
        HashMap<Character, Character> map = new HashMap<>();
        String result = "";
        boolean foundDifferentChar = false;
//        HashSet<Character> nonRepetativeStringMap = new HashSet<>();
        for(int i=0; i<input.length(); i++) {
            char currentChar = input.charAt(i);
            if(currentChar == lastChar) {
                System.err.println("clearing");
                result = "";
            }
            else {
                if(!map.containsKey(lastChar)) {
                    foundDifferentChar = true;
                    System.err.println("adding: "+lastChar);
                    map.put(lastChar, lastChar);
                    result += lastChar;
                }
            }
            lastChar = currentChar;
        }
        if(!foundDifferentChar)
            result += lastChar;

         System.err.println("substring: "+result);
         System.out.println("time taken: "+ (System.nanoTime() - start));
         System.out.println("length is: "+ result.length());

    }

    public int lengthOfLongestSubstring(String input) {
        HashSet<Character> nonRepetativeStringMap = new HashSet<>();
        for(int i=0; i<input.length(); i++) {
            nonRepetativeStringMap.add(input.charAt(i));
        }
        return nonRepetativeStringMap.size();
    }
}
