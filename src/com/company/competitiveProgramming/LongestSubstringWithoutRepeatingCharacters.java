package com.company.competitiveProgramming;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    //TC: O(N) cuz we're visiting & adding each character in the set 1 time
    //SC: (N)
    //revise
    public int lengthOfLongestSubstring(String input) {
        if(input == null || input.isEmpty())
            return 0;

        Set<Character> set = new HashSet<>();

        int i = 0;
        int j = 0;

        int maxLength = 0;

        //consider example "anviaj"
        //it's when i = 0 & j = 4
        //when we come across our first duplicate 'a'
        //we remove character from the set until existing 'a' is removed from the set
        //after this loop, i = 1, j is still 4 and we keep incrementing j till input.length()


        //NOTE:
        //if we were to do set.clear() in else clause and reset j to i i-e; j=i,
        //we'd be iterating over the characters we already visited again
        //in worst case, our TC would be close to N^2 cuz we'll be visiting
        //every other character twice
        while(j < input.length()) {
            char c = input.charAt(j);

            //if set doesn't contain current character, add it to the set
            if(!set.contains(c))
                set.add(c);
            else {

                //we came across the first duplicate character
                //so before we add this character to the set
                //calculate the current size of set which gives us
                //the length of current substring
                maxLength = Math.max(maxLength, set.size());

                //since the set contained character C in it
                //that's why we ended up in this else clause
                //we've to remove all the character from index i till the Set no
                //longer has the character c
                while(set.contains(c)) {
                    set.remove(input.charAt(i));
                    i++;
                }

                //now that we've remove the prev character which was = c
                //let's add c to the set cuz from here we start calculating the length of new substring
                set.add(c);
            }

            j++;
        }

        //cuz before the end of the loop, if we didn't go into else clause, we won't have the current potential max
        return Math.max(maxLength, set.size());
    }
}
