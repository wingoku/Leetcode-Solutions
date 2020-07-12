package com.company.competitiveProgramming;


import java.nio.file.FileSystemNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 */

public class FindLongestSubstring {
    public void startMatch(String input) {
        System.out.println("input String: "+ input);

        int iterations = 5000;
        int length = -1;
        long total = 0;
//
        for(int i=0; i<iterations; i++) {
            long startTime = System.nanoTime();
            length = findMatch(input);
            long endTime = System.nanoTime() - startTime;
            total+= endTime;
        }

        System.out.println("-----> FIRST Time taken: "+ (total/iterations));

        long total2 = 0;
        for(int i=0; i<iterations; i++) {
            long startTime = System.nanoTime();
            length = secondTryAtFindingMatch(input);
            long endTime = System.nanoTime() - startTime;
            total2+= endTime;
        }

        System.out.println("-----> SECOND Time taken: "+ (total2/iterations));

        long total3 = 0;
        for(int i=0; i<iterations; i++) {
            long startTime = System.nanoTime();
            length = solutionFromLeetCode(input);
            long endTime = System.nanoTime() - startTime;
            total3+= endTime;
        }

        System.out.println("-----> LEETCODE SOLUTOIN Time taken: "+ (total3/iterations));

        long total4 = 0;
        for(int i=0; i<iterations; i++) {
            long startTime = System.nanoTime();
            length = fastestSolutoinFromLeetCode(input);
            long endTime = System.nanoTime() - startTime;
            total4+= endTime;
        }

        System.out.println("-----> FASTEST LEETCODE SOLUTOIN Time taken: "+ (total4/iterations));

        System.out.println("longest substring length: "+ length);
    }

