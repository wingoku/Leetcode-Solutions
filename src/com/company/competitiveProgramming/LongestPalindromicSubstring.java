package com.company.competitiveProgramming;

public class LongestPalindromicSubstring {
    private int startOfLongestPalidrome;
    private int lengthOfLongestPalindrome;

    /**
        The idea is to find palindrome by starting from the center of each substring and than expanding left & right and matching the characters from left and right half
        and when we encounter mismatching characters, we stop cuz until the last iteration we had a palindrome

        We choose each character in the string using a LOOP A and than expand left and right in LOOP B
     */
    //TC: O(n^2) cuz for each character in the loop inside longestPalindrome(), we call expand method to to match N characters
    //inrder to find the palindrome
    //SC: O(1)
    //revise
    public String longestPalindrome(String s) {
        if(s == null || s.isEmpty() || s.length() == 1)
            return s;

        for(int i=0; i<s.length(); i++) {
            int mid = i;
            //cuz if we've string with odd length, the mid will be one character Eg. aba
            //in this mid is b and we expand from b and both left and right side have the same mid point
            expandFromCenter(s, mid, mid);

            //cuz if we've string with even length, the mid will have 2 characters. Eg. abba
            //in this case, left half of the palindrome would have it's own b and right half of the palidrome would have
            //its own b. Therefore to cover both b, we have to do mid and mid+1
            expandFromCenter(s, mid, mid+1);
        }

        return s.substring(startOfLongestPalidrome, startOfLongestPalidrome+lengthOfLongestPalindrome);
    }

    private void expandFromCenter(String s, int start, int end) {
        while(start >= 0 && end < s.length()) {
            if(s.charAt(start) == s.charAt(end)) {
                start--;
                end++;
            }
            else
                break;
        }

        //eg. if the strings matches until start = 2 and end = 4
        //and in next iteration they don't match at start = 1 & end = 5
        //the length of the palindrome string is 3 cuz char at index 2, char at index 3 and char at index 4
        //and since start and end have already decremented and incremented respectively, we do end-start-1 Eg. 5-1-1 = 3
        int foundPalindromeLength = end - start - 1;

        if(foundPalindromeLength > lengthOfLongestPalindrome) {
            lengthOfLongestPalindrome = foundPalindromeLength;
            startOfLongestPalidrome = start + 1; // cuz before we found the mismatch, we had already done start-- in previous iteration
        }
    }
}
