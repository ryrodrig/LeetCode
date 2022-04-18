package leetcode.graphs.trees;

public class MaximumDepthBinaryTree {

    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        int myMaxDepth = leftDepth > rightDepth ?  (leftDepth + 1) : (rightDepth + 1);
        return myMaxDepth;
    }
}
