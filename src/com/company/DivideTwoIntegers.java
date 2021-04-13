package com.company;

public class DivideTwoIntegers {
    //https://www.youtube.com/watch?v=V20qmx_l2-4&t=944s
    //TC: O(log N)
    public int divide(int dividnd, int divisr) {
        //(divisor * quotient > dividend)
        if(dividnd==Integer.MIN_VALUE && divisr==-1)
            return Integer.MAX_VALUE;

        boolean isNegative = false;

        long dividend = (long) dividnd;
        long divisor = (long) divisr;

        if(dividend < 0) {
            isNegative = true;
            dividend = ~dividend + 1;
        }

        if(divisor < 0) {
            if(!isNegative)
                isNegative = true;
            else
                isNegative = false;
            divisor = ~divisor + 1;
        }

        //27/7
        long result = 0;
        while(dividend >= divisor) {

            long tempDivisor = divisor;
            long quotient = 1;
            //find quotient
            while(dividend >= tempDivisor) {
                tempDivisor = tempDivisor << 1; //multiply by 2
                quotient = quotient << 1; //multiply by 2
            }

            dividend = dividend - (tempDivisor >> 1);//divide by 2
            quotient = quotient >> 1;//divide by 2
            result += quotient;
        }

        if(isNegative)
            result = ~result+1; //2's compliment

        return (int)result;
    }
}