    public int fastestSolutoinFromLeetCode(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public int solutionFromLeetCode(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    //accepted
    public int secondTryAtFindingMatch(String input) {
        int uniqueLength = 0;
        //anviaj
        //match: anvi or nviaj
        int firstDuplicateCharIndex =0;
        char character;
        int totalStringLength = input.length();
        Map<Character, Integer> unique = new HashMap<>(totalStringLength);
        for(int i=0; i<totalStringLength; i++) {
             character = input.charAt(i);
            if(!unique.containsKey(character)) {
                unique.put(character, i);

                if (uniqueLength < unique.size())
                    uniqueLength = unique.size();
            }
            else {
                firstDuplicateCharIndex = unique.get(character);
                if(unique.size() >  totalStringLength - firstDuplicateCharIndex)
                    break;

//                if(i-1 >=0 && character == input.charAt(i-1))
                {
                    i = firstDuplicateCharIndex; //we slide window to start from the position where last duplicate char lies
                    unique.clear();
                }

//                if(i+1 < input.length() && character != input.charAt(i+1))
//                    unique.put(character, i);
            }
        }

//        System.out.println("unique: "+ unique.toString());

        return uniqueLength;
    }

    //accepted
    /*public int secondTryAtFindingMatch(String input) {
        int uniqueLength = 0;
        int firstDuplicateCharIndex =0;
        char character;
        int totalStringLength = input.length();
        Map<Character, Integer> unique = new HashMap<>();

        for(int i=0; i<totalStringLength; i++) {
            character = input.charAt(i);
            if (!unique.containsKey(character)) {
                unique.put(character, i);

                if (uniqueLength < unique.size())
                    uniqueLength = unique.size();
            } else {
                firstDuplicateCharIndex = unique.get(character);
                if (unique.size() > totalStringLength - firstDuplicateCharIndex)
                    break;

                i = firstDuplicateCharIndex; //we slide window to start from the position where last duplicate char lies
                unique.clear();
            }
        }
        return uniqueLength;
    }*/

    public int findMatch(String input) {

        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (input.trim().length() == 0){
            return 1;
        }
        boolean longStringFound = false;
        int startIndex = 0;
        int previousUniqueSubstringLength = 1;
        HashSet<Character> uniqueSubstring = new HashSet<>();
        uniqueSubstring.add(input.charAt(startIndex));

        for(int i=startIndex; i<input.length() && !longStringFound; i++) {
            for(int j=i+1; j<input.length(); j++) {
                char character = input.charAt(j);
                if(!uniqueSubstring.contains(character)) {
                    uniqueSubstring.add(character);
                }
                else {
                    if(previousUniqueSubstringLength < uniqueSubstring.size()) {
                        previousUniqueSubstringLength = uniqueSubstring.size();
                    }

                    uniqueSubstring.clear();
                    //if j == str len break from both loops if
                    if(j>=input.length())
                        longStringFound = true;
                    //adding first entry after finding duplicate character in hashset
                    uniqueSubstring.add(input.charAt(i+1));
                    break;
                }
            }
        }

        if(previousUniqueSubstringLength < 2 && input.length() == 2 && input.charAt(0) != input.charAt(1)) {
            previousUniqueSubstringLength = 2;
        }

        if(uniqueSubstring.size() > previousUniqueSubstringLength)
            previousUniqueSubstringLength = uniqueSubstring.size();

        return previousUniqueSubstringLength;
    }


    //accepted version
    /*public int findMatch(String input) {

        System.out.println("input String: "+ input);
        long startTime = System.nanoTime();
        if (input == null || input.isEmpty()) {
            return 0;
        }

        if (input.contains(" ") && input.trim().length() == 0){
            return 1;
        }
        int startIndex = 0;
        int previousUniqueSubstringLength = 1;
        int currentUniqueSubstringLength = 0;
        String currentLongestSubstring = "";
        String prevLongestSubstring = "";
        HashSet<Character> uniqueSubstring = new HashSet<>();
        uniqueSubstring.add(input.charAt(startIndex));
        currentLongestSubstring += input.charAt(startIndex);

        for(int i=startIndex; i<input.length(); i++) {
            for(int j=i+1; j<input.length(); j++) {
                char character = input.charAt(j);
                if(!uniqueSubstring.contains(character)) {
                    uniqueSubstring.add(character);
                    currentLongestSubstring += character;
                }
                else {
                    if(previousUniqueSubstringLength < uniqueSubstring.size()) {
                        prevLongestSubstring = currentLongestSubstring;
                        previousUniqueSubstringLength = uniqueSubstring.size();
                    }

                    currentLongestSubstring = "";
                    uniqueSubstring.clear();
                    //if j == str len break from both loops if
                    //adding first entry after finding duplicate character in hashset
                    uniqueSubstring.add(input.charAt(i+1));
                    currentLongestSubstring += input.charAt(i+1);
                    break;
                }
            }
        }

        if(previousUniqueSubstringLength < 2 && input.length() == 2 && input.charAt(0) != input.charAt(1)) {
            previousUniqueSubstringLength = 2;
            prevLongestSubstring = input;
        }

        if(uniqueSubstring.size() > previousUniqueSubstringLength)
            previousUniqueSubstringLength = uniqueSubstring.size();


        long endTime = System.nanoTime() - startTime;
        System.out.println("longest substring length: "+ prevLongestSubstring + " current length: "+ previousUniqueSubstringLength);
        System.out.println("Time taken: "+ endTime);
        return previousUniqueSubstringLength;
    }*/

    //working versoin
    /*public void findMatch(String input, int startIndex, int endIndex) {

        long startTime = System.nanoTime();
        //input = "abcabcbb"
        String currentLongestSubstring = "";
        String prevLongestSubstring = "";
        HashSet<Character> uniqueSubstring = new HashSet<>();
        uniqueSubstring.add(input.charAt(startIndex));
        currentLongestSubstring += input.charAt(startIndex);

        for(int i=startIndex; i<input.length(); i++) {
            for(int j=i+1; j<input.length(); j++) {
                if(!uniqueSubstring.contains(input.charAt(j))) {
                    uniqueSubstring.add(input.charAt(j));
                    currentLongestSubstring += input.charAt(j);
                }
                else {
                    if(prevLongestSubstring.length() < currentLongestSubstring.length())
                        prevLongestSubstring = currentLongestSubstring;

               *//*     // if the current substring doesn't have duplicate character at j+1
                    if(j+1 < input.length() && !uniqueSubstring.contains(input.charAt(j+1))) {
                        startIndex = j;
                    }
*//*
                    currentLongestSubstring = "";
                    uniqueSubstring.clear();

                    //adding first entry after finding duplicate character in hashset
                    uniqueSubstring.add(input.charAt(startIndex+1));
                    currentLongestSubstring += input.charAt(startIndex+1);
                    break;
                }
            }
        }

        long endTime = System.nanoTime() - startTime;
        System.out.println("longest substring: "+ prevLongestSubstring);
        System.out.println("Time taken: "+ endTime);
    }*/
}
