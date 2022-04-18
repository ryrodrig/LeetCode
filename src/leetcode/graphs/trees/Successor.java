package leetcode.graphs.trees;

public class Successor {

    public static TreeNode findMinimum(TreeNode node) {
        if(node.left != null) {
            return findMinimum(node.left);
        }
        return node;
    }

    public static TreeNode findSuccessor(TreeNode node) {
        // if right tree exist the min value greater than current node is the successor.
        if(node.right !=null) {
            return findMinimum(node.right);
        }
// if node has no right subtree than go up the tree until one node is the left child or we reach the root of the tree.
        TreeNode parent = node.parent;
        while(parent!= null && node == parent.right) {
            node = parent;
            parent = node.parent;
        }
        return node;
    }

}
