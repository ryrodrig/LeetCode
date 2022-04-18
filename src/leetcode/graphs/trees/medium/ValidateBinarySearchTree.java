package leetcode.graphs.trees.medium;

import leetcode.graphs.trees.TreeNode;

/*
98. Validate Binary Search Tree

Given the root of a binary tree, determine if it is a valid binary search tree (BST).

A valid BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.


 */
public class ValidateBinarySearchTree {

    //     public List<Integer> inorder(TreeNode root) {
//         if(root == null) {
//             return new ArrayList<Integer>();
//         }
//         List<Integer> leftTreeVal = inorder(root.left);
//         List<Integer> rightTreeVal = inorder(root.right);
//         List<Integer> result = new ArrayList<>();
//         result.addAll(leftTreeVal);
//         result.add(root.val);
//         result.addAll(rightTreeVal);
//         return result;
//     }

//     public boolean isValidBST(TreeNode root) {
//         List<Integer> results = inorder(root);
//             for(int i=1; i<results.size(); i++) {
//                 if(results.get(i-1) >= results.get(i)) {
//                     return false;
//                 }
//             }

//         return true;
//     }


    public boolean isValidBST(TreeNode root, long lowerLimit , long higherLimit) {
        if(root == null) {
            return true;
        }

        if(root.val <= lowerLimit || root.val >= higherLimit) {
            return false;
        }

        return isValidBST(root.left, lowerLimit, root.val) && isValidBST(root.right, root.val, higherLimit);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE , Long.MAX_VALUE);
    }

}
