package com.company.competitiveProgramming;

public class ValidAnagrams {

    /**
     anagrams have the same characters but can be arranged in a different pattern

     Eg.
     s = "anagram", t = "nagaram"

     both have the same characters but rearranged

     SOLUTION:

     The idea is to increment the count for each character occuring in s in ascii array
     and than iterating over t & decrementing the count for characters t in ascii array

     if s & t have the same characters in them, the count for each character in s should be 0 in the ascii array
     */
    public boolean isAnagram(String s, String t) {

        if(s == null && t == null)
            return true;

        if(s == null || t == null || s.length() != t.length())
            return false;

        int[] hash = new int[128];

        for(int i=0; i<s.length(); i++) {
            hash[s.charAt(i)]++;
        }

        for(int i=0; i<t.length(); i++) {
            hash[t.charAt(i)]--;
        }

        for(int i=0; i<s.length(); i++) {
            if(hash[s.charAt(i)] > 0)
                return false;
        }

        return true;
    }
}
