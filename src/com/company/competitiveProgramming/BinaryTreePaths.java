package com.company.competitiveProgramming;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    class TreeNode {
        String val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(String val) { this.val = val; }
        TreeNode(String val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public TreeNode createDataSet(List<Integer> dataSet) {
        TreeNode rootNode = new TreeNode("1");
        rootNode.left = new TreeNode("2");
        rootNode.right = new TreeNode("3");

        rootNode.left.right = new TreeNode("5");

        binaryTreePaths(rootNode);

        return rootNode;
    }

    public List<String> binaryTreePaths(TreeNode root) {

        if(root == null)
            return new ArrayList<>();

        List<String> paths = new ArrayList<>();
        dfs(root, paths, "");
        return paths;
    }


    private boolean dfs(TreeNode node, List<String> paths, String s) {
        if(node == null) {
            return false;
        }

        if(node.left == null && node.right == null) {
            s+=node.val;
            paths.add(s);
            return true;
        }

        String temp = s+node.val+"->";

        dfs(node.left, paths, temp);
        dfs(node.right, paths, temp);

        return false;
    }
}
