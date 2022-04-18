package leetcode.graphs.trees.musts;

import leetcode.graphs.trees.Successor;
import leetcode.graphs.trees.TreeNode;

/**
 * Insert and delete a node
 */
public class TreeOperations {
    // find a null node to insert the element.
    public static void insertNode(TreeNode node , int val) {
        if(node.val < val) {
            if(node.right != null) {
                insertNode(node.right,val);
                return;
            } else {
                TreeNode newNode = new TreeNode(val);
                node.right = newNode;
                newNode.parent = node;
                return;
            }
        } else {
            if(node.left != null) {
                insertNode(node.left,val);
                return;
            } else {
                TreeNode newNode = new TreeNode(val);
                node.left = newNode;
                newNode.parent = node;
                return;
            }
        }
    }

    private static TreeNode transplant(TreeNode root,TreeNode deleteNode , TreeNode replacement) {
        // if root
        if(deleteNode == root) {
            root = replacement;
        }
        replacement.parent = deleteNode.parent;
        System.out.println(replacement.val);
        if(deleteNode.parent.left == deleteNode) {
            deleteNode.parent.left = replacement;
        } else {
            deleteNode.parent.right = replacement;
        }
        return root;
    }



public static void delinkNode(TreeNode node) {
        node.right = null;
        node.left = null;
        node.parent = null;
}

    /**
     * Contains 3 conditions
     * 1. Node is leaf node - simply delete
     * 2. Node has only 1 child - replace immediate child
     * 3. Node has 2 children -
     *      Find its successor
     *      3a -> if successor is immediate child - replace node with immediate child (successor is the smallest
     *      child that is greater than current node - left most child)
     *      3b -> if successor is not immediate child -> replace successors with its right child with and replace
     *      node with successor.
     */
    public static void deleteNode(TreeNode root , TreeNode nodeToDelete) {
        // 1.
        if(nodeToDelete.left == null && nodeToDelete.right == null) {
            // calling method to nullify the node.
            delinkNode(nodeToDelete);
            return;
        }
        // 2.
        if(nodeToDelete.right == null) {
            transplant(root,nodeToDelete,nodeToDelete.left);
        } else if(nodeToDelete.left == null){
            transplant(root,nodeToDelete,nodeToDelete.right);
        } else {
            //3.
            TreeNode successor = Successor.findSuccessor(nodeToDelete);
            // 3a - understood that there are no left children
            if(successor.parent == nodeToDelete) {
                System.out.println("Immediate Child");
                // nodeToDelete == successor.
                transplant(root,nodeToDelete,nodeToDelete.right);
                successor.left = nodeToDelete.left;
                nodeToDelete.left.parent = successor;
            } else {
                // 3b - replace the successor with the right subtree as its understood that there is no left subtree
                // replace nodeToDelete with successor.
                transplant(root,successor,successor.right);
                transplant(root,nodeToDelete,successor);
                successor.right = nodeToDelete.right;
                successor.left = nodeToDelete.left;
                nodeToDelete.right.parent = successor;
                nodeToDelete.left.parent = successor;
            }
        }
        delinkNode(nodeToDelete);
    }

    // Binary Search - O(logn) --> height of the tree.
    public static TreeNode retrieveNode(TreeNode root , int val) {
        if(root == null) {
            return null;
        }
        if(root.val == val) {
            return root;
        }
        return root.val > val ? retrieveNode(root.left,val) : retrieveNode(root.right,val);
    }



    public static void inOrderTraversal(TreeNode root) {
        while(root==null) {
            return;
        }

        inOrderTraversal(root.left);
        System.out.println("--> root -->" + root.val);
        inOrderTraversal(root.right);
    }

    public static void preOrderTraversal(TreeNode root) {
        while(root==null) {
            return;
        }

        System.out.println("--> root -->" + root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        insertNode(root,5);
        insertNode(root,18);
        insertNode(root,9);
        insertNode(root,15);
        insertNode(root,19);
        insertNode(root,2);
        insertNode(root,17);
        insertNode(root,13);
        insertNode(root,6);
        insertNode(root,7);
        insertNode(root,8);

        System.out.println("****** Insertion complete ***********");
        preOrderTraversal(root);

        TreeNode nodeToDelete = retrieveNode(root,5);

        deleteNode(root,nodeToDelete);

        System.out.println("****** Deletion complete ***********");
        preOrderTraversal(root);



    }

}
