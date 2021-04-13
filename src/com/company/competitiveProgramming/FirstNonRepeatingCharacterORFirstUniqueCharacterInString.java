package com.company.competitiveProgramming;

import java.util.HashMap;

public class FirstNonRepeatingCharacterORFirstUniqueCharacterInString {

    //aabbcdceff
    //AMAZON CODING INTERVIEW
    //working according to leetcode

    public int firstUniqChar(String input) {
        if(input == null || input.isEmpty())
            return -1;

        if(input.length() == 1)
            return 0;

        int index = -1;
        HashMap<Character, Integer> countMap = new HashMap<>();

        for(int i=0; i<input.length(); i++) {
            char c = input.charAt(i);
            countMap.put(c, countMap.getOrDefault(c, 0)+1);
        }

        for(int i=0; i<input.length(); i++) {
            if(countMap.get(input.charAt(i)) == 1){
                index = i;
                break;
            }
        }
        return index;
    }

    public int firstUniqueCharacter(String input) {
        int hashPattern[] = new int[256];

        for(int i=0; i<input.length(); i++) {
            hashPattern[input.charAt(i)]++;
        }

        for(int i=0; i<input.length(); i++) {
            if(hashPattern[input.charAt(i)] == 1) {
                System.out.println("firstUniqueChar: "+ input.charAt(i));
                return i;
            }
        }
        return -1;
    }

    //accepted but slower solution
    /*public int firstUniqueCharacter(String input)  {
        HashMap<Character, Integer> map = new HashMap<>(input.length());
        char[] charArray = input.toCharArray();

        for(char c : charArray) {
            if (map.containsKey(c) == true) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        for(int i=0; i<charArray.length; i++)
            if(map.get(charArray[i]) == 1)
                return i;
        return -1;
    }*/
}
