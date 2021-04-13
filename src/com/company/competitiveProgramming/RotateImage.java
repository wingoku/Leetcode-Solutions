package com.company.competitiveProgramming;

public class RotateImage {
    /**
     Rotating a matrix always involves 2 steps
     1. Transpose
     2. Reverse rows

     STEP 1 - Transpose:
     for each row, we swap the elements using this expression
     swap element at matrix[i][j] with element at matrix[j][i]
     AND
     swap element at matrix[j][i] with element at matrix[i][j]

     The j loop always starts from the value of i

     in order to do the swap like anyother swap,
     1. we store matrix[j][i] in a temp variable
     2. we store in matrix[j][i] the value of matrix[i][j] i-e; matrix[j][i] = matrix[i][j]
     3. we store the temp value in matrix[i][j] i-e; matrix[i][j] = temp

     After this we've a transposed matrix
     Now is STEP 2 - reverse each row:
     1. iterate over each row swap the items on both sides so item at 0 will be swaped by item at index row.length-1
     2. keep doing this loop until start < end
     3. once all the rows have been reversed, we've a rotated matrix
     */
    public void rotate(int[][] matrix) {
        if(matrix == null)
            return;

        transpose(matrix);

        for(int i=0; i<matrix.length; i++)
            reverseRow(matrix[i]);
    }

    private void transpose(int[][] matrix) {
        for(int i=0; i<matrix.length; i++) {
            for(int j=i; j<matrix[i].length; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

    private void reverseRow(int[] row) {
        int start=0;
        int end=row.length-1;

        while(start < end) {
            int temp = row[end];
            row[end] = row[start];
            row[start] = temp;

            start++;
            end--;
        }
    }
}
