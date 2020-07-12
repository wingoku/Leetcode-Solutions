package com.company.competitiveProgramming;

public class ReverseInteger {
    public int reverseInteger(int input) {
        long reverseInteger = 0;
        long remaineer = 0;

        while(input != 0) {
            remaineer = input % 10; // modulo returns the remainder i-e; digit after decimal in float answer when input/10
            input = input/10; // divide by 10 and storing the result in INT strips the remainder i-e; digit after decimal in float answer when input/10
            reverseInteger = reverseInteger * 10 + remaineer; // we're multiplying the reversed integer with 10 & than adding the remainder cuz we want the remainder to always be in the second position
            // so for example input: 319
            // 1. reverse = 0, remainder = 9
            // ---> reverse = 0 * 10 + 9 = 9
            // 2. reverse = 9, remainder = 1,
            // ---> reverse = 9 * 10 + 1 = 90 + 1 = 91
            // 3. reverse = 91, remainder = 3,
            // ---> reverse = 91 * 10 + 3 = 910 + 3 = 913
        }
        if(reverseInteger > Integer.MAX_VALUE || reverseInteger < Integer.MIN_VALUE) {
            System.out.println("overflowed");
            return 0;
        }

        System.out.println("Reverse integer: "+ reverseInteger);
        return (int)reverseInteger;
    }
   /* public int reverseInteger(int input) {
        System.out.println("input is: "+ input);

        long reverseInteger = 0;
        long remaineer = 0;
        int i=0;
        boolean negativeNumber = false;

        negativeNumber = input<0;

        input = Math.abs(input);

        int n=306;
        int one=(n/1)%10;
        int tens= (n/10)%10;
        int hundred = (n/100)%10;
        int thousand = (n/1000)%10;

        long domain = log10(input);
        System.out.println("Domain is: "+ domain);
        while (i <= domain) {
            remaineer = (int) (input / Math.pow(10, i++)) % 10;
            reverseInteger = reverseInteger * 10 + remaineer;
            if(i==domain && remaineer == 0)
                break;

        }
        System.out.println("Reverse integer: "+ reverseInteger);
        reverseInteger = negativeNumber ? -reverseInteger : reverseInteger;
        if(reverseInteger > Integer.MAX_VALUE || reverseInteger < Integer.MIN_VALUE) {
            System.out.println("overflowed");
            return 0;
        }
        return (int)reverseInteger;
    }

    private long log10(int n){
        return Math.round(100*Math.log(n)/Math.log(10))/100;
    }*/
}
