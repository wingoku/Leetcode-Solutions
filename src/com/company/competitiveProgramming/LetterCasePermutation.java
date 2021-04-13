package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;

public class LetterCasePermutation {
    //TC: N * 2^N. It's 2^N cuz for each letter we've 2 possibilities i-e; 2 recursive branches and for N characters it'll be 2^N
    //eg. if we just one character in the string i-e; "A", the TC will 2^2 = 4 ie-; a character can be converted into lower and upper case and then from that recursion
    //we'll have 1 branch each that'll happen and end immediatelly cuz we will be out of given string bound
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();

        permutation(S, 0, new StringBuilder(), result);

        return result;
    }

    private void permutation(String s, int index, StringBuilder sb, List<String> perm) {
        if(index >= s.length() && sb.length() == s.length()) {
            perm.add(sb.toString());
            return;
        }

        boolean isChar = false;
        for(int i=index; i<s.length(); i++) {
            char c = s.charAt(i);
            sb.append(c);
            permutation(s, i+1, sb, perm);

            isChar = isCharacter(c);

            //permutation is only about the english characters so when we come across an english letter
            //than we have to find the permutation with character in it's current form i-e; either lower case or upper case
            //and than we've to find the permutation of the same character again but in the opposite form i-e; if it was in lower case
            //and we called permutation method on it, now in the same loop and in the recursion we call permutation on it with upper case
            //ONCE the recursive permutation call for lower case character in the current iteration of the loop as returned
            if(isChar) {
                sb.setLength(sb.length()-1);
                if(isLowerCase(c)) {
                    sb.append(Character.toUpperCase(c));
                }
                else
                    sb.append(Character.toLowerCase(c));
                permutation(s, i+1, sb, perm);
            }

            sb.setLength(sb.length()-1);
        }
    }

    private boolean isCharacter(char c) {
        return isLowerCase(c) || isUpperCase(c);
    }

    private boolean isLowerCase(char c) {
        return c >= 'a' && c <= 'z';
    }

    private boolean isUpperCase(char c) {
        return c >= 'A' && c <= 'Z';
    }
}
