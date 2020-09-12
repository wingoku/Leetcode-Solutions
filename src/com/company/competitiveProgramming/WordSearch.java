package com.company.competitiveProgramming;

import java.util.Arrays;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++)
            for(int j=0; j<board[i].length; j++)
                if(board[i][j] == word.charAt(0)) {
                    boolean found = dfs(board, word, i, j, 0);
                    if(found) {
                        System.out.println("result is: "+ true);
                        return true;
                    }
                }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int letterIndex) {
        if(letterIndex >= word.length())
            return true;

                                                                        //if the current character in the adjecency matrix doesn't match with the current character in the word, there's no point in continuing the search using this branch/node in adjecency matrix
        if(i < 0 || j < 0 || i>= board.length || j >= board[i].length || board[i][j] != word.charAt(letterIndex))
            return false;

        char currentChar = board[i][j];
        if(word.charAt(letterIndex) == currentChar) {
            board[i][j] = ' ';
            letterIndex++;
        }
                         //top                                      //bottom
        boolean found =  dfs(board, word, i-1, j, letterIndex) || dfs(board, word, i+1, j, letterIndex) ||
                         //left                                     //right
                         dfs(board, word, i, j-1, letterIndex) || dfs(board, word, i, j+1, letterIndex);

        board[i][j] = currentChar; //we need to reput the value again cuz in case we don't find the word in the recursions from the current i,j loop, we may find the word in another i,j loop & recursion
        //if those values are not reset, we won;t be able to find the word in other i,j loops
        /**
         * EG: consider this example:
         *
         [["C","A","A"],
         ["A","A","A"],
         ["B","C","D"]]

         Word: AAB

         if we set As == - & don't reset the value back to A, in the i,j loop recursion call when we're on the second row, we won't be able to find the word AAB
         */
        return found;
    }


}
