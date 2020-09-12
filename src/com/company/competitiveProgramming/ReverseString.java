package com.company.competitiveProgramming;

public class ReverseString {
    //leetcode accepted
    //recursion
    //in space reversing
    //TC: O(n/2)
    //SC: O(1)
    public void reverseString(char[] s) {
        reverseStringArray(s, 0);
    }

    //Input: ["h","e","l","l","o"]
    //Output: ["o","l","l","e","h"]
    private void reverseStringArray(char[] s, int index) {
        //because swapping only happens till the very mid of the array. If we go past that than
        //we will unreverse the array again
        if(index >= s.length/2)
            return;

        //get the corresponding item from the end of the array based on the s.length-1-index formula
        //s.length = 6
        //if we want to swap h with o,
        //we swap the value at s.length-1-index-> 6-1-0 = 5 with value at index
        //so for h & o it becomes
        //swap(valueAt(5) with valueAt(0))
        //after swapping we move on to the next element in the array
        //we DO IT USING RECURSION by calling the same method with incremented index
        char temp = s[s.length-1-index];
        s[s.length-1-index] = s[index];
        s[index] = temp;
        reverseStringArray(s, index+1);
    }
}
