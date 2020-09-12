package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfPhoneNumber {
    //done with recursion. Concept is tree
    //leetcode accepted
    //amazon coding interview
    public List<String> letterCombinations(String digits) {

        if(digits == null || digits.isEmpty())
            return new ArrayList<>();

        String[] numpad = new String[] {"0","1","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        List<String> combinations = new ArrayList<>();
        getCombinations(combinations, numpad, "", digits, 0);

        return combinations;
    }

    private void getCombinations(List<String> combinations, String[] numpad, String currentCombination, String givenDigits, int givenDigitsStringIndex) {

        if(givenDigitsStringIndex >= givenDigits.length()) {
            combinations.add(currentCombination);
            return;
        }

        //we get the digit from givenDigit string
        int phonePadIndex = givenDigits.charAt(givenDigitsStringIndex) - '0'; // -'0' converts string into integer

        /**
         *  This loop will call getCombinations recursively
         * We get the currentCombination which is EMPTY when we first call getCombination() from letterCombinations()
         * Than we concat the currentCombination with each character for the given numpad number that's at index givenDigitStringIndex
         *
         * MEANING
         * in the beginning,
         *      currentCombination = "",
         *      givenDigitsStringIndex = 0,
         *      giveDigits = "the value that's given to the letterCombination()"
         *
         * We come in the loop, we take each character for the current digit on the numpad,
         * concat it with the currentCombination & call getCombinations() again
         * So if givenDigits = "23"
         *
         * we need to concat 2 (a,b,c) with 3(e,f,g)
         *
         * so it's like
         *
         * givenDigits.charAt(givenDigitsStringIndex) - '0' will give us 2
         *
         * Than we get 'a' from the numpad[],
         * we concat a with currentCombination which is empty in the beginning => temp = a
         * we add 1 givenDigitsStringIndex so now we can combine a with characters that are available for 3(d,e,f) on numpad
         *
         * Now we're inside getCombinations again
         *                  currentCombination = "a",
         *                  givenDigitsStringIndex = 1,
         *                  giveDigits = "the value that's given to the letterCombination()"
         *
         * givenDigits.charAt(givenDigitsStringIndex) - '0' will give us 3
         *
         * we start loop, we get the first character for 3, which is d
         * we call getCombinations again
         * getCombinations(combinations, numpad, "ad", givenDigits, 1+1)
         *
         * we get back in the method & now we hit the base condition if(givenDigitsStringIndex >= givenDigits.length())
         * we add 'ad' in the combinationsList & return
         * Than we call getCombinations again
         * since we're back in the previous call of getCombination where we left off the execution which is inside the loop iterating over 2(a,b,c)
         * variables are
         *                  currentCombination = "a",
         *                  givenDigitsStringIndex = 1,
         *                  giveDigits = "the value that's given to the letterCombination()"
         * getCombinations(combinations, numpad, "ab", givenDigits, 1+1)
         *
         * This way we get all the combinations
         */
        for(int i=0; i<numpad[phonePadIndex].length(); i++) {
            String temp = currentCombination + numpad[phonePadIndex].charAt(i);
            getCombinations(combinations, numpad, temp, givenDigits, givenDigitsStringIndex+1);
        }
    }
}
