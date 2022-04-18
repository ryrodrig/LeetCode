package leetcode.graphs.dfsbfs.application;

/**
 * This type of BFS is used to find the shortest distance between two nodes in a graph provided that the edges in the graph have the weights 0 or 1. If you apply the BFS explained earlier in this article,
 * you will get an incorrect result for the optimal distance between 2 nodes.
 */
public class WeightedGraphImpl {

    // Array to hold weights
    Integer edges[][] = new Integer[5][5];

    {
        // no edge
        edges[0][0] = null;
        edges[0][1] = 1;
        edges[0][2] = 1;
        edges[0][3] = 0;

        // no edge
        edges[1][0] = 1;
        edges[1][4] = 0;

        // no edge
        edges[2][0] = 1;
        edges[2][3] = 0;

        // no edge
        edges[3][0] = 0;
        edges[3][2] = 0;
        edges[3][4] = 0;

        // no edge
        edges[4][0] = null;
        edges[4][1] = 0;
        edges[4][3] = 0;

    }


//    private int calculateShortestPathWeight(int source) {
//
//    }


}