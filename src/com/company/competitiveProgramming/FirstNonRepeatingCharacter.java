package com.company.competitiveProgramming;

import java.util.HashMap;

public class FirstNonRepeatingCharacter {

    //aabbcdceff
    //AMAZON CODING INTERVIEW
    //working according to leetcode
    public int firstUniqueCharacter(String input) {
        int position = -1;
        int startPointer = 0;
        int endPointer = 0;
        char lastChar = 0;

        int sum = 0;
        char firstUniqueChar = 0;
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
        //loveleetcode
        //if sum ^ = currentChar === currentChar, currentChar = unique
        /*for(int i=0; i<input.length(); i++) {
            sum ^= (int)input.charAt(i);
            System.out.println("sumChar: "+ ((char)sum));
            if(input.indexOf(sum) != -1)
                firstUniqueChar = (char) sum;
        }*/

//        System.out.println("firstUniqueCharacter: "+ firstUniqueChar);
        /*while(endPointer < input.length()) {
            if(lastChar != input.charAt(endPointer)) {
                startPointer = position =  endPointer;
            }

            lastChar = input.charAt(endPointer);
            endPointer++;
        }*/
//        return position;
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
