package leetcode.graphs.trees.musts;

import leetcode.graphs.trees.TreeNode;

public class RedBlackNode extends TreeNode {

    public boolean isBlack;

    public RedBlackNode parent;

    public RedBlackNode(int val, TreeNode left, TreeNode right) {
        super(val,left,right);
        isBlack = false;
    }

}
