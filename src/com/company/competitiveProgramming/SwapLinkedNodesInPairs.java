package com.company.competitiveProgramming;

public class SwapLinkedNodesInPairs {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    private ListNode createDataSet() {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        list1.next = list2;
        ListNode list3 = new ListNode(3);
        list2.next = list3;

        System.out.println("list1.val: "  + list1.val + " list2.val: "+ list1.next.val + " list3.val: "+ list2.next.val);

        ListNode list4 = new ListNode(4);
        list3.next = list4;
        ListNode list5 = new ListNode(6);
        list4.next = list5;

        return list1;
    }

    public ListNode swapPairs(ListNode head) {
        head = createDataSet();//method for creating a test linkedList

        //if there's no next node, we can't do swapping. Just return the head as is
        if(head == null || head.next == null)
            return head;

        return swapAdjecentNodes(head);
    }

    private ListNode swapAdjecentNodes(ListNode node) {
        if(node == null)
            return null;

        node = swapTwoNodes(node);
        if(node.next != null) {
            //now we need to perform the same swap of nodes that're after the current 2 nodes that were swapped
            //meaning node 3 & 4 therefore we call swapAdjecentNodes(node.next.next)
            //if we call swapAdjecentNodes(node.next) than we'd be performing swap on node at position 2 & node at position 3 which is not required for this question
            node.next.next = swapAdjecentNodes(node.next.next);
        }

        return node;
    }

    //swap two adjecent nodes
    private ListNode swapTwoNodes(ListNode node) {
        if(node == null)
            return null;

        ListNode node1 = node;
        ListNode node2 = node.next;

        if(node2 == null)
            return node1; //we can't swap cuz there's no 2nd node to swap with.

        ListNode node2NextTemp = node2.next;

        node2.next = node1;
        node1.next = node2NextTemp;

        return node2;
    }
}
