package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    //revise
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> combinations = new ArrayList<>();

        findCombinations(candidates, target, 0, combinations, new ArrayList<>());

        return combinations;
    }

    private void findCombinations(int[] candidates, int target, int currentIndex, List<List<Integer>> combinations, List<Integer> combination) {

        if(target == 0) {
            combinations.add(new ArrayList<>(combination));
            return;
        }

        if(target < 0)
            return;

        /**
         * In order to use the same number/repeat the number to get to the target, we call the findCombinations() with the same index
         * it keeps calling itself with the same number in recursive mode until 2 things happen
         *      either target == 0
         *      or     target < 0
         *
         *  in both cases, we return to the recursive call that's on top of the recursion stack & resume the execution of that recursive call
         *  When we return back to the recursive call, we end up at the combination.remove();
         *  we remove the item & than if i < candidates.length, we increment i, & call findCombination again with the next element
         *  So in case of when i = 0 i-e; the very first time we call call findCombinations from main(),
         *  it calls itself like
         *  2 -> 2,2 -> 2,2,2 -> 2,2,2,2 so far the value of i == 0, but now we've 4 recursive calls in the recursion stack. Our target becomes zero in the recursive call that's at the top of the stack
         *  & we return.
         *  Now we end up in the recursive call where combination list contains 2,2,2,2, we remove the last element from combination list, so it becomes 2,2,2 & than since we're inside the loop,
         *  we increment i, now i == 1,
         *  we call findCombinations with 2-3 it's 2 - 3 cuz we had already subtracted 2 three times till reaching this recusive call in the recursion stack,
         *  now since 2-3 ==  -1, we return back to the previous recursion call & remove the last element which is 3, increment i & call findCombinations recursively with 2-5 which again will be < 0
         *  so we return, now the value of i in this particular recursive call is == 3, which is == candidates.length so we get out of the loop & end up the recursion call that's on top of the stack,
         *  we remove 2 again so the combination list becomes 2,2 & now since we're inside the loop & value of i in this recursive call is == 0, we increment & try it with 4-3,
         *  we keep repeating this process for all the recursive calls & the new recursive calls that're made along the way
         *  that's how we find the combinations with repeating the same value + other values in the array (if needed) to find all the combinations.
         */
        for(int i=currentIndex; i<candidates.length; i++) {
            combination.add(candidates[i]);
            findCombinations(candidates, target-candidates[i], i, combinations, combination);
            combination.remove(combination.size()-1);
        }
    }
}
