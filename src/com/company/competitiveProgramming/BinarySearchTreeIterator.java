package com.company.competitiveProgramming;

import java.util.Stack;

public class BinarySearchTreeIterator {
    /**
     There are 2 ways to solve this problem.
     1. We traversal the entire tree in order and put the values in an arrayList and than upon next() we return value at index i & than increment index variable i by 1. This will take O(N) memory
     2. Since the question asks us to use only O(H) memory at a time,

     it means we can traverse only 1 branch of the tree at a time i-e; either left->left-> until leaf or left->right->left (in case a node doesn't have left child)

     what it essentially means is that at each level we just add 1 of the 2 nodes in a data structure until we reach leaf node. THis way our SC at a given
     time will be O(H)

     In order to acheive that, we use stack

     since in BST the left subtree is always smaller in value that right subtree & in order traversal of BST gives us a sorted list

     We start visiting nodes from root and push the current onto the stack first and than get its left node until we've no more left nodes

     Now the top of our stack will have the smallest value and all the previous nodes i-e; parent, grandparent etc nodes are also in the stack.
     When the user calls next(), we pop the stack to get the node which is the smallest value node

     Than we check if this node has a right node or not. The reason we do that is cuz in BST left node is the smallest, middleNode/parent is bigger than left & smaller than right & right node is the biggest value node in the tree.

     And if the node we popped from the stack right now is a node that has right node, we need to explore this node & check if this right node
     has a left subtree cuz its left subtree will also have the next smallest value.

     That's how we traverse the entire tree in O(N) while keeping O(H) SC
     */

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private Stack<TreeNode> nodesStack;

    public BinarySearchTreeIterator(TreeNode root) {
        nodesStack = new Stack();
        inorderLeftSubtreeTraversal(root);
    }

    /** @return the next smallest number */
    public int next() {

        TreeNode smallestNode = nodesStack.pop();

        if(smallestNode.right != null)
            inorderLeftSubtreeTraversal(smallestNode.right);

        return smallestNode.val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return nodesStack.size() > 0;
    }

    private void inorderLeftSubtreeTraversal(TreeNode node) {
        while(node != null) {
            nodesStack.push(node);
            node = node.left;
        }
    }
}
