package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class ReverseVowelsOfString {

    //leetcode 4ms
    //two pointer
    //tc (2n)
    //sc (2n)
    public String reverseVowelsTwoPointerKevin(String s) {
        if(s == null || s.isEmpty())
            return s;

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] characterArray = s.toCharArray();

        int i=0;
        int j = s.length()-1;

        /**
         * The idea is we iterate over the character array using 2 points
         * we start from the left side & when we come across a vowel
         * we move right pointer j until it stumbles across a vowel
         * we swap the vowels at left & right pointer i,j
         * we get out of the inner loop & than we continue moving the left pointer until we stumble across another vowel or i>=j
         */
        while(i < j) {

            //if left pointer doesn't come across a vowel, keep running the loop
            while(i < j && !vowels.contains(s.charAt(i))) {
                i++;
            }

            //if right pointer doesn't come across a vowel, keep running the loop
            while(i < j && !vowels.contains(s.charAt(j))) {
                j--;
            }

            //both loops have stumbled across a vowel, now swap
            char temp = characterArray[j];
            characterArray[j] = characterArray[i];
            characterArray[i] = temp;

            //cuz the swap has been done, now move left pointer further & right pointer further
            i++;
            j--;
        }

        return new String(characterArray);
    }

    public String reverseVowelsTwoPointerMine(String s) {
        if(s == null || s.isEmpty())
            return s;

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] characterArray = s.toCharArray();

        int i=0;
        int j = s.length()-1;

        /**
         * The idea is we iterate over the character array using 2 points
         * we start from the left side & when we come across a vowel
         * we move right pointer j until it stumbles across a vowel
         * we swap the vowels at left & right pointer i,j
         * we get out of the inner loop & than we continue moving the left pointer until we stumble across another vowel or i>=j
         */
        while(i < j) {
            if(vowels.contains(s.charAt(i))) {
                while(j >= i) {
                    if(vowels.contains(s.charAt(j))) {
                        char temp = characterArray[j];
                        characterArray[j] = characterArray[i];
                        characterArray[i] = temp;

                        j--;
                        break;
                    }
                    j--;
                }
            }

            i++;
        }
        return new String(characterArray);
    }

    //leetcode 7ms
    //tc - O(2n)
    //sc - O(2n)
    //amazon coding interview
    public String reverseVowelsSimple(String s) {

        if(s == null || s.isEmpty())
            return s;

        List<Character> vowelsList = new ArrayList<>();

        HashSet<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');

        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(vowels.contains(c)) {
                vowelsList.add(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        int j=vowelsList.size()-1;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(vowels.contains(c)) {
                sb.append(vowelsList.get(j--));
            }
            else
                sb.append(c);
        }

        return sb.toString();
    }
}
