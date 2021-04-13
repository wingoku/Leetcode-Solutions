package com.company.competitiveProgramming;

public class PalindromeLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //TC: O(N)
    //SC: O(1)
    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null)
            return true;

        ListNode node = head;

        //find the size of list
        int listSize = 0;
        while(node != null) {
            listSize++;
            node = node.next;
        }


        node = head;

        int index = 0;
        ListNode prev = null;

        //reverse list until the mid of the give list. to make sure we don't go past the mid of the list, we make sure index is always less than listSize/2
        while(node != null && index < listSize/2) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;

            index++;
        }

        ListNode midHead = null;
        midHead = node;

        if(listSize % 2 != 0) //cuz in this [1,0,1] kind of linked list, the center is common, so comparison starts from center-1 & center+1
            midHead = midHead.next;

        //now compare the list we reversed (that contains nodes from start till mid but since it's reversed, its head is now pointing the to the node in the center of the list) & the remaining unreversed list i-e; the list after the middle node of the list. If the values of reversed list and unreversed list match,
        //than they're palindrome
        while(midHead != null) {
            if(midHead.val != prev.val)
                return false;

            midHead = midHead.next;
            prev = prev.next;
        }

        return true;
    }
}
