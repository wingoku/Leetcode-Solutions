package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;

public class ValidPalindrome {

    //TC: O(N)
    //SC: O(N)
    public boolean isPalindrome_EASIER(String s) {

        if(s == null || s.length() == 1)
            return true;

        List<Character> list = new ArrayList<>();

        //remove all the non alphanumric stuff out
        //and put only alphanumeric characters in the list
        for(int i=0; i<s.length(); i++) {
            char c = Character.toLowerCase(s.charAt(i));

            if(isAlphanumeric(c))
                list.add(c);
        }

        int i = 0;
        int j = list.size()-1;

        while(i < j) {

            char sC = list.get(i++);
            char eC = list.get(j--);

            if(sC != eC)
                return false;
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        return c >= 'a' && c <= 'z' || c >= '0' && c <= '9';
    }




    //accepted answer. Took 1ms in leetcode
    public boolean isValidPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        boolean isPalindrome = true;
        boolean nonAlphanumericChar = false;

        char frontChar, endChar;

        while(i<j) {
            frontChar = s.charAt(i);
            endChar = s.charAt(j);

            if(!isAChar(frontChar) && !isANum(frontChar)) {
                nonAlphanumericChar = true;
                i++;
            }

            if(!isAChar(endChar) && !isANum(endChar)) {
                nonAlphanumericChar = true;
                j--;
            }

            if(nonAlphanumericChar) {
                nonAlphanumericChar = false;
                continue;
            }

            if((isAChar(frontChar) && isAChar(endChar) && areSameCharacters(frontChar, endChar)) || (isANum(frontChar) && isANum(endChar) && frontChar == endChar)) {
                i++;
                j--;
            }
            else {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("is valid palindrom: "+ isPalindrome);
        return isPalindrome;
    }

    private boolean areSameCharacters(char char1, char char2) {
        return (char1 == char2 || char1 == char2+32 || char1+32 == char2);
    }

    private boolean isAChar(char c) {
        return c>=65 && c<=90 || c>=97 && c<=122;
    }

    private boolean isANum(char c) {
        return c>=48 && c<=57;
    }
}
