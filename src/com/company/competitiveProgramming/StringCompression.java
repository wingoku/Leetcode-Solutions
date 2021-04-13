package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringCompression {
    /*
      globalCounter = 0
      charCount = 0
      currentCharFreqCount = 0
      iterate over the charArray

          if currChar == lastChar and lastChar != empty
              charCount++
          else
              globalCounter += 1

              if currentCharFreqCount is > 10
                  divide the counter in loop until the remainder < 1
                  add the loop iterations to the globalCounter
              else
                  if currentCharFreqCount > 1
                      globalCounter += 1;

              currentCharFreqCount = 1


      lastChar = current

      */

    //leetcode 1ms
    //amazon coding interview
    //this solution is not in O(1) complexity for that see Kevin naughtons video
    public int compress(char[] chars) {
        if(chars.length == 1)
            return 1;

        int currentCharFreqCount = 0;
        char lastChar = 0;
        List<Character> result = new ArrayList<>();

        //a,a,b (gc=2),b,c (gc=4), c,c (gc=6)
        for(int i=0; i<chars.length; i++) {
            if(i==0 || lastChar == chars[i])
                currentCharFreqCount++;
            else {
                modifyArray(result, lastChar, currentCharFreqCount);
                currentCharFreqCount = 1;
            }

            lastChar = chars[i];
        }

        //cuz for the last digit the ABOVE else clause won't be run so we've to add the collected info for that character and add it to the list.
        modifyArray(result, lastChar, currentCharFreqCount);

        for(int i=0; i<result.size(); i++) {
            chars[i] = result.get(i);
        }

        return result.size();

    }

    private void modifyArray(List<Character> result, char c, int counter) {
        result.add(c);

        if(counter > 1)
            getDigitCount(result, counter);
    }

    private void getDigitCount(List<Character> result, int num) {
        if(num < 10) {
                        //converting integer to char
            result.add((char)('0'+num));
            return;
        }

        List<Character> temp = new ArrayList<>();

        //since the number is 10 or higher, it'll have more than 1 digit, we need to separate those numbers
        while(num > 0) {
            int remainder = num % 10;
            num /= 10;

            temp.add((char)('0'+remainder));
        }

        //cuz numbers were separate in reverse order
        //eg. 12 will be separated like 2 than 1 so they'll be inserted in the list in that order so we've to reverse it
        Collections.reverse(temp);
        result.addAll(temp);
    }
}
