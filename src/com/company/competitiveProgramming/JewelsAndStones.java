package com.company.competitiveProgramming;

public class JewelsAndStones {

    //leetcode accepted
    //amazon coding interview
    //TC: O(J*S)
    //SC: O(1)
    public int numJewelsInStones(String J, String S) {
        if(J == null || J.isEmpty() || S == null || S.isEmpty())
            return 0;

        int[] asciiArray = new int[256];

        for(int i=0; i<S.length(); i++)
            asciiArray[S.charAt(i)]++;

        int jewelCount = 0;

        for(int i=0; i<J.length(); i++)
            jewelCount += asciiArray[J.charAt(i)];

        return jewelCount;
    }
}
