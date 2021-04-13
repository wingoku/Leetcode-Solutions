package com.company.competitiveProgramming;

public class LongestCommonPrefix {
    /**
     The idea is to compare 2 strings at a time
     We compare string i with i-1 by iterating over both strings
     if characters in each string at index j are same we increment a count
     if they're not the same, we get out of the j loop and find the min matching characters
     we've had so far. We we do min cuz the smallest amount of matching charcters among string is the common prefix


     */
    //TC: O(2n * m) where N is the number of words and we've 2n cuz we're touching each string twice except for the very first string
    //the given array and very last string in the given array
    //and m is the number of similar characters among 2 strings. In worst case, all the characters between 2 strings match so time complexity
    //would be a total of m for each string where m is the number of characters in each string
    //amazon coding interview
    //leetcode 1ms
    public String longestCommonPrefix(String[] strs) {

        if(strs.length == 0)
            return "";

        if(strs.length == 1)
            return strs[0];

        // System.out.println("substring: "+ "hello".substring(0,2));

        int count = 0;
        int minCount = Integer.MAX_VALUE;
        for(int i=1; i<strs.length; i++) {
            // System.out.println("checking string: "+ strs[i]);
            count = 0;
            for(int j=0; j<strs[i-1].length() && j<strs[i].length(); j++) {
                // System.out.println("string: "+ strs[i-1].charAt(j) + " - "+ strs[i].charAt(j));
                if(strs[i-1].charAt(j) != strs[i].charAt(j))
                    break;
                count++;
            }

            //because the minCount contains the real number of characters that're common prefix among all the given strings.
            minCount = Math.min(minCount, count);
            // System.out.println("count: "+ count + " minCount: "+ minCount);
        }

        // System.out.println("substring: "+ strs[0].substring(0, minCount));

        return strs[0].substring(0, minCount);
    }

}
