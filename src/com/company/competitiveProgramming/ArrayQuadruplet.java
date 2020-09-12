package com.company.competitiveProgramming;

import java.util.*;

public class ArrayQuadruplet {

    //fully solved. Got the question from pramps website
    public int[] findArrayQuadruplets(int[] arr, int s) {

        //find sums of every 2 nums in the array
        // than iterate over the map & subtract each precalculated sum with give target, if the sum is in the map, you found the answer

        HashMap<Integer, HashMap<Integer, Integer>> twoSumMap = new HashMap<>();

        int startPointer = 0;

        //creating sum of every 2 consecutive integers in the array
        while(startPointer < arr.length-1) {
            //saving the sum of 2 consecutive values in a map
            if(twoSumMap.containsKey(arr[startPointer] + arr[startPointer+1]))
                twoSumMap.get(arr[startPointer] + arr[startPointer+1]).put(startPointer, 1);
            else {
                HashMap<Integer, Integer> internalMap = new HashMap<>();
                internalMap.put(startPointer, 1);
                twoSumMap.put(arr[startPointer] + arr[startPointer + 1], internalMap);
            }
            startPointer++;
        }

        int index1, index2;
        index1=index2=-1;
        for(int twoSum : twoSumMap.keySet()) {
            if(twoSumMap.containsKey(s-twoSum) && twoSumMap.containsKey(s-(s-twoSum))) {
                index1 = twoSumMap.get(s-twoSum).keySet().iterator().next();
                if(s-twoSum == s-(s-twoSum)) {
                    if(twoSumMap.get(s-twoSum).size() > 1) {
                        for(int potentialIndex : twoSumMap.get(s-twoSum).keySet()) {
                            if(index1 == -1) {
                                index1 = potentialIndex;
                            }
                            else {
                                index2 = potentialIndex;
                                System.out.println("POTENTIAL MATCH: index1: "+ index1 + " index2: "+ index2);
                                int[] potentialIndices = checkIfIndexesAreSimilarOrAdjecent(index1, index2, arr);
                                if(potentialIndices != null)
                                    return potentialIndices;
                            }
                        }
                    }
                }
                else {
                    for(int key : twoSumMap.get(twoSum).keySet()) {
                        index2 = key;
                        System.out.println("POTENTIAL MATCH: index1: "+ index1 + " index2: "+ index2);
                        int[] potentialIndices = checkIfIndexesAreSimilarOrAdjecent(index1, index2, arr);

                        if(potentialIndices != null)
                            return potentialIndices;
                    }
                }
            }
        }

        System.out.println("not found");

        return new int[] {};
    }

    private int[] checkIfIndexesAreSimilarOrAdjecent(int index1, int index2, int[] arr) {
        if(index1 != -1 && index2 != -1 && index1 != index2 && Math.min(index1, index2) + 1 != Math.max(index1, index2)) {
            System.out.println("index1: "+ index1 + " index2: "+ index2);
            System.out.println("values are: " + arr[index1] + ", " + arr[index1 + 1] + ", " + arr[index2] + ", " + arr[index2 + 1]);

            int[] foundIndices =  new int[] {arr[index1], arr[index1+1], arr[index2], arr[index2+1]};
            Arrays.sort(foundIndices);
            return foundIndices;
        }
        return null;
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
    }*/

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
