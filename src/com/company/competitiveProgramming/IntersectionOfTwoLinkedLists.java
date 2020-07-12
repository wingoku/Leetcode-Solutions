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
