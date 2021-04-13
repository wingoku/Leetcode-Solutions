package com.company.competitiveProgramming.premium;

class Solution {
    /**
     The question says that

     1. The strings should have at MAX 1 character difference i-e;
     Their length can differ by 1 character or if they've the same length than only one character should be different
     2. The order of the characters in both strings should be the same apart from one character
     */
    //TC: O(N)
    //SC: O(N)
    public boolean isOneEditDistance(String s, String t) {

        if(s.isEmpty() && t.isEmpty())
            return false;

        if(Math.abs(s.length()-t.length()) >= 2) //only one character can be different hence one edit distance
            return false;

        if(s.length() < t.length())
            return isOneCharacterDifferent(s, t);

        return isOneCharacterDifferent(t, s);
    }

    //strings with 1 char difference
    //ab  acb
    //axb acb
    private boolean isOneCharacterDifferent(String s, String t) {

        int index1 = 0;
        int index2 = 0;

        while(index1 < s.length() && index2 < t.length()) {
            if(s.charAt(index1) != t.charAt(index2)) //we found the first different characters
                break;

            index1++;
            index2++;
        }

        //if both index ints reached the end of string s and t respectively, it means there's no character difference between the two strings
        if(index1 == s.length() && index2 == t.length())
            return false;

        //if above condition is false it means small string reached its end and large string t didn't reach its end so it means there is 1 character difference
        //the way we can garrenty this is cuz in the very beginning of the main method we check if the two given strings only have 1 CHARACTER differnce otherwise
        //we immediately return false
        if(index1 == s.length())
            return true;
        //covers: ab  acb case                                //covers: axb acb case
        return s.substring(index1).equals(t.substring(index2+1)) || s.substring(index1+1).equals(t.substring(index2+1));
    }
}