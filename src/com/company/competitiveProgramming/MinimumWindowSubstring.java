package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.HashSet;

public class MinimumWindowSubstring {
    //INPUT --> ADOBECODEBANC | FIND: ABC :: RESULT -> BANC

    public String findSmallestSubstring(String input, String toBeFound) {
        String smallestSubstring = "";
        int startPointer = -1;
        int endPointer = 0;
        int secondVariablePosition = 0;
//        int foundCharacters = 0;
        HashMap<Character, Integer> toBeFoundMap = new HashMap<>(toBeFound.length());
        HashMap<Character, Integer> foundCharactersMap = new HashMap<>(toBeFound.length());

        int indexOfFoundCharacter = -1;
        char currentCharacter = '-';
        char lastCharacter = '-';

        for(char c : toBeFound.toCharArray()) {
            if(toBeFoundMap.containsKey(c))
                toBeFoundMap.put(c, toBeFoundMap.get(c)+1);
            else
                toBeFoundMap.put(c, 1);
        }

        while(endPointer < input.length()) {
            currentCharacter = input.charAt(endPointer);
            indexOfFoundCharacter = toBeFound.indexOf(currentCharacter);
            if(indexOfFoundCharacter != -1) {

                if(startPointer == -1) {
                    startPointer = endPointer;
                }

                if(foundCharactersMap.get(currentCharacter) != null && foundCharactersMap.get(currentCharacter)+1 > toBeFoundMap.get(currentCharacter)
                        /*|| (lastCharacter == currentCharacter && foundCharacters == 1)*/) {
                    startPointer = endPointer;
                    foundCharactersMap.clear();
                    secondVariablePosition = 0;

                    foundCharactersMap.put(currentCharacter, 1);
//                    foundCharacters = 1;
                }
                else {
                    if(foundCharactersMap.containsKey(currentCharacter))
                        foundCharactersMap.put(currentCharacter, foundCharactersMap.get(currentCharacter)+1);
                    else
                        foundCharactersMap.put(currentCharacter, 1);

                    /*if(currentCharacter != lastCharacter)
                        foundCharacters++;*/

                    if (foundCharactersMap.size() == 2)
                        secondVariablePosition = endPointer;

                    if (foundCharactersMap.size() == toBeFound.length()) {

                        //if current found substring size is smaller than prev, update the minSubstring varaible
                        if((endPointer - startPointer) < smallestSubstring.length() || smallestSubstring.isEmpty())
                            smallestSubstring = input.substring(startPointer, endPointer+1);

                        startPointer = endPointer = secondVariablePosition;
                        secondVariablePosition = 0;
                        foundCharactersMap.clear();


                        foundCharactersMap.put(input.charAt(startPointer), 1);
//                        foundCharacters = 1;
                    }
                }
            }


            lastCharacter = currentCharacter;
            endPointer++;
        }

        return smallestSubstring;
    }

    //ADOBEAOCEBANC
        // --> possible substrings:
        //      ---> BEAOC
        //      ---> BANC

    //ascii for A-Z :: 65 - 90
    //ascii for a-z :: 97 - 172
    /*public void findSmallestSubstring(String input, String toBeFound) {
        //0.
        //1. we start iterating through the string
        //2. match each character & check if it's in FIND string
        //3. from first match till last match, we record string as key & last index of the matching character
        //4. until the first character match is found, we don't record the string in smallestSubstringWithFIND variables
        //5. check if current found substring < last found substring
        //6. if we're at the end of input string ELSE
        //7. start from 1 again

        //PROCESS:
            // convert FIND string in to a map

        int charsFoundSoFar = 0;
        HashMap<Character, Integer> defaultToBeFoundMap = new HashMap<>(toBeFound.length());
        for(int i=0; i<toBeFound.length(); i++) {
            defaultToBeFoundMap.put(toBeFound.charAt(i), -1);
        }

        HashMap<Character, Integer> toBeFoundMap = new HashMap<>(defaultToBeFoundMap);
        String smallestSubstring = "";

        for(int i=0; i<input.length(); i++) {
            if(toBeFoundMap.get(input.charAt(i)) == -1 && charsFoundSoFar < toBeFound.length()) {
                smallestSubstring += input.charAt(i);
            }
        }
    }*/

