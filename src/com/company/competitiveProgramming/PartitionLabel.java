package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabel {
    //amazon coding interview
    //leetcode accepted
    //O(n) solution
    public List<Integer> partitionLabels(String S) {
        List<Integer> sizes = new ArrayList<>();

        int[] lastIndex = new int[26]; //cuz only lower case letters will be given to us

        //finding the lastIndexes of all the characters in the given string so that inside the loop start->end, we don't have to
        //do S.lastIndexOf('someCharacter') over & over cuz if we do that than the solution will be O(n^2) cuz string.lastIndexOf loops
        //through the string everytime it needs to find the last occurance & if the character happens to be at the end of the string
        //than it'll string.lastIndexOf would have to loop through the entire string over and over inside the start->end loop
        for(int i=0; i< S.length(); i++) {
            //subtracting the current character from a that's how we can map the lower case letters to an array of 26 Eg. 'a' -'a' = 0, 'b' -'a' = 1 so on and so forth. Otherwise we can also use an array of length 128 and loop from 97->122 but the array slots from 0->97 & 123->128 will be taking memory for nothing
            lastIndex[S.charAt(i) - 'a'] = i;
        }

        int start=0, end = 0, extendedEnd = 0;
        while(start < S.length()) {
            char startCharacter = S.charAt(start);
            end = lastIndex[startCharacter - 'a'];
            extendedEnd = end;

            for(int i=start; i<end; i++) {

                //checking if the current character that lies in the window start till end has last occurance index that's greater than current end, than we extend end.
                //NOTE: if we don't check the occurance like lastIndex[S.charAt(i)- 'a'] instead we check it like lastIndex[i], we won't be getting correct answer cuz lastIndex[] contains last occurances of characters from a-z
                //the characters in String S might not occur in the order a-z. They'll be jumbled across the string.
                //therefore in order to get the last occurance of current character, we do it like lastIndex[S.charAt(i)- 'a']
                if(lastIndex[S.charAt(i)- 'a'] > end) {
                    extendedEnd = lastIndex[S.charAt(i)- 'a'];
                    end = extendedEnd;
                }
            }

            sizes.add((extendedEnd - start + 1));
            start = extendedEnd + 1;
        }

        return sizes;
    }

    //O(n^2) solution cuz of doing S.lastIndexOf() inside the loop
    public List<Integer> partitionLabelsSlow(String S) {
        List<Integer> sizes = new ArrayList<>();

        boolean endReached = false;

        int start=0, end, extendedEnd;

        while(start < S.length()) {
            char startCharacter = S.charAt(start);
            end = S.lastIndexOf(startCharacter);
            extendedEnd = end;

            for(int i=start; i<end; i++) {

                if(S.lastIndexOf(S.charAt(i)) > end) {
                    extendedEnd = S.lastIndexOf(S.charAt(i));
                    end = extendedEnd;
                }
            }

            sizes.add((extendedEnd - start + 1));
            start = extendedEnd + 1;
        }

        return sizes;
    }
}
