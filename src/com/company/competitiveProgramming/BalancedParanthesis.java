package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.Stack;

public class BalancedParanthesis {

    //ascii codes
    // { - 123
    // } - 125
    // ( - 40
    // ) - 41
    // [ - 91
    // ] - 93

    // { 123 ( 40 [91

    //accepted solution: faster than 98.79%
    public boolean isBalanced(String input) {
        if(input.isEmpty())
            return true;

        if(input.length() % 2 != 0 || input.charAt(0) == '}'|| input.charAt(0) == ')'|| input.charAt(0) == ']')
            return false;

        Stack<Character> stack = new Stack<>();
        char currentChar = 0;

        for(int i=0; i<input.length(); i++) {
            currentChar = input.charAt(i);
            if(currentChar == '{' || currentChar == '(' || currentChar == '[') {
                stack.push(input.charAt(i));
                continue;
            }

            int diff = stack.peek() - currentChar;

            // checking if diff == -2 or diff == -1 cuz when ascii numbers of {} () [] are subtracted like }-{ gives us -2, ]-[ gives us -2, )-( gives us 1
            if(diff == -2 || diff == -1) {
                stack.pop();
            }
            else
                // cuz if the character from the top of stack doesn't match the current character, it's the start of imbalance & no need to continue with further analysis & running loop
                return false;
        }

        if(stack.isEmpty()) {
            System.out.println("string is balanced");
        }
        else
            System.out.println("string is NOT balanced");

        return stack.isEmpty();
    }
}
