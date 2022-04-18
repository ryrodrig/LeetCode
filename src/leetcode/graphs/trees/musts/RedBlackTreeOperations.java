package leetcode.graphs.trees.musts;

import leetcode.graphs.trees.TreeNode;

public class RedBlackTreeOperations {

    private TreeOperations treeOperations;

    private void fixViolations(RedBlackNode root,RedBlackNode node) {
        // if the node is black its understood that the violations are all resolved.
        RedBlackNode parent = node.parent;

        while(parent != null && !parent.isBlack) {
            RedBlackNode grandParent = parent.parent;
            if(parent == grandParent.left) {
                RedBlackNode uncle = (RedBlackNode) grandParent.right;
                if(!uncle.isBlack) {
                    // case 1 - change the color of P , G , U
                    uncle.isBlack = true;
                    parent.isBlack = true;
                    grandParent.isBlack = false;
                    // check for violation with node/z being the grandparent.
                    node = grandParent;
                    parent = grandParent.parent;
                }
            } else {
                // case 2 : uncle is black
                //      2a: "P" and "N" are left children
                //           Change the color of "P" to black
                //           Change the color of "G" to red
                //           Right rotate on "G"
                //      2b: "P" is left child "N" is right child
                //           left rotate on "P"
                //           make "P" as the node - this would result in case 2a.
                // if child is a right child of the parent.
                if(node == parent.right) {
                    // Ensure G, P, N are in the same line.
                    // Make the "P" as the new node ( this would represent case 2a)
                    TreeRotations.leftRotate(parent,node);
                    node = parent;
                }
                parent = node.parent;
                grandParent = parent.parent;
                parent.isBlack = true;
                grandParent.isBlack = false;
                TreeRotations.rightRotate(grandParent,parent);
            }
        }
        root.isBlack =  true;
    }

    private boolean checkBlack(RedBlackNode node) {
        if(node == null || node.isBlack) {
            return true;
        }
        return false;
    }


    public void insert(RedBlackNode root, RedBlackNode node , int val) {
        treeOperations.insertNode(node,val);
        if(node.parent == null) {
            // root node
            node.isBlack = true;
        }
        fixViolations(root,node);
    }


}
