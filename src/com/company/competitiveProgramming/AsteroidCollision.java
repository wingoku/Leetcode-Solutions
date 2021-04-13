package com.company.competitiveProgramming;

import java.util.Stack;

public class AsteroidCollision {
    /**

     TEST CASES:
     [10, 2, -5]
     [10,-10,2,-5]
     [-2,2,-1,-2]
     [-2,2,-2,-1]
     [5, 10, -5]
     [8, -8]
     [-2, -1, 1, 2]
     */

    /**
     [5, 10, -5]
     [5, 10]

     [8, -8]
     []

     [10, 2, -5]
     [10]

     [-2, -1, 1, 2]
     [-2, -1, 1, 2]

     [-2,2,-1,-2]
     [-2]


     add positive numbers onto the stack
     if negative number comes along,
     run the loop till
     negative number is destroyed
     or
     stack becomes empty


     if negative number comes along when the stack is empty
     just add the number onto the stack

     */
    //leetcode 3ms
    //amazon, lyft coding interview
    //revise
    public int[] asteroidCollision(int[] ast) {

        Stack<Integer> stack = new Stack<>();
        boolean breakLoop = false;

        for(int i=0; i<ast.length; i++) {
            if(ast[i] > 0) {
                stack.push(ast[i]);
            }
            else {
                breakLoop = false;
                while(!breakLoop) {

                    if(!stack.isEmpty()) {

                        //if the element at the top of the stack is negative, there is no point in continuing this loop cuz
                        //that number and current number in ast[i], will never collide
                        if(stack.peek() < 0) {
                            breakLoop = true;
                            stack.push(ast[i]);
                        }
                        else
                        if(stack.peek() < -ast[i])
                            stack.pop(); //remove positive number from stack after collision
                        else
                            //both have equal mass, coming in opposite direction so both will be destroyed
                            if(stack.peek() == -ast[i]) {
                                breakLoop = true;
                                stack.pop();
                            }
                            else
                                //element at the top of the stack is bigger than negativeNumber/asteroid coming in opposite direction
                                //so it'll destroy the negative number and therefore we don't remove it from the stack
                                if(stack.peek() > -ast[i]) {
                                    breakLoop = true;
                                }
                    }

                    if(stack.isEmpty() && breakLoop == false) {
                        breakLoop = true;
                        stack.push(ast[i]);
                    }
                }
            }
        }

        int[] result = new int[stack.size()];

        int i = stack.size()-1;
        while(!stack.isEmpty()){
            result[i--] = stack.pop();
        }

        return result;
    }
}
