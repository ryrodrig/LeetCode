package leetcode.graphs.dfsbfs.medium;

import leetcode.Node;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
 *
 * Initially, all next pointers are set to NULL.
 *
 * Input: root = [1,2,3,4,5,6,7]
 * Output: [1,#,2,3,#,4,5,6,7,#]
 * Explanation: Given the above perfect binary tree (Figure A), your function should populate each next pointer to point to its next right node, just like in Figure B. The serialized output is in level order as connected by the next pointers, with '#' signifying the end of each level.
 */
public class NextRightPointers {


    // O(1) - space complexity
// O(N) - Time Complexity.
// public void connect(TreeLinkNode root) {
//         TreeLinkNode level_start=root;
//         while(level_start!=null){
//             TreeLinkNode cur=level_start;
//             while(cur!=null){
//                 if(cur.left!=null) cur.left.next=cur.right;
//                 if(cur.right!=null && cur.next!=null) cur.right.next=cur.next.left;

//                 cur=cur.next;
//             }
//             level_start=level_start.left;
//         }
//     }


    // O(n) - time complexity
    // 0(n) - space complexity
    // Check above solution.
    public Node connect(Node root) {

        if(root == null) {
            return null;
        }
        List<Node> queue = new ArrayList<Node>();
        queue.add(root);
        double level = 0;
        int startPtr = 0;
        int queueLength = 1;
        while(startPtr<queueLength) {
            double levelNodes = Math.pow((double)2,level);
            Node prevNode = null;
            Node currentNode = null;
            while(levelNodes > 0) {
                prevNode = currentNode;
                currentNode = queue.get(startPtr++);
                if(currentNode.left != null) {
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);
                    queueLength += 2;
                }
                if(prevNode !=null) {
                    prevNode.next = currentNode;
                }
                levelNodes--;
            }
            currentNode = null;
            level++;
        }
        return root;

    }
}
