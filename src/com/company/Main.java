package com.company;

import com.company.competitiveProgramming.*;
import com.company.competitiveProgramming.incomplete.FrogJump;

import java.util.*;

public class Main {
    public static void main(String args[]) {
        //Given an array nums of n integers,
        // are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
        /*
        Given array nums = [-1, 0, 1, 2, -1, -4],

            A solution set is:
            [
              [-1, 0, 1],
              [-1, -1, 2]
            ]
         */

//        int[] s = null;
//        int[] x = {2, 7, 11, 15};
//        int[] x1 = {3, 2, 4};
//        int[] x2 = {0, 1, 2, 4, 7, 8, 9, 10, 11, 12};
//        int[] x3 = {10, 7, 8, 9, 1, 5};
//        int[] x4 = {6, 2, -1, 5, 3, 1, 4, 10}; // solution = 0
//        int[] x5 = {-1, 0, 1, 2, -3, -4}; // solution = 0 {-4, -3, -1, 0, 1, 2} -> {-4, -3, -1} {0} {1, 2}
//        int[] x6 = {-1, 0, 3, 2, -1, -4}; // solution = 0
        //       0  1  2  3  4  5  6  7  8  9
/*
        int[] test = x5;
        long start = System.nanoTime();
//        HashMap<Integer, Integer> map = new QuickSort().sort(test, 0, test.length);
        findSubsets(test);
        print("time taken: ", (System.nanoTime() - start));*/

        /*int[] test = x1;
        new QuickSort().sort(test, 0, test.length-1);
        print("array after quick sort: ");
        for(int i : test)
            print(i,",");
        findIndices(x, 6);*/
//        findIndices(x1, 10);

//        Test t = new Test();
//        t.test();
//        new FindSubstring().test();


        /*String[] testCases = {"ABDEFGABEF",
        "bbtablud",
                "aaf",
                "ab",
                "pwwkew",
                "bbbbb",
                "abcabcbb",
                "aa",
                "dvdf",
                "ckilbkdckilb",
                "anviaj"};//anviaj = 5

        for(int i=0; i<testCases.length; i++)
        new FindLongestSubstring().startMatch(testCases[i]);*/

        //"bdab"
        //"ab"
        //input: "aa" : find: "aa" : Expected: "aa""ADOBECODEBANC"
        //"ABC"
//        String smallestSubstring = new MinimumWindowSubstring().findSmallestSubstring("acbbaca", "aba");
//        System.out.println("smallestSubstring: "+ smallestSubstring);

//        new ArrayQuadruplet().findArrayQuadruplets(new int[] {2, 7, 4, 0, 9, 5, 1, 3}, 20);
//        new SingleNumber().returnNonDuplicateNumberInArray(new int[]{1, 2, 3, 1,3});
//        new MissingNumber().findMissingNumberWithGaussionSum(new int[] {9,6,4,2,3,5,7,8,1});
//        new ReverseInteger().reverseInteger(319);
//        new FindPrimeNumbersUnderN().findPrimeNumbers(60);
//        new FirstNonRepeatingCharacter().firstUniqueCharacter("loveleetcode");
//        new TwoSum().find2NumsThatEqualGivenSum(new int[] {2, 7, 11, 15}, 9);

//        new BalancedParanthesis().isBalanced("{{([])}{}");
//        new SumInRange().sumInRange(new int[]{3, 0, -2, 6, -3, 2}, new int[][]{{0, 2}, {2,5}, {0, 5}});
//        new ArrayMaxConsecurtiveSum2().findConsecutiveSubarray(new int[] {11, -2, 1, -4, 5, -3, 2, 2, 2});


//        new ThirdMaxInArray().findThirdMax(new int[]{5,2,4,1,3,6,0});

//        new RotateArray().rotateArray(new int[]{-1}, 3);
//        new ValidPalindrome().isValidPalindrome("A man, a plan, a canal: Panama");

//        new LongestContiguousSubarray().findLongestContiguousSubArrayForTargetSum(new int[]{135, 101, 170, 125, 79, 159, 163, 65, 106, 146, 82, 28, 162, 92, 196, 143, 28, 37, 192, 5, 103, 154, 93, 183, 22, 117, 119, 96, 48, 127, 0, 172, 0, 139, 0, 0, 70, 113, 68, 100, 36, 95, 104, 12, 123, 134}, 468); //m(new int[]{1, 0, 2, 0, 0, 0, 0, 0}, 0); |
//        new Subset().subsets(new int[]{0});
//        new PowerOfTwo().isPowerOfTwo(536870912);

//        new RobotReturnToOrigin().isRobotReturningToOriginalPosition("LDRRLRUULR");
//        new BestTimeToBuyAndSellStocks2().maxProfile(new int[] {7,1,5,3,6,4});
//        new PathSum2().pathSum(null, 22);
//        new ValidateBinarySearchTree().isValidBST(null);
//        new MoveZerosToEndOfArray().moveZeroes(new int[] {1,0,1});
//        new SymmetricTree().isSymmetric(null);

//        new BinaryTreeLevelOrderTraversal().levelOrder(null);
//        new MatrixChainMultiplicationProblem().maxCoins(new int[]{9,76,64,21});
//        new Main().iterateWith2Power();
//        new CountingBits().countBits(4);
//        new NumberOfSubsequences().countSubsequences("abbbc");
//        new CountInversions_OR_Swaps().countInversions(new int[] {7, -90, 100, 1});

//        new ReplaceGreatestElementsOnRight().replace(new int[] {16, 17, 4, 3, 5, 2});

//        new HighestPowerOf2().findHighestPowerOf2LessThanOrEqualToGiveNumber(10);
//        new ArrayQuadruplet().findArrayQuadruplets(new int[] {4,4,4,4}, 16);
//        new KMessedArraySort().sortKMessedArray(new int[] {1, 4, 5, 2, 3, 7, 8, 6, 10, 9}, 2);

//       MergeKSortedLists merge = new MergeKSortedLists();
//       merge.mergeKLists(merge.createDataSet(new int[][] {{1,4,5},{1,3,4},{2,6}}));

//        new KLargestElementInArray().findKthLargest(new int[] {3,2,1,5,6,4}, 5);

//        boolean result = new isSubsequence().isSubsequence("aaaaaa", "bbaaaaaa");
//        System.out.println("isSubsequence: "+ result);

//        new RepeatedDNASequences().findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");

//        new PancakeSort().pancakeSort(new int[]{2,3,4,5,6,1});
//        new NumberOfMatchingSubsequeneces().numMatchingSubseq("qlhxagxdqh", new String[] {"qlhxagxdq","qlhxagxdq","lhyiftwtut","yfzwraahab"});
//        new WordSearch().exist(new char[][] {{'C','A','A'},{'A','A','A'},{'B','C','D'}}, "AAB");

//        new WordLadder().ladderLength("hit","cog", Arrays.asList("hot","dot","dog","lot","log","cog"));

//        new RemoveElement().removeElement(new int[]{1}, 1);

//        new GenerateParentheses().generateParenthesis(4);
//        new LowestCommonAncestorOfBinaryTree().lowestCommonAncestor();
/*
        int[][] times = new int[][]{ {0,30},
                {15, 20},
                {5,10}};

        Arrays.sort(times, (sT1, sT2) -> sT1[0]-sT2[0]);

        System.out.println("s");*/

//        new MeetingRooms2().createDataSet();

//        new KClosestPointToOrigin().kClosest(new int[][]{{1,3},{-2,2},{2,-2}}, 2);
//        new FrogJump().canCross(new int[]{0,1,3,5,6,8,12,17});
//        new JumpGame().canJump(new int[] {2,5,0,0});

//        new SwapLinkedNodesInPairs().swapPairs(null);

//        new PascalTriangle2().getRow(25);
//        new UnqiuePath().uniquePaths(4,4);
//        new HouseRobber2().rob(new int[] {1,3,1,3,100});
//        new PowerCalculator().myPow(2.0, -2147483648);

//        RabbitMQ r = new RabbitMQ();
////        MdmService s = new MdmService();
//        r.connect();

//        new CombinationSum().combinationSum(new int[]{2,3,5}, 8);

//        new BinaryTreePaths().createDataSet(null);

//        new ReorganizeString().reorganizeString("aab");
//        new MakingLargeIsland().largestIsland(new int[][] {{1,1,1,1,0,0},
//                {0,0,1,0,0,1},
//                {0,1,1,0,0,1},
//                {0,0,1,1,0,1},
//                {0,0,0,1,0,1},
//                {1,1,0,0,0,1}});

//        new MaxWidthOfBinaryTree().widthOfBinaryTree(null);
//        new SpiralMatrix().spiralCopy(new int[][] { {1,    2,   3,  4,    5},
//                {6,    7,   8,  9,   10},
//                {11,  12,  13,  14,  15},
//                {16,  17,  18,  19,  20} });

//        new SubarraySumEqualK().subarraySum(new int[]{0,0,0,0,0,0,0,0,0,0}, 0);

//        List<List<Integer>> connections = new ArrayList<>();
//        connections.add(Arrays.asList(0,1));
//        connections.add(Arrays.asList(1,2));
//        connections.add(Arrays.asList(2,0));
//        connections.add(Arrays.asList(1,3));
//        new CriticalConnectionsInNetwork_TarjanAlgo().criticalConnections(4, connections);

//        LRUCache cache = new LRUCache(3);
////        cache.put(1,1);
////        cache.put(2,2);
////        cache.put(3,3);
////        cache.put(4,4);
////        cache.get(4);
////        cache.get(3);
////        cache.get(2);
////        cache.get(1);
////        cache.put(5,5);
////        cache.get(1);
////        cache.get(2);
////        cache.get(3);
////        cache.get(4);
////        cache.get(5);

//        new AmazonQuestion_K_minus_1_DistinctCharacters().kDistinctCharacters();
//        new DivideTwoIntegers().divide(10, -3);

//        new ExpressionAddOperator().addOperators("100015", 15);

//        String word1 = "abc";
//        String word2 = "abc";
//
//        System.out.println(word1.startsWith(word2));
//        System.out.println(word1.equals(word2));
        new WordBreak().wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab",
                Arrays.asList("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));
    }

    private void minHeapPractice() {
        MinHeap minHeap = new MinHeap(7);
        minHeap.add(10);
        minHeap.add(4);
        minHeap.add(15);
        System.out.println("removed (4): "+ minHeap.poll());
        minHeap.add(20);
        minHeap.add(0);
        minHeap.add(30);
        System.out.println("removed (0): "+ minHeap.poll());
        System.out.println("removed (10): "+ minHeap.poll());

        minHeap.add(2);
        minHeap.add(4);
        minHeap.add(-1);
        minHeap.add(-3);

        System.out.println("removed (-3): "+ minHeap.poll());
    }

    private void iterateWith2Power() {
        int i=1;
        int powerof2=1;
        int startPointer = 0;

        int endPointer = 0;
        while(endPointer < 16) {
            System.out.println("startPointer: "+ startPointer + " endPointer: "+ endPointer);
            if(startPointer != endPointer)
                for(int j=endPointer; j<Math.pow(2, i); j++)
                    System.out.println("j: "+ j);

            endPointer = (int) Math.pow(2, i);
            endPointer += startPointer;

            i++;
        }
    }

    static class xyz {

    }
    


    /*private static void findSubsets(int[] x) {
        int[] negVals = new int[x.length];
        int[] posVals = new int[x.length];

        int temp = 0;
        int posIndex = 0;
        int negIndex = 0;
        boolean containsZero = false;
        for(int i=0; i<x.length; i++) {
            temp = x[i];
            if(temp < 0)
                negVals[negIndex++] = temp;
            else
                if(temp > 0)
                    posVals[posIndex++] = temp;
                else
                    containsZero = true;
        }

        for(int i=0; i<posVals.length; i++) {
            int posVal = posVals[i];
            for(int j=0; j<negVals.length;j++) {
                if(pos)
            }
        }
    }*/

/*
    private  class Add2Numbers {
         class ListNode {
            int val;
            ListNode next = null;

            ListNode(int v) {
                val = v;
            }
        }

        class DoubleListNode {
            ListNode next, prev;
//            int carry, sum;
        }

        public  void add2Numbers(ListNode list1, ListNode list2) {
//            DoubleListNode dList1 = new DoubleListNode(), dList2 = new DoubleListNode();
//            ArrayList<Integer> arrayList = new ArrayList<>();
            ListNode result = new ListNode(0);

            boolean start = true;
            Stack<Integer> stack = new Stack();

            ListNode traverse1 = list1.next;
            ListNode traverse2 = list2.next;

            while(traverse1.next != null) {
                System.out.println("list1: "+ traverse1.val + traverse1.next.val);
                stack.push(traverse1.val+traverse2.val);
                traverse1 = list1.next;
                traverse2 = list2.next;

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int carry = 0;
            while(stack.size() > 0) {
                int sum = stack.pop() + carry;

                result.next = new ListNode(sum % 2);
                carry = sum / 2;
            }

            while(result.next != null) {
                System.out.println(result.val + ", ");
            }

            *//*while(list1.next != null) {

//                dList2.next = list2.next;
//                dList2.prev = list2;

                int sum = list1.val+list2.val;

                dList1.carry = sum / 10;
                dList1.sum = sum % 10;

                if(dList1.carry > 0) {

                    dList1.next = list1.next;

                    if(start)
                        start = false;
                    else
                        dList1.prev = list1;
                }

//                arrayList.add(sum % 10);
            }*//*

        }
    }*/
    private static void findSubsets(int[] x) {
        HashMap<Integer, Integer> map = new HashMap<>(x.length);

        for (int i = 0; i < x.length; i++) {
            if (map.containsKey(x[i]))
                map.put(x[i], map.get(x[i]) + 1);
            else
                map.put(x[i], 1);
        }

        print("map: ", map.toString());
//        for(int prev : map.keySet()) {
        {
//            if(map.get(prev) == 2 && map.containsKey(prev*2)) { // eg -20, 10, 10
//                // indices found
//            }
//            else
//                if(map.containsKey(map.get(prev)*-1) && map.containsKey(0)) { // eg -1,1,0
//                    //indices found
//                }
//                else
            //{-1, 0, 1, 2, -1, -4}
//                    if(map.get(prev) == 1) { //-9, 5, 4
            int prev = -1000;
            int innerIterations = 0;
            boolean filled = false;
            for (int next : map.keySet()) {
                if (!filled) {
                    filled = true;
                    prev = next;

                    innerIterations = map.get(prev);
                    continue;
                }

                innerIterations = map.get(prev);
                if(innerIterations == 1) {
                    int sum = prev  + next;
                    print("--------> ", prev, "+", next, "=", sum);
                    if (sum > 0 && map.containsKey(sum * -1) && map.containsKey(0)) { // search for a negative number that when added to the sum would result in zero
                        print("found ", prev, next, sum * -1);
                    } else if (sum < 0 && map.containsKey(sum* -1) && map.containsKey(0)) {
                        print(".found", prev, next, sum);
                        prev = next;
                    }
                }
                else
                for(int i=0; i<innerIterations-1; i++) {
                    int multiplier = i+1;

                    int sum = prev *2 + next;
                    print("--------> ", prev, "+", next, "=", sum);
                    if(sum > 0 && map.containsKey(sum*-1)) { // search for a negative number that when added to the sum would result in zero
                        print("found ", prev, next, sum*-1);
                    }
                    else
                        if(sum < 0 && map.containsKey(sum)) {
                            print(".found", prev, next, sum);
                        }
    //                if (map.containsKey(prev - next * -1))
    //                    print(prev, "+", next, "=", sum, " inMap(Type1)?: ", map.containsKey(prev - next * -1));
    //                if (map.containsKey(Math.abs(prev - next)))
    //                    print(prev, "+", next, "=", sum, " inMap(Type2)?: ", map.containsKey(Math.abs(prev - next)));
    //                if (map.containsKey(sum * -1))
    //                    print(prev, "+", next, "=", sum, " inMap(Type3)?: ", map.containsKey(sum * -1));
    //
    //                if (sum > 0 && map.containsKey(prev - next * -1) && sum + prev - next * -1 == 0)
    //                    print("1. set: ", prev, next, prev - next * -1);
    //                else if (sum < 0 && map.containsKey(Math.abs(prev - next)) && sum + Math.abs(prev - next) == 0)
    //                    print("2. set: ", prev, next, Math.abs(prev - next));
    //                else if (sum != 0 && map.containsKey(sum * -1))
    //                    print("3. set: ", prev, next, sum * -1);
                    prev = next;
                }
            }
        }
//        }
    }

    /* private static void hashSum(int x[], int target) {
         int[] indices = new int[2];
         int in1, in2, in3;
         int prev = -1000;
         HashMap<Integer, Integer> map = new HashMap<>(x.length);

         *//*
        get in the inde of negative value
        iterate & find if there is an element in array == |negative value| + x[i], if there is, break the loop
         *//*
        HashMap<Integer, String> negativeValueMap = new HashMap<>();
        for(int i=0; i<x.length; i++) {
            if(x[i] < 0)
                if(negativeValueMap.containsKey(x[i]))
                negativeValueMap.put(x[i], i);

            map.put(x[i], i);
        }

        if(negativeValueMap.size() == 0){
            print("couldn't find negative value. Invalid array for the task at hand");
            return;
        }

        for(int negVal : negativeValueMap.keySet()) {
            if(map.containsKey(negVal) && map.containsKey(negVal*-1) && map.containsKey(0)) {
                // index are
                print("indices are: ", map.get(negVal), map.get(negVal*-1), map.get(0));
                return;
            }
        }


        for(int i=0; i<x.length; i++) {
            if(map.containsKey(x[i]) && map.containsKey(x[i]*-1) && map.containsKey(0)) {
                //found
            }
            else
                if()
        }
        *//*HashMap<Integer, Integer> map = new HashMap<>(x.length);
        map.put(x[0], 0);

        prev = x[0];
        for(int i=1; i<x.length; i++) {
//            print("checking map indices: 0 until ", i);
            if(map.containsKey(x[i] * -1) && map.containsKey(0) || i<x.length -1 && prev+x[i]+x[i+1] == 0) {
                print("indices found: ");
//                indices[0] = map.get(target-x[i]);
//                indices[1] = i;

//                print("exists at: ", indices[0], indices[1]);
                break;
            }
            prev = x[i];
            map.put(x[i], i);
        }*//*
    }
*/
    // taking inspirationn from binary search to reduce traversal cost
    private static void findIndices(int[] x, int target) {
        //find the index of number <= target in array
        int start = 0, end = x.length;
        int arraySubsectionStartIndex = 0;
        int arraySubsectionEndIndex = 0;
        for (int i = start; i < end; i++) {
            int mid = start + (end - start) / 2; //to avoid integer overflow on 32 bit systems
            if (x[mid] <= target) {
                arraySubsectionStartIndex = start;
                arraySubsectionEndIndex = mid;
                break;
            }

            if (x[mid] > target) {
                end = mid;
            }
        }

        print("start sectoin index: ", arraySubsectionStartIndex);
        print("end sectoin index: ", arraySubsectionEndIndex);
        int[] indices = {-1, -1};
        if (arraySubsectionStartIndex <= x.length - 1) {
            for (int i = arraySubsectionStartIndex; i < arraySubsectionEndIndex; i++) {
                if (x[i] + x[i + 1] == target) {
                    indices[0] = i;
                    indices[1] = i + 1;
                }
            }
            print("indexs are: ", indices[0], indices[1]);
        }

        if (indices.length == 0)
            print("indices not found");
    }

    private static void print(Object... obj) {
        String printStatement = "";
        for (Object object : obj) {
            printStatement += " " + object.toString();
        }

        System.out.println(printStatement);
    }

    static class QuickSort {
        HashMap<Integer, Integer> map;

        public HashMap<Integer, Integer> sort(int[] x, int start, int end) {
            print("sort: start: ", start, " end: ", end);
            if (map == null)
                map = new HashMap<>();
            if (start >= end) // invalid segment of the array cuz of dividing array into sub arrays
                return map;

            int pIndex = partition(x, start, end, map);
            sort(x, start, pIndex - 1);
            sort(x, pIndex + 1, end);
            return map;
        }

        private int partition(int[] x, int start, int end, HashMap<Integer, Integer> map) {
            int pivot = x[end]; //4
            int pIndex = start;//0

            //3,2,4
            for (int i = start; i < end; i++) {
                if (map.containsKey(x[i]))
                    map.put(x[i], map.get(x[i]) + 1);
                else
                    map.put(x[i], 1);

                if (x[i] < pivot) {
                    //swap
                    swap(x, i, pIndex);
                    pIndex++;
                }
            }

            if (x[pIndex] > pivot) {
                //swap
                swap(x, pIndex, end);
            }
            return pIndex;
        }

        private void swap(int[] x, int indexToPushTowardsRight, int pivotIndex) {
            int temp = x[indexToPushTowardsRight];
            print("temp: ", temp);
            print("pIndexValue: ", x[pivotIndex]);
            x[indexToPushTowardsRight] = x[pivotIndex];
            x[pivotIndex] = temp;

            print("aduring quick sort: ", x[0], x[1], x[2]);
        }
    }


    /**
     * 2 pointers: start & end
     * ====> in the beginning
     * startPointer = 0
     * endPointer keeps moving
     * when a character is found in the T string,
     * check if it's already in a hashmap,
     * if it's; reset startPointer to this position & clear map
     *
     * When a second character is found, put it's position in a variable called secondVariablePosition.
     *
     * Once all characters are found, save the string in minSubstring
     * set startPointer = secondVariablePosition
     * start the search process again from =====> step till here.
     */
}