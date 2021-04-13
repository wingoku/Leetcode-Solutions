package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();

        findCombinations(num, 0, target, "", 0, 0);

        return result;
    }
    /**
     1 + 2 + 3
     1 + 2 - 3 --- x
     1 + 2 * 3 ----x

     1 - 2 + 3 ----x
     1 - 2 - 3 ----x
     1 - 2 * 3 ----x

     1 * 2 + 3 ----x
     1 * 2 - 3 ----x
     1 * 2 * 3 ----x


     1 + 0 + 5 ----x
     1 + 0 - 5 ----x
     1 + 0 * 5 ----x

     1 - 0 + 5 ----x
     1 - 0 - 5 ----x
     1 - 0 * 5 ----x

     1 * 0 + 5
     1 * 0 - 5 ----x
     1 * 0 * 5 ----x

     1002
     */

    private void findCombinations(String nums, int index, int target, String stringSoFar, long sumSoFar, long lastNumAddedToSum) {

        System.out.println("string: "+ stringSoFar);
        if(index >= nums.length()) {


            if(sumSoFar == target) {
                System.out.println("sumSoFar: "+ sumSoFar);
                result.add(stringSoFar);
            }

            return;
        }
        //1005
        for(int i=index; i<nums.length(); i++) {

            if(i != index && nums.charAt(i-1) == '0')
                break;

            String curSubstring = nums.substring(index, i+1);
            long curNum = Long.parseLong(curSubstring);

            if(index == 0) {
                findCombinations(nums, i+1, target, curSubstring, sumSoFar + curNum, curNum);
            }
            else {
                findCombinations(nums, i+1, target, stringSoFar+ "+" +curSubstring, sumSoFar + curNum, curNum);
                findCombinations(nums, i+1, target, stringSoFar+ "-" +curSubstring, sumSoFar - curNum, -curNum);

                long currMultNum = lastNumAddedToSum * curNum;

                long multResultSoFar = (sumSoFar - lastNumAddedToSum) + currMultNum;

                findCombinations(nums, i+1, target, stringSoFar+ "*" +curSubstring, multResultSoFar, currMultNum);
            }
        }
    }
}
