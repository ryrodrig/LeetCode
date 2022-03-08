package leetcode.trees;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

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


    public static List<Integer> postorderTraversal(TreeNode root) {
        if(root == null) {
            return new ArrayList<Integer>();
        }

        List<Integer> leftSubtree = postorderTraversal(root.left);
        List<Integer> rightSubtree = postorderTraversal(root.right);
        List<Integer> postOrderList = new ArrayList<Integer>();

        leftSubtree.remove(0);
        if(leftSubtree !=null) {
            postOrderList.addAll(leftSubtree);
        }
        if(rightSubtree !=null) {
            postOrderList.addAll(rightSubtree);
        }
        postOrderList.add(root.val);
        return postOrderList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,null, new TreeNode(2,new TreeNode(3,null,null), null));
        postorderTraversal(root).stream().forEach(System.out::println);
    }
}
