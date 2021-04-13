package com.company.competitiveProgramming;

public class MergeTwoSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode currentNode = head; //keeping track of head in current node

        //in the beginning node will be pointing to head
        //since head contains dummy value and we don't want to lose reference to head
        //we assign nodes from l1 and l2 to the node.next
        //so after the very first iteration,
        //head.next will be pointing to the first valid node provided in either l1 or l2
        while(l1 != null && l2 != null) {

            if(l1.val < l2.val) {
                currentNode.next = l1;
                l1 = l1.next;
            }
            else {

                currentNode.next = l2;
                l2 = l2.next;
            }

            //whatever currentNode we assigned to currentNode.next now becomes our current node
            //and since we want to merge list, we need to make current node pointing to the next node
            //therefore we do currentNode = currentNode.next
            currentNode = currentNode.next;
        }

        if(l1 != null) {
            currentNode.next = l1;
        }
        else
        if(l2 != null) {
            currentNode.next = l2;
        }

        //since head contains dummy value however head.next contains the first valid value, we return head.next
        return head.next;
    }
}
