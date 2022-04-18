package leetcode.graphs.trees.musts;

import leetcode.graphs.trees.TreeNode;

public class TreeRotations {


    /**
     * Towards left hand side
     *
     */
    public static void leftRotate(TreeNode root,TreeNode x) {
        if(x.right == null) {
            return;
        }
        TreeNode y = x.right;
        x.right = y.left;
        if(x.right != null) {
            x.right.parent = x;
        }
        if(root == x) {
            root = y;
            y.parent = null;
        } else {
        y.parent = x.parent;
        if(x.parent.left == x) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        }
        y.left = x;
        x.parent = y;

    }


    /**
     * Towards right hand side
     *
     */
    public static void rightRotate(TreeNode root,TreeNode x) {
        if(x.left == null) {
            return;
        }
        TreeNode y = x.left;
        x.left = y.right;
        if(x.left != null) {
            x.left.parent = x;
        }
        if(root == x) {
            root = y;
            y.parent = null;
        } else {
            y.parent = x.parent;
            if(x.parent.left == x) {
                x.parent.left = y;
            } else {
                x.parent.right = y;
            }
        }
        y.right = x;
        x.parent = y;

    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        TreeOperations.insertNode(root,5);
        TreeOperations.insertNode(root,18);
        TreeOperations.insertNode(root,9);
        TreeOperations.insertNode(root,15);
        TreeOperations.insertNode(root,19);
        TreeOperations.insertNode(root,2);
        TreeOperations.insertNode(root,17);
        TreeOperations.insertNode(root,13);
        TreeOperations.insertNode(root,6);
        TreeOperations.insertNode(root,7);
        TreeOperations.insertNode(root,8);

        System.out.println("****** Insertion complete ***********");
        TreeOperations.preOrderTraversal(root);

        TreeNode node = TreeOperations.retrieveNode(root, 5);

        leftRotate(root,node);

        System.out.println("****** Left Rotate complete ***********");
        TreeOperations.preOrderTraversal(root);

         node = TreeOperations.retrieveNode(root, 9);
         rightRotate(root,node);

        System.out.println("****** Right Rotate complete ***********");
        TreeOperations.preOrderTraversal(root);
    }

}
