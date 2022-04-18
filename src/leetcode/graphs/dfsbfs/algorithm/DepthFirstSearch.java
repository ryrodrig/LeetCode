package leetcode.graphs.dfsbfs.algorithm;

import leetcode.Node;
import leetcode.Stack;

/**
 * Iterative approach.
 *
 *  read node and push adjacent nodes to stack and continue performing the same for other nodes
 */
public class DepthFirstSearch {

    private Stack<Node> stack = new Stack<>();

    public void dfs(Node root) {
        stack.push(root);
        root.visited=true;
        while(!stack.isEmpty()) {
            Node top = stack.pop();
            if(top.right !=null && !top.right.visited) {
                stack.push(top.right);
                top.right.visited = true;
            }

            if(top.left !=null && !top.left.visited) {
                stack.push(top.left);
                top.left.visited = true;
            }

            System.out.println(" --> " + top.val);
        }
    }


    public static void main(String[] args) {
        // Tree
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node2 = new Node(2,node4,node5,null);
        Node node3 = new Node(3);
        Node node1 = new Node(1,node2,node3,null);
        DepthFirstSearch depthFirstSearch = new DepthFirstSearch();
        depthFirstSearch.dfs(node1);

        // UnDirected Graph
        Node undA = new Node(1);
        Node undB = new Node(2);
        Node undC = new Node(3);
        Node undD = new Node(4);
        Node undE = new Node(5);
        Node undF = new Node(6);

        undA.left = undE;
        undA.right = undC;

        undB.left = undC;
        undB.right = undF;

        undC.left = undB;
        undC.right = undD;

        undD.left = undF;
        undD.right = undC;

        undE.left = undA;
        undE.right = undC;

        System.out.println("********************************************");
        depthFirstSearch.dfs(undA);
        System.out.println("********************************************");
    }

}
