package com.company.competitiveProgramming;

public class AddStrings {
    public String addStrings(String number1, String number2) {
        StringBuilder sb = new StringBuilder();

        //how do we calculate the sum of 2 integer numbers?
        //we start from summing the right most numbers
        //eg. we're given a number: 15 5
        //we get a sum of those two numbers and we may get a carry eg. 5+5
        //we take that carry and use it to in the sum of the next two numbers. now the sum would be 1+1(1 is the carry)
        //we do the same process here

        char[] num1Array = number1.toCharArray();
        char[] num2Array = number2.toCharArray();

        int carry = 0;
        int i = num1Array.length-1, j = num2Array.length-1;

        while(i >= 0 || j >= 0) {

            int n1 = 0; //converting character into integer
            int n2 = 0;

            if(i >= 0)
                n1 = num1Array[i--] - '0'; //converting character into integer

            if(j >= 0)
                n2 = num2Array[j--] - '0';

            int sum = n1 + n2 + carry;

            int remainder = sum % 10;
            carry = sum / 10;

            sb.append(remainder);
        }

        //carry will always be either 0 or 1 cuz that's how carry's work in normal mathematics
        if (carry == 1)
            sb.append(carry);

        return sb.reverse().toString();
    }
}
