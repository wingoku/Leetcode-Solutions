package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {

    //leetcode accepted
    //revise
    //backtracking
    //amazon coding interview
    //AMAZING EXPLAINATION: https://www.youtube.com/watch?v=EPgfr_jTjA8
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        if(candidates == null || candidates.length == 0)
            return null;

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        findCombinations(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    //[1,1*,2,5,6,7,10]
    /**
     1,1,6
     1,2,5
     1,7
     1*,2,5
     */
    private void findCombinations(int[] candidates, int target, int currentIndex, List<Integer> currentResult, List<List<Integer>> results){

        if(target == 0) {
            results.add(new ArrayList<>(currentResult));
            return;
        }

        if(target < 0)
            return;

        for(int i=currentIndex; i<candidates.length; i++) {
            //sorted array: //[1,1*,2,5,6,7,10] 1* has * to make it easy to identify which of the 1s is used to create the combination
            //the condition i>currentIndex is added cuz when we want to check if current candidate element is similar to its adjecent previous
            //candidate element, it'll create duplicate subsets/combinations
            //Eg. when our currentIndex = 0, subsets/combinations to find 8 with respect to 1
            //1,1*,6
            //1,2,5
            //1*,2,5
            //we can't create anymore combinations using 1 as the beginning, so the loops inside the recursive calls will try to generate
            //other combinations with different starting elements
            //Let's come back to the combinations generated from the very first loop in the recursion that's when currentIndex = 0
            //we can see we've a duplicate set 1,2,5
            //in order to avoid it, we add the condition that
            //for the loop starting at an index currentIndex, if its next adjecent element is the same than it'll generate duplicate subsets
            // therefore we just ignore that element once the loop increments & index is now pointing to currentIndex+1

            //if we had i>0 condition that what'd happen is
            //the recursive call where the loop starts from 1 i-e; currentIndex = 1,
            // candidates[i] == candidates[i-1] conditino will still be checked which we don't want to cuz the combination 1,1,6 won't be created cuz this combination is created when the loop starting at currentIndex = 0 recursively calls findCombinations() & inside that recursive call, the loop starts at 1 & than it creates the 1,1,6 combination.
            //CONCLUSION:
            //we only want to avoid duplicates in the linear execution of the loop NOT inside the loops that're inside the recursive calls
            if(i > currentIndex && candidates[i-1] == candidates[i]) {
                // System.out.println("currentIndex: "+currentIndex +" i: "+ i + " cand[i-1]: "+ candidates[i-1] + " cand[i]: "+ candidates[i]);
                continue;
            }

            currentResult.add(candidates[i]);
            findCombinations(candidates, target-candidates[i], i+1, currentResult, results);
            currentResult.remove(currentResult.size()-1);
        }

        return;
    }
}
