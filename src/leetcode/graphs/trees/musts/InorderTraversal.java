package leetcode.graphs.trees.musts;

import java.util.ArrayList;
import java.util.List;

/**
 * left root right
 * Sorted element.
 */
public class InorderTraversal {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> leftSubtree = inorderTraversal(root.left);
        List<Integer> rightSubtree = inorderTraversal(root.right);

        List<Integer> inOrderList = new ArrayList<Integer>();
        if(leftSubtree !=null) {
            inOrderList.addAll(leftSubtree);
        }
        inOrderList.add(root.val);
        if(rightSubtree !=null) {
            inOrderList.addAll(rightSubtree);
        }
        return inOrderList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null, new TreeNode(2,new TreeNode(3,null,null), null));
        inorderTraversal(root).stream().forEach(System.out::println);
    }
}
