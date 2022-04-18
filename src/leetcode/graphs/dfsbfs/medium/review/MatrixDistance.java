package leetcode.graphs.dfsbfs.medium.review;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the distance of the nearest 0 for each cell.
 *
 * The distance between two adjacent cells is 1.
 *
 * https://leetcode.com/problems/01-matrix/
 */
public class MatrixDistance {

    // Solution from others solution tab. DP
    // 2 iterations - top to bottom check left and top
    // bottom to top check right and bottom.
    // need 2 iterations - make sure the nodes are visited.
//    public int[][] updateMatrix(int[][] mat) {
//        int rows = mat.length;
//        int cols = mat[0].length;
//        int[][] distance = new int[rows][cols];
//        int maxVal = rows * cols;
//        for(int i=0;i<rows;i++) {
//            for(int j=0;j<cols;j++) {
//                distance[i][j] = maxVal;
//            }
//        }
//
//        // First pass : top to bottom - left to right
//        for(int i=0;i<rows;i++) {
//            for(int j=0;j<cols;j++) {
//                if(mat[i][j] == 0) {
//                    distance[i][j] = 0;
//                } else {
//                    if(i>0) {
//                        distance[i][j] = distance[i][j] < (distance[i-1][j] + 1) ? distance[i][j] : (distance[i-1][j] + 1);
//                    }
//                    if(j>0) {
//                        distance[i][j] = distance[i][j] < (distance[i][j-1] + 1) ? distance[i][j] : (distance[i][j-1] + 1);
//                    }
//                }
//            }
//        }
//
//        for(int i=rows-1;i>=0;i--) {
//            for(int j=cols-1; j >=0;j--) {
//                if(i < rows-1) {
//                    distance[i][j] = distance[i][j] < (distance[i+1][j] + 1) ? distance[i][j] : (distance[i+1][j] + 1);
//                }
//                if(j < cols-1) {
//                    distance[i][j] = distance[i][j] < (distance[i][j + 1] + 1) ? distance[i][j] : (distance[i][j+1] + 1);
//                }
//            }
//        }
//
//        return distance;
//    }

    // Another solution that uses BFS and queue system...

    private void addToQueue(Queue<List<Integer>> queue , int row, int col) {
        List<Integer> element = new ArrayList<>();
        element.add(row);
        element.add(col);
        queue.add(element);
    }

    private void updateDistance(int[][] distance, Queue<List<Integer>> queue, int cr, int cc, int calculatedDistance) {
        if(distance[cr][cc] < calculatedDistance) {
            return;
        }
        distance[cr][cc] = calculatedDistance;
        addToQueue(queue,cr,cc);
    }

    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int[][] distance = new int[row][col];
        Queue<List<Integer>> queue = new LinkedList<>();

        // Initialize queue with index of arrays containing zeros.
        for(int i=0; i< row; i++) {
            for(int j=0;j< col; j++) {

                if(mat[i][j] == 0) {
                    addToQueue(queue,i,j);
                    distance[i][j] = 0;
                } else {
                    distance[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        // Find closest path from 0 to different ones/Max values
        while(!queue.isEmpty()) {
            List<Integer> currentElement = queue.remove();
            int cr = currentElement.get(0);
            int cc = currentElement.get(1);
            int calculatedDistance =(distance[cr][cc] + 1);
            // identify adjacent neighbours and their values. Update distance[][] so
            // they have the min of all the values.
            if(cr > 0) {
                // top neighbour
                // assign the smallest of the current value vs current node + 1 ( 1 node away from zero)
                updateDistance(distance,queue,cr-1,cc,calculatedDistance);
            }

            if(cc > 0) {
                // left neighbour
                // assign the smallest of the current value vs current node + 1 ( 1 node away from zero)
                updateDistance(distance,queue,cr,cc-1,calculatedDistance);

            }

            if(cr < row-1) {
                // bottom neighbour
                // assign the smallest of the current value vs current node + 1 ( 1 node away from zero)
                updateDistance(distance,queue,cr+1,cc,calculatedDistance);
            }

            if(cc < col-1) {
                // right neighbour
                // assign the smallest of the current value vs current node + 1 ( 1 node away from zero)
                // System.out.println("cr" + cr + "cc" + cc);
                updateDistance(distance,queue,cr,cc+1,calculatedDistance);
            }

        }
        return distance;
    }


}
