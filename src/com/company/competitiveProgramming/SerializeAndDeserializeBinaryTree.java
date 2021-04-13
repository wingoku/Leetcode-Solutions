package com.company.competitiveProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {
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
    //we don't care about removing the trailing nulls added in the string of the serialized form of the tree.
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        StringBuilder sb = new StringBuilder();

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i=0; i<size; i++) {
                TreeNode node = q.poll();

                if(node != null) {
                    sb.append(node.val);
                    q.add(node.left);
                    q.add(node.right);
                }
                else
                    sb.append("null");

                sb.append(",");
            }
        }

        sb.setLength(sb.length()-1);

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        if(nodes[0].equals("null"))
            return null;

        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(nodes[0]));

        q.add(root);


        while(!q.isEmpty()) {

            //[1,2,3,null,null,4,5,7,null,9,null,null,10,11]
            //Think of the array above. The reason we're iterating over the array to add nodes in the q and not adding nodes
            //in the q level by level is because we don't really need level by level order traversal because all we care about
            //is iterating over the array & creating and adding left & right nodes to the current parent node & the q
            //we keep populating the q with the new nodes we create and we iterate over the array for the next 2 nodes i-e; left & right node
            //and therefore looping over this loop is sufficient
            for(int i=1; i<nodes.length; i++) {
                TreeNode parent = q.poll();

                if(!nodes[i].equals("null")) {
                    TreeNode leftNode = new TreeNode(Integer.parseInt(nodes[i]));
                    parent.left = leftNode;

                    q.add(parent.left);
                }

                i++;

                if(!nodes[i].equals("null")) {
                    TreeNode rightNode = new TreeNode(Integer.parseInt(nodes[i]));
                    parent.right = rightNode;

                    q.add(parent.right);
                }
            }
        }

        return root;
    }
}
