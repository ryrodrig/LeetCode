package leetcode.graphs.trees;

import java.util.ArrayList;
import java.util.List;

/*
Given the root of a Binary Search Tree and a target number k,
return true if there exist two elements in the BST such that their sum is equal to the given target.
 */
public class TwoSumInBST {

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> remainderList = new ArrayList<>();
        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode currentNode = queue.remove(0);
            if(remainderList.contains(currentNode.val)) {
                return true;
            }
            remainderList.add(k - currentNode.val);
            if(currentNode.left != null)
                queue.add(currentNode.left);
            if(currentNode.right != null)
                queue.add(currentNode.right);
        }

        return false;
    }
}
