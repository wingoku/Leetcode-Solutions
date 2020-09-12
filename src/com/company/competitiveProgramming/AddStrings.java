package com.company.competitiveProgramming;

public class AddStrings {
    public String addStrings(String number1, String number2) {
        StringBuilder sb = new StringBuilder();

        char[] n1 = number1.toCharArray();
        char[] n2 = number2.toCharArray();

        int i = n1.length-1;
        int j = n2.length-1;

        int carry = 0;
        int sum = 0;
        int remainder = 0;
        while(i >= 0 || j >= 0) {
            int num1 = 0;
            int num2 = 0;

            if(i>=0) {
                num1 = n1[i--] - '0';
            }

            if(j>=0) {
                num2 = n2[j--] - '0';
            }

            sum = num1 + num2 + carry;
            carry = sum/10;
            remainder = sum % 10;

            sb.append(remainder);
        }

        if(carry > 0)
            sb.append(carry);

        return sb.reverse().toString();
    }
}
