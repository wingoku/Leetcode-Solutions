package com.company.competitiveProgramming;

import java.util.Stack;

public class ReverseLinkedList {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int v) {
            val = v;
        }
    }

    //leetcode accepted
    //amazon coding interview
    //TC: O(N)
    //SC: O(1) //cuz we're not allocating any additonal memory
    public ListNode reverseList(ListNode head) {
                           //if next is null that means linkedList only has 1 value therefore we can't reverse it
        if(head == null || head.next == null)
            return head;

        //1->2->3->NULL
        //RESULT:
        //Null <- 1 <- 2 <- 3

        /**
         * We start from 1,
         * we set it as the currentNode
         * than we take its next node meaning current.next & store in a temp variable so that we don't lose the node whose reference is in current.node
         * than we set current.next = prev; in the beginning prev = null than on next iteration prev = 1, on next prev = 2
         * than we set current as the node that we cached in temp variable so we can keep looping until we reach the end of the provided list
         * than we set prev = current cuz in the next iteration, the currentNode of current iteration will be its prev node
         * that's how we achieve reversing in constant memory
         */

        ListNode prev = null;
        ListNode current = head;

        while(current != null) {
            ListNode temp = current.next;

            current.next = prev;

            prev = current;

            current = temp;
        }

        return prev;
    }

    //leetcode accepted
    //1ms
    //amazon coding interview
    //TC: O(N)
    //SC: O(N) // can also be done in O(1)
    public ListNode reverseList2(ListNode head) {

        if(head == null || head.next == null)
            return head;

        Stack<ListNode> nodesStack = new Stack<>();

        ListNode node = head;
        while(node != null) {
            nodesStack.push(node);
            node = node.next;
        }

        ListNode prevNode = nodesStack.pop();;
        ListNode currentNode = null;
        head = prevNode;

        while(!nodesStack.isEmpty()) {
            currentNode = nodesStack.pop();
            prevNode.next = currentNode;
            prevNode = currentNode;
        }

        currentNode.next = null;
        return head;
    }
}
