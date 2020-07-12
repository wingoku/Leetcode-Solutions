package com.company.competitiveProgramming;

import java.util.*;

//not fully solved. Found it on pramps website. Needs futher optimizatoins to improve runtime. It's ~8 secs on prampos website. It should take less than 5 seconds
public class ArrayQuadruplet {
    public int[] findArrayQuadruplets(int[] arr, int s) {
        long start = System.nanoTime();
        int sum = 0;
        int start_pointer = 0;
        int end_pointer = 0;
        int lookupSum = 0;
        boolean found = false;
        int lookupIndex = 0;
        int countOfNumbers = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>(arr.length);

        int[] foundArray = new int[arr.length];

        while(end_pointer < arr.length) {
            sumMap.put(arr[end_pointer], 1);

            sum += arr[end_pointer];
            foundArray[end_pointer] = arr[end_pointer];
            countOfNumbers++;

            end_pointer++;
            if(sum > s) {
                countOfNumbers--;
//                System.out.println("removing: "+ arr[start_pointer] + " fromIndex: "+ start_pointer);
                sumMap.remove(arr[start_pointer]);
                sum -= arr[start_pointer];
                foundArray[start_pointer] = Integer.MIN_VALUE;
                start_pointer++;
            }

            if(sum == s) {
                found = true;
                break;
            }
        }

        System.out.println("timeTaken: "+ (System.nanoTime() - start));
        System.out.println("map is: "+ sumMap.toString());
        start = System.nanoTime();
        if(found && countOfNumbers == 4) {
            int[] finalFoundArray = new int[countOfNumbers];
            int i=0, j=0;
            while(i<countOfNumbers) {
                if(foundArray[j] != Integer.MIN_VALUE)
                    finalFoundArray[i++] = foundArray[j];
                j++;
            }

            Arrays.sort(finalFoundArray);
            for(int im : finalFoundArray)
                System.out.println(im);
            System.out.println("2. timeTaken: "+ (System.nanoTime() - start));
            return finalFoundArray;
        }
        return new int[]{};
    }

    /*public int[] findArrayQuadruplets(int[] arr, int s) {
        long start = System.nanoTime();
        int sum = 0;
        int start_pointer = 0;
        int end_pointer = 0;
        int lookupSum = 0;
        boolean found = false;
        int lookupIndex = 0;
        int countOfNumbers = 0;
        HashMap<Integer, Integer> sumMap = new HashMap<>(arr.length);

        while(end_pointer < arr.length) {
            lookupIndex = end_pointer;
            if(lookupIndex+1 < arr.length)
                lookupIndex+=1;
            lookupSum = sum + arr[lookupIndex];

            if(lookupSum > s) {
                countOfNumbers--;
//                System.out.println("removing: "+ arr[start_pointer] + " fromIndex: "+ start_pointer);
                sumMap.remove(arr[start_pointer]);
                sum -= arr[start_pointer];
                start_pointer++;
            }

//            System.out.println("adding: "+ arr[end_pointer] + " fromIndex: "+ end_pointer);
//            System.out.println("sumMap.get(arr[end_pointer]): "+ sumMap.get(arr[end_pointer]));
            if(sumMap.get(arr[end_pointer]) != null)
                sumMap.put(arr[end_pointer], sumMap.get(arr[end_pointer])+1);
            else
                sumMap.put(arr[end_pointer], 1);

            sum += arr[end_pointer];
            countOfNumbers++;

            if(sum == s) {
                found = true;
                break;
            }

            end_pointer++;
        }

        System.out.println("timeTaken: "+ (System.nanoTime() - start));
//        System.out.println("map is: "+ sumMap.toString());
        start = System.nanoTime();
        if(found && countOfNumbers == 4) {
            List<Integer> list = new ArrayList<>();
            for (int key : sumMap.keySet()) {
                for (int i = 0; i < sumMap.get(key); i++) {
                    list.add(key);
                }
            }

            System.out.println("list: " + list.toString());
            Collections.sort(list);
            int[] sumArray = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                sumArray[i] = list.get(i);
            }

            System.out.println("2 timeTaken: "+ (System.nanoTime() - start));
            return sumArray;
        }
        return new int[]{};
    }*/

    /**
     * {
     *         int sum = 0;
     *         int start_pointer = 0;
     *         int end_pointer = 0;
     *         int tmp = 0;
     *
     *         while(end_pointer < arr.length) {
     *             if(end_pointer+1 < arr.length)
     *                 tmp = sum + arr[end_pointer+1];
     *             else
     *                 tmp = sum + arr[end_pointer];
     *
     *             if(tmp > s) {
     *                 sum -= arr[start_pointer];
     *                 start_pointer++;
     *             }
     *             sum += arr[end_pointer];
     *             if(sum == s)
     *                 break;
     *             end_pointer++;
     *         }
     *
     *         System.out.println("sum is: "+ sum);
     *     }
     */
}