    //ADOBECODEBANC  //ABC
    /*public String findSmallestSubstring(String input, String find) {
        int start = 0;
        int foundLength = 0;
        String foundSubString = "";

        for(int i=0; i < input.length(); i++) {
            if(find.contains(""+input.charAt(i))) {
                if(foundLength == 0)
                    start = i;

                foundLength++;

                if(foundLength == find.length()) {
                    if(foundSubString.length() == 0 || i-start < foundSubString.length())
                        foundSubString = input.substring(start, i+1);
                    foundLength = 0;
                }
            }
        }
        return foundSubString;
    }*/

    //ADOBECODEBANC
    //i=0,end=3
    //ADO
    //i=1,end=4
    //DOB
    //i=2,end=5
    //OBE
    //i=3,end=6
    //BEC -----------> end(6) - firstFindIndex(0) = ADOBEC
    //i=4,end=7
    //ECO
    //i=5,end=8
    //COD
    //i=6,end=9
    //DEB
    //i=7,end=10
    //EBA ------------> end(10) - firstFindIndex(5) = CODEBA
    //i=8,end=11
    //BAN
    //i=9,end=12
    //ANC
    //i=10,end=13
    //return
   /* public String findSmallestSubstring(String input, String find) {
        String foundSubstring = "";
        int i=0;
        int end = find.length();
        int firstFindIndex = -1;
        int numberOfCharactersFound = 0;

        while(i<end) {
            char ch = input.charAt(i);
            if(find.contains(""+ch)) {
                if(numberOfCharactersFound == 0)
                    firstFindIndex = i;

                numberOfCharactersFound++;

                if(numberOfCharactersFound == find.length()) {
                    if(foundSubstring.length() == 0 || foundSubstring.length() > i - firstFindIndex) {
                        foundSubstring = input.substring(firstFindIndex, i+1);
                    }

                    firstFindIndex = i;
                    numberOfCharactersFound = 1;
                }
            }
            i++;

            if(end < input.length())
                end++;
        }
        return foundSubstring;
    }*/

   /* public String findSmallestSubstring(String input, String find) {
        String foundString = "";
        int i=0;
        int end = find.length();
        int stringStartIndex = -1;
        HashMap<Character, Integer> lookupMap = new HashMap<>(find.length());
        int foundSoFar = 0;
        char lastFoundChar = 0;
        String stringSoFar = "";

        while(end <= input.length()) {
            char ch = input.charAt(i);
            if(find.indexOf(ch) != -1) {
                *//*if(lookupMap.get(input.charAt(i)) == 1) {
                    lookupMap.clear();
                    stringStartIndex = i;
                }
                else*//*
                if(foundSoFar == 0)
                    stringStartIndex = i;

//                lookupMap.put(input.charAt(i), 1);
*//*
                if(lastFoundCharIndex != i) //skipping find of the same char cuz of sliding window
                    foundSoFar++;*//*

                if(lastFoundChar != input.charAt(i)) //skipping find of the same char cuz of sliding window
                    foundSoFar++;
                else
                    if(foundSoFar == 1)
                        stringStartIndex = i;

                lastFoundChar = input.charAt(i);

                if(!foundString.isEmpty() && foundString.length() <= i+1-stringStartIndex) {
                    i=stringStartIndex+1;

                    foundSoFar = 0;
                    lastFoundChar = 0;
                    stringStartIndex = -1;
                }

                if(foundSoFar == find.length()) {
                    if(foundString.isEmpty() || foundString.length() > i+1-stringStartIndex)
                        foundString = input.substring(stringStartIndex, i+1);
                    foundSoFar = 1;
                    lastFoundChar = input.charAt(i);
                    stringStartIndex = i;
                }
            }

//            stringSoFar = input.substring(stringStartIndex, i+1);
            i++;

            if(i==end) {
                i = end;

                if(end+find.length() < input.length())
                    end += find.length();
                else
                    end++;
            }

        }

        return foundString;
    }*/
}
