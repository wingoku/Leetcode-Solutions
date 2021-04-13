package com.company.competitiveProgramming;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
    /**
     Symbol       Value
     I             1
     V             5
     X             10
     L             50
     C             100
     D             500
     M             1000

     In roman numbers all the exception cases
     i-e;
     4 - IV
     9 - IX
     40 - XL
     90 - XC
     400 - CD
     900 - CM

     when a small roman number is before the large roman number, THAT'S AN EXCEPTION as can be seen in the representation above
     When charAt(i) < charAt(i+1) than we just need to subtract charAt(i+1) from charAt(i)
     and add it into the result.
     */

    //inspired from: https://www.youtube.com/watch?v=9rfe5nXL05Q
    //TC: O(N)
    //SC: O(1) cuz we've always 7 exception cases added in the map
    public int romanToInt(String s) {

        if(s == null || s.length() == 0)
            return 0;

        Map<Character, Integer> map = new HashMap<>();

        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int i=0;
        for(i=0; i<s.length()-1; i++) {
            if(map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                result += map.get(s.charAt(i+1)) - map.get(s.charAt(i));
                i++;
            }
            else
                result += map.get(s.charAt(i));
        }

        //in case we had a number III, the loop above would run for index, 0 & 1 when i = 2, it'll get out of the loop
        //leaving the I at index 2 un calculated, therefore we add it here
        if(i < s.length())
            result += map.get(s.charAt(i));

        return result;
    }


    //working but a bit naive way:
    public int romanToInt_NaiveWay(String s) {

        if(s == null || s.length() == 0)
            return 0;

        int result = 0;
        int i = 0;
        for(i=0; i<s.length()-1; i++) {
            if(s.charAt(i) == 'I' && s.charAt(i+1) == 'V') {
                result += 4;
                i++;
            }
            else
            if(s.charAt(i) == 'I' && s.charAt(i+1) == 'X') {
                result += 9;
                i++;
            }
            else
            if(s.charAt(i) == 'X' && s.charAt(i+1) == 'L') {
                result += 40;
                i++;
            }
            else
            if(s.charAt(i) == 'X' && s.charAt(i+1) == 'C') {
                result += 90;
                i++;
            }
            else
            if(s.charAt(i) == 'C' && s.charAt(i+1) == 'D') {
                result += 400;
                i++;
            }
            else
            if(s.charAt(i) == 'C' && s.charAt(i+1) == 'M') {
                result += 900;
                i++;
            }
            else
                result += getDecimal(s.charAt(i));
        }

        if(i < s.length())
            result += getDecimal(s.charAt(i));

        return result;
    }

    private int getDecimal(char c) {
        int decimal = 0;

        switch(c) {
            case 'I':
                decimal = 1;
                break;
            case 'V':
                decimal = 5;
                break;
            case 'X':
                decimal = 10;
                break;
            case 'L':
                decimal = 50;
                break;
            case 'C':
                decimal = 100;
                break;
            case 'D':
                decimal = 500;
                break;
            case 'M':
                decimal = 1000;
                break;
        }
        return decimal;
    }
}
