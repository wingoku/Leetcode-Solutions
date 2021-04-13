package com.company.competitiveProgramming.premium;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

class Solution {
    Node head  = null;
    Node prev = null;
    public Node treeToDoublyList(Node root) {
        if(root == null)
            return null;

        dfs(root);

        prev.right = head;
        head.left = prev;

        return head;
    }


    /**
     4
     /     \
     2        5
     /   \
     1     3
     */
    private void dfs(Node node) {
        if(node == null)
            return;

        dfs(node.left);

        //this condition will be hit the first time only when we've reached the left most leaf node in the tree.
        //that node should be the head of the list cuz in sorted list representation of a BST, the left most leaf node is always the start of the list
        if(prev == null) {
            head = node;
        }
        else {
            //this condition will be hit everytime a node has traversed its left child EXCEPT for the very first left most leaf node
            //Eg. consider the node with value 2
            //when it has traversed its left child i-e; node 1
            //now we need to develop prev and next connection between node 2 and node 1
            //cuz that's how doubly linked list works
            //prev already contains node 1 from node 1's recursion
            //we want to make a connection such that 1->2  & 1<-2
            //i-e; 1's next/right is node 2 and node 2's left is node 1
            //so in the following code, node.left means 2.left = node1 cuz prev contains node 1 reference
            //and prev.right = node means node1.right = node 2
            node.left = prev;
            prev.right = node;
        }

        //once we've explored the left subtree of a node, we make this node has the previous node cuz for the right subtree
        //this node is previous node when we think in terms of in order traversal
        prev = node;

        dfs(node.right);
    }
}