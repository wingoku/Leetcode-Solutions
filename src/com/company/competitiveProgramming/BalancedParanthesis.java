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
    //amazon coding interview
    /**
     THE IDEA IS TO CHECK

     for every opening bracket, there should be a closing bracket.

     It's easy to check this for opening and closing brackets next to each other however for cases like
     (())
     or
     (() ())

     it's difficult to match the closing bracket

     SOLUTION:

     The solution is to use STACKS

     We push every opening bracket & for every closing bracket we come across in the given string
     We check if the top of the stack has a corresponding opening bracket

     IF YES

     we pop from the stack.

     If not we continue the loop until the end of the string

     IF THE STRING HAS BALANCED PARENTHESIS, BY THE END OF THE LOOP THE STACK SHOULD BE EMPTY
     IF THE STACK IS NOT EMPTY THAT MEANS THE GIVE STRING DOESN'T CONTAIN BALANCED PARENTHESIS
     */

    public boolean isValid(String input) {
        return isBalanced(input);
    }
    //((()))
    private boolean isBalanced(String result) {

        if(result.isEmpty())
            return true;

        //if string's length is odd, that by default means the string contains unbalanced parenthesis cuz balance parenthesis
        //string should contain pairs which means for each opening, we have close hence the string length would be even
        if(result.length() % 2 != 0)
            return false;

        //if the string starts with a closing bracket, it's already an unbalanced parenthesis string.,
        if(result.charAt(0) == ')' || result.charAt(0) == '}' || result.charAt(0) == ']')
            return false;

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<result.length(); i++) {

            if(result.charAt(i) == '(' || result.charAt(i) == '{' || result.charAt(i) == '[') {
                stack.push(result.charAt(i));
                continue;
            }

            //THIS CONDITION IS FOR THIS CASE: "(){}}{"
            //the string has valid parenthesis until (){} however after that it's invalid
            //however by the time we reach } in the aforementioned string,
            //the stack would be empty & stack.peek would result in out of bound exception
            //therefore we've placed this condition here to make sure if the condition before this stack.size() condition didn't add
            //anything in the stack that means it's the start of unbalanced parenthesis in the string
            if(stack.size() == 0)
                return false;

            if(result.charAt(i) == ')' && stack.peek() == '('
                    ||
                    result.charAt(i) == '}' && stack.peek() == '{'
                    ||
                    result.charAt(i) == ']' && stack.peek() == '['
            )
                stack.pop();
            else
                break;
        }

        return stack.isEmpty();
    }
}
