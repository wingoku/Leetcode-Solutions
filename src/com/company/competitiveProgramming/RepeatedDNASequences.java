package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepeatedDNASequences {
    //leetcode accepted
    //amazon
    public List<String> findRepeatedDnaSequences(String s) {
        int startPointer = 0;

        HashMap<String, Integer> countMap = new HashMap<>();
        List<String> output = new ArrayList<>();

        while(startPointer+10 <= s.length()) {
            String subString = s.substring(startPointer, startPointer++ + 10);
            int count = countMap.getOrDefault(subString, 0);
            count++;
            countMap.put(subString, count);
            if(count == 2) {
                output.add(subString);
            }
        }

        for(String st : output)
            System.out.println(st+", ");
        return output;
    }
}
