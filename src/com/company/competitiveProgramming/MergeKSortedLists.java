package com.company.competitiveProgramming;

import java.util.PriorityQueue;

public class MergeKSortedLists {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode[] createDataSet(int[][] nums) {
        ListNode[] lists = new ListNode[nums.length];
        for(int i=0; i<nums.length; i++) {
            ListNode root = new ListNode();
            ListNode current = null;
            ListNode prev = root;

            lists[i] = root;
            for (int j = 0; j < nums[i].length; j++) {
                if(j == 0) {
                    current = root;
                }
                else
                    current = new ListNode();
                current.val = nums[i][j];
                prev.next = current;
                prev = current;
            }
        }

        return lists;
    }


    //leetcode accepted solution
    //solved using min heap & reusing the provided listNodes
    //5 ms
    public ListNode mergeKLists(ListNode[] lists) {
        //we add the elements into the priority queue & at the end we loop on the queue and poll the root value and add it in a new list

        if(lists.length == 0)
            return null;

        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((n1, n2) -> Integer.compare(n1.val, n2.val));
        for(ListNode node : lists) {
            while(node != null) {
                minHeap.add(node);
                node = node.next;
            }
        }

        if(minHeap.size() == 0)
            return null;

        ListNode root = minHeap.remove();
        ListNode node = root;
        while(!minHeap.isEmpty()) {
            node.next = minHeap.remove();
            node = node.next;
            node.next = null; // so that if this node coming from minHeap was pointing to some other node with similar value doesn't cause circular dependency EG. [[-2,-1,-1,-1],[]] will cause circular link cuz in minHeap -1,-1,-1 might be rearranged but they'll still be popped based on the their value
        }
        return root;
    }

    //leetcode accepted solution
    //solved using min heap
    //5 ms
    /*public ListNode mergeKLists(ListNode[] lists) {
        //we add the elements into the priority queue & at the end we loop on the queue and poll the root value and add it in a new list

        if(lists == null || lists.length == 0)
            return null;

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int i=0; i<lists.length; i++) {
            ListNode root = lists[i];
            while (root != null) {
                minHeap.add(root.val);
                root = root.next;
            }
        }

        if(minHeap.isEmpty())
            return null;


        ListNode root = new ListNode(minHeap.poll());
        ListNode currentNode = null;
        ListNode prevNode = root;

        while(!minHeap.isEmpty()) {
            currentNode = new ListNode();

            currentNode.val = minHeap.poll();
            prevNode.next = currentNode;
            prevNode = currentNode;
        }

        return root;
    }*/
}
