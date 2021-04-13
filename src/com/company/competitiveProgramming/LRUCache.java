package com.company.competitiveProgramming;

import java.util.HashMap;

public class LRUCache {

    /**

     The idea is to make a DoublyLinkedList
     We do that by creating a class Node which has prev & next objects

     We make dummy head and tail nodes to make things easier

     1. For adding:
     a. We create a new node & make dummyHead.next point to the newly added node
     2. For removing from the tail:
     a. we pass dummyTail.prev to remove method since dummyTail.prev is pointing to the node that's least recently used

     */

    //recently used or added elements are towards left most side of the list
    //least recently used elements are towards the right most side of the list
    //TC: O(1)
    //SC: O(capacity)
    //revise
    private HashMap<Integer, Node> map;
    private int capacity;
    private int cacheSize = 0;

    private Node dummyHead;
    private Node dummyTail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        dummyHead = new Node();
        dummyTail = new Node();

        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        int val = -1;
        // System.out.println("get: "+ key);
        if(map.containsKey(key)) {
            Node node = map.get(key);

            val = node.val;
            removeFromList(node);
            addToList(node);
        }

        return val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        // System.out.println("put: "+ key + " cacheSize: "+ cacheSize);
        if(node == null) {
            Node newNode = new Node(key, value);
            addToList(newNode);
            map.put(key, newNode);

            cacheSize++;
        }
        else {
            //node already exists. Remove it from the list and put it next to head
            removeFromList(node);
            node.val = value;
            addToList(node);
        }

        //cache size limit has been reached, evict the least recently used element
        if(cacheSize > capacity) {
            // System.out.println("evicting: "+ dummyTail.prev.key);
            map.remove(dummyTail.prev.key);

            //we need to remove the tail node which is the least recently used node
            //dummyTail is pointing to the actual tail node so we pass dummyTail.prev to removeFromList method
            removeFromList(dummyTail.prev);
            cacheSize--;
        }
    }

    private void addToList(Node node) {
        /**
         Upon adding:

         1. We get current head that dummy head is pointing to
         2. We make currentHead prev point to the newly added node
         3. we make newly added node's prev point to dummyHead and newly added node's next point to the currentHead
         4. We make dummyHead point to the newly added node as the new head

         */
        Node currentHead = dummyHead.next;

        dummyHead.next = node;

        node.prev = dummyHead;
        node.next = currentHead;

        currentHead.prev = node;
    }

    private void removeFromList(Node node) {
        /**
         Upon deleting:

         1. We get the next & prev of the node to be deleted
         2. We make nodeToBeDeleted prev node point to nodeToBeDeleted's next node
         3. And we make nodeToBeDeleted's next node point to the nodeToBeDeleted's previous node
         */
        Node nodesPrev = node.prev;
        Node nodesNext = node.next;

        nodesPrev.next = nodesNext;
        nodesNext.prev = nodesPrev;
    }

    class Node {
        int key;
        int val;

        Node prev;
        Node next;

        public Node() {}

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
