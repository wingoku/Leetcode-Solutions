package com.company.competitiveProgramming;

public class LengthOfLastWord {
    //TC: O(K) where k is length of the very first we encounter Case: "my word"
    //in worse case TC = O(N) if we just one word in the beginning of string and lots of spaces after that eg. "word         "
    public int lengthOfLastWord(String s) {

        if(s == null || s.length() == 0)
            return 0;

        int length = 0;
        for(int i = s.length()-1; i>=0; i--) {

            //if we come across a non space word, increment the length counter
            if(s.charAt(i) != 32) { //32 is ascii code for space
                length++;
            }
            else
                // if length > 0 meaning we did come across some word & now we've come across a space character
                //this takes care of conditions like "word " and also works for "my word"
                if(length > 0)
                    break;
        }

        return length;
    }
}
