package com.company.competitiveProgramming;

public class ValidPalindrome2 {

    //TC: O(N) cuz we iterate over all the characters once for checking if palindrome
    // SC: O(1) cuz we're not allocating any new memory
    public boolean validPalindrome(String s) {

        if(s == null || s.length() < 2)
            return true;

        int i=0;
        int j = s.length()-1;

        while(i < j) {
            //the very first time we have this condition true,
            //we need to check if by remove a character from the left side and check if string is palindrome or not i-e; i+1->j
            //we need to check if by remove a character from the right side and check if string is palindrome or not i-e; i->j-1
            //we do this cuz we are allowed to remove one character
            //but we don't know by removing character from which side would make the string a palindrome
            //therefore we check it by both ways
            if(s.charAt(i) != s.charAt(j)) {
                return isPalindrome(s, i+1, j) || isPalindrome(s, i, j-1);
            }
            i++;
            j--;
        }

        return true;
    }

    private boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start++) != s.charAt(end--))
                return false;
        }

        return true;
    }
}
