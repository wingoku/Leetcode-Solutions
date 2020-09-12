package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    //my own solution
    //leetcode 15ms
    //amazon coding interview
    public List<String> generateParenthesisUmersSolution(int n) {
        /*
            This is a backtracking problem
            because we don't know the combinations that're possible
            and we don't know how many combinations are satisfying the given contraints - the given constraint in this case is BALANCED PARENTHESES
        */

        List<String> combinations = new ArrayList<>();

        backtracking(n, "", combinations);

        return combinations;
    }

    private void backtracking(int n, String paranthesis, List<String> combinations) {

        if(paranthesis.length() == n*2) {
            if(isBalanced(paranthesis)) {
                combinations.add(paranthesis);
            }

            return;
        }
        //WHY DIDN'T WE USE LOOP OVER THESE RECURSION CALLS?
        //BECAUSE
        //RECURSION ITSELF IS A LOOP
        //AND THE REAL REASON IS, HERE WE'RE NOT DEALING WITH GENERATING COMBINATIONS
        //BASED ON AN INPUT ARRAY.
        //WHEN WE'RE GIVEN AN INPUT ARRAY TO GENERATE COMBINATIONS THAN IT BECOMES NECESSARY AT TIMES TO HAVE LOOP AROUND RECURSIVE CALLS
        //LIKE WE DID IN COMBINATION SUM & SUBSET PROBLEMS
        backtracking(n, paranthesis+"(", combinations);
        backtracking(n, paranthesis+")", combinations);
    }

    //TO AVOID CHECKING IF GENERATED PARENTHESIS ARE VALID OR NOT USING THIS FUNCTION
    // WE CAN ALSO USE THE TRICK LIKE WE'VE IN THE SOLUTION AT THE BOTTOM OF THIS FILE
    private boolean isBalanced(String result) {

        if(result.isEmpty())
            return true;

        if(result.length() % 2 != 0)
            return false;

        if(result.charAt(0) == ')')
            return false;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<result.length(); i++) {

            if(result.charAt(i) == '(') {
                stack.push(result.charAt(i));
                continue;
            }

            if(stack.size() == 0)
                return false;

            if(result.charAt(i) == ')' && stack.peek() == '(')
                stack.pop();
            else
                break;
        }

        return stack.isEmpty();
    }

    //leetcode accepted
    //revise
    //backtracking
    //based on nick white video: https://www.youtube.com/watch?v=qBbZ3tS0McI
    //amazon coding interview
    public List<String> generateParenthesis(int n) {
        /*
            This is a backtracking problem
            because we don't know the combinations that're possible
            and we don't know how many combinations are satisfying the given contraints - the given constraint in this case is BALANCED PARENTHESES
        */

        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);

        return result;
    }

    private void backtrack(List<String> result, String currentString, int leftCount, int rightCount, int maxParentheses) {
        if(currentString.length() == maxParentheses * 2) { //maxParentheses * 2 cuz maxParentheses contains only the count for pairs NOT the count of individual parenthesis

            System.out.println("-------------->"+currentString);
            result.add(currentString);
            return;
        }

        System.out.println(currentString);

        if(leftCount < maxParentheses)
            backtrack(result, currentString+"(", leftCount+1, rightCount, maxParentheses);

        if(rightCount < leftCount) //cuz number of right parentheses MUST match the count of left parentheses
            backtrack(result, currentString+")", leftCount, rightCount+1, maxParentheses);
    }

}
