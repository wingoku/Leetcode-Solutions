package com.company.competitiveProgramming;

public class ValidPalindrome {

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
