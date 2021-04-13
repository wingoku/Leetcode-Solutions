package com.company.competitiveProgramming;

public class AddBinary {
    //TC: O(N+M) cuz we're going through the characters of both strings
    //SC: O(N) cuz we're storing the results of each characters sum in substring
    public String addBinary(String a, String b) {

        int i = a.length() - 1;
        int j= b.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while(i >= 0 || j >= 0) {
            char c1 = '0';
            char c2 = '0';

            if(i >= 0) {
                c1 = a.charAt(i--);
            }

            if(j >= 0) {
                c2 = b.charAt(j--);
            }

            //converting characters into numbers for easier sum
            int sum = c1 - '0' + c2 - '0' + carry;
            carry = sum / 2; //dividing by 2 cuz the number system is binary as given in the question
            int remainder = sum % 2; //modding by 2 cuz the number system is binary in the question

            sb.append(remainder);
        }

        //cuz by the time we get out of the loop, we may have a carry by the sum of previous 1+1
        if(carry == 1)
            sb.append(carry);

        return sb.reverse().toString();
    }
}
