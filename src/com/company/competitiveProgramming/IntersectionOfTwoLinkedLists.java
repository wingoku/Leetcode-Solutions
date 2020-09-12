package com.company.competitiveProgramming;

import java.awt.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class IntersectionOfTwoLinkedLists {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }

    /**
     Doing in Constant Space

     The idea is to find out the length of each given list & check which list is bigger than the other
     Subtract the sizes & the remainder is the number of nodes we need to skip. The skip idea is actually taken from the question & it's example

     Solution:
     find the size of each list
     subtract the sizes to get the number of nodes to skip in the list with bigger size BEFORE we start the comparison

     after skipping the execessive nodes in the bigger list, start comparing the nodes in each list
     till either we find the intersection or we don't
     */

    //leetcode 1ms
    //amazon coding interview
    //TC - O(n)
    //SC - O(1)
    public ListNode getIntersectionNodeConstantSpace(ListNode headA, ListNode headB) {
        int listASize = 0;
        int listBSize = 0;

        //get length of list a
        ListNode nodeA = headA;
        while(nodeA != null) {
            listASize++;

            nodeA = nodeA.next;
        }

        //get length of list b
        ListNode nodeB = headB;
        while(nodeB != null) {
            listBSize++;

            nodeB = nodeB.next;
        }


        ListNode intersectionNode = null;

        //if list a is bigger than list b, than start with list a & skip nodes until listASize-listBSize == 0
        if(listASize > listBSize) {
            intersectionNode = getIntersection(headA, headB, listASize - listBSize);
        }
        else{
            intersectionNode = getIntersection(headB, headA, listBSize - listASize);
        }

        return  intersectionNode;
    }

    private ListNode getIntersection(ListNode a, ListNode b, int skip) {

        while(a != null && b != null) {

            //if skip count is > 0 that means we still have some nodes to skip until we can start the comparison
            if(skip > 0) {
                a = a.next;
                skip--;
                continue;
            }

            if(a == b) {
                return a;
            }

            a = a.next;
            b = b.next;
        }

        return null;
    }
    //WE NEED TO CHECK IF LIST NODES ARE EQUAL NOT THEIR VALUES!!!!
    //select the smaller list
    // put the list in hashmap with list node value as key & list node index as value
    //than iterate over the bigger list and check if map contains the value
    /**ACCETED SOLUTOIN BY LEET CODE BUT USES O(N) SPACE INSTEAD OF O(1) SPACE*/
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> headASet = new HashSet<>();

        while(headA != null) {
            headASet.add(headA);
            headA = headA.next;
        }

        while(headB != null) {
            if(headASet.contains(headB)) {
                //intersection point
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }
}
