package com.company.competitiveProgramming;

public class isSubsequence {
    //solved leetcode
    //amazon coding
    //1 ms
    public boolean isSubsequence(String s, String t) {
        //we need to find characters in S in the same order in T
        if(s == null || t == null)
            return false;

        if(s.isEmpty() || t.isEmpty() && s.isEmpty())
            return true;

        int matchedLettersCount = 0;
        int indexForS = 0;

        //we loop over both string until we reach the end of one of the string
        for(int i=0; i < t.length() && indexForS < s.length(); i++) {
            char currentCharacter = s.charAt(indexForS);

            //if the current character in S matches with current character in T
            //we increment the count and increment the iteration index for S only than
            //if we don't increment indexForS in this condition but outside this condition, we may try to match with characters in t that're not in S until the character that would match with
            // character in S.
            if(currentCharacter == t.charAt(i)) {
                matchedLettersCount++;
                indexForS++;
            }
        }
        return matchedLettersCount == s.length();
    }
}
