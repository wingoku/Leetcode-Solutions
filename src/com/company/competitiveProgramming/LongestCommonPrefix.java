package com.company.competitiveProgramming;

public class LongestCommonPrefix {
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
