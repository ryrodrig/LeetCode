package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

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


    public static List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }
        List<Integer> preOrderList = new ArrayList<Integer>();
        preOrderList.add(root.val);
        List<Integer> leftSubtree = preorderTraversal(root.left);
        List<Integer> rightSubtree = preorderTraversal(root.right);
        if(leftSubtree !=null) {
            preOrderList.addAll(leftSubtree);
        }
        if(rightSubtree !=null) {
            preOrderList.addAll(rightSubtree);
        }
        return preOrderList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null, new TreeNode(2,new TreeNode(3,null,null), null));
        preorderTraversal(root).stream().forEach(System.out::println);
    }
}
