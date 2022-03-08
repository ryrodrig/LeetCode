package leetcode.trees.medium;

import leetcode.trees.TreeNode;

import java.util.ArrayList;
import java.util.List;
/*
  Root , Left , Right - Print nodes at every level.
 */
public class LevelOrderTraversal {


    public static List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        while(!queue.isEmpty()) {
            int currentLevelSize = queue.size();
            List<Integer> subResult = new ArrayList<>();
            int i = 0;
            while(i<currentLevelSize) {
                TreeNode currentNode = queue.remove(0);
                subResult.add(currentNode.val);
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if(currentNode.right != null) {
                    queue.add(currentNode.right);
                }
                i++;
            }
            result.add(subResult);
        }
        return result;
    }

}
