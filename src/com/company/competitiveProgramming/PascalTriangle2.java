package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PascalTriangle2 {
    List<List<Integer>> pascalList = new ArrayList<>();
    public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0)
            return Arrays.asList(1);

        pascalList.add(Arrays.asList(1));
        pascalList.add(Arrays.asList(1,1));


        for(int i=2; i<=rowIndex; i++) {
            pascalList.add(new ArrayList());
            pascalList.get(i).add(1);

            for(int j=1; j<i; j++) {
                pascalRecursion(i, j);
            }
            pascalList.get(i).add(1);
        }

        return pascalList.get(rowIndex);
    }

    private int pascalRecursion(int row, int column) {
        if(row <= 1 || column == row) {
            return 1;
        }

        //checking this row already contains more columns than the given column
        //eg. if we want to calculate row:3, column:2
        //we can calculate it by sum(row-1, column-1) + sum(row-1, column) -> sum(2,1) + sum(2,2)
        if(pascalList.get(row).size() > column) {
            return pascalList.get(row).get(column);
        }

        int result = 0;
        result = pascalRecursion(row - 1, column - 1) + pascalRecursion(row - 1, column);
        pascalList.get(row).add(result);
        return result;
    }




    //working solution but really slow cuz it's redoing work
    /*public List<Integer> getRow(int rowIndex) {
        if(rowIndex == 0)
            return Arrays.asList(1);

        List<Integer> resultList = new ArrayList<>();
        pascalRecursion(rowIndex+1, resultList);

        return resultList;
    }

    private void pascalRecursion(int rowToBeFound, List<Integer> list) {
        list.add(1);
        for(int j=2; j<rowToBeFound; j++) {
            int value = pascalRecursion(rowToBeFound-1, j-1) + pascalRecursion(rowToBeFound-1, j);
            list.add(value);
        }
        list.add(1);
    }

    private int pascalRecursion(int row, int column) {
        if(row == 1 && column == row) {
            return 1;
        }

        if(column < 0 || column > row)
            return 0;

        //row =3
        //col=3

        //2,2 -> 1,1=1 & 1,2=1
        //3,2 -> (2,1-> (1,0->1 & 1,1->1) & 2,2 -> (1,1->1 && 1,2->1)) -> 4

        int result1 = pascalRecursion(row-1, column-1);

        // System.out.println("pascal("+(row-1)+", "+ (column-1) + ") = "+ result1);
        int result2 = pascalRecursion(row-1, column);

        // System.out.println("pascal("+(row-1)+", "+ (column) + ") = "+ result2);

        return result1+result2;
    }*/
}
