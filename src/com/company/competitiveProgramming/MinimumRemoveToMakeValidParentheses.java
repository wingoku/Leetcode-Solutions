package com.company.competitiveProgramming;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
    //lee(t(c)o))de)

    /**
     The idea is to save the index of parentheses
     1. If we come across (, we just push its index on to the stack
     2. If we come across ), we check if the index at the top of the stack correlates with ( in the string,
     a. if yes, we pop the index off the stack
     b. If not or if the stack was empty in the first place, we just push this ) index on the stack

     Afterwards we loop over the string from right to left cuz stack always keeps the index of the currently push value at the top
     which in case of the string would the index some where from the right side

     We go through the string in reverse order and check if the current index of the loop matches the index at the top of the stack,
     if yes, we pop the stack and we don't do anything else in the loop
     otherwise, we add the current character into the stringBuilder

     Once we're done with this loop, sb will contain our input string in reverse order without invalid parenthesis, therefore we reverse it and return the string
     */

    //TC: O(N)
    public String minRemoveToMakeValid(String s) {

        return balance(s);
    }

    //
    private String balance(String s) {
        Stack<Integer> stack = new Stack();

        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(')
                stack.push(i);
            else
            if(c == ')') {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else
                    stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {

            if(!stack.isEmpty() && i == stack.peek()) {
                stack.pop();
                continue;
            }
            else
                sb.append(s.charAt(i));
        }

        return sb.reverse().toString();
    }
}
