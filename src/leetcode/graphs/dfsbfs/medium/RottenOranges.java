package leetcode.graphs.dfsbfs.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * You are given an m x n grid where each cell can have one of three values:
 *
 * 0 representing an empty cell,
 * 1 representing a fresh orange, or
 * 2 representing a rotten orange.
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.
 *
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.
 */

// Represents a BFS pattern.
public class RottenOranges {

    private void rotAdjacentElement(int[][] grid,int[][] rottenPeriod,List<List<Integer>> queue , int cr , int cc, int rottenMinute) {
        if(grid[cr][cc] == 1) {
            grid[cr][cc] = 2;
            List<Integer> element = new ArrayList<>();
            element.add(cr);
            element.add(cc);
            rottenPeriod[cr][cc] = rottenMinute;
            queue.add(element);

        }
    }

    public int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;
        int[][] rottenPeriod = new int[grid.length][grid[0].length];
        int rottenMinutes = 0;
        List<List<Integer>> queue = new ArrayList<>();
        int totalNumber = 0;
        // intial rotten oranges
        for (int i=0 ; i< rows;i++) {
            for(int j=0;j<cols;j++) {
                if(grid[i][j] == 2) {
                    rottenPeriod[i][j] = 0;
                    rottenMinutes = 0;
                    List<Integer> element = new ArrayList<>();
                    element.add(i);
                    element.add(j);
                    totalNumber++;
                    queue.add(element);
                } else if(grid[i][j] == 1){
                    rottenPeriod[i][j] = Integer.MAX_VALUE;
                    totalNumber++;
                }
            }
        }

        while(!queue.isEmpty()) {

            List<Integer> element = queue.remove(0);
            totalNumber--;
            int cr = element.get(0);
            int cc = element.get(1);
            // System.out.println("cr: " + cr + " cc:" + cc);
            rottenMinutes = rottenPeriod[cr][cc]+1;
            if(cr > 0) {
                rotAdjacentElement(grid,rottenPeriod,queue,cr-1,cc,rottenMinutes);
            }
            if(cc > 0) {
                rotAdjacentElement(grid,rottenPeriod,queue,cr,cc-1,rottenMinutes);
            }
            if(cr<rows-1) {
                rotAdjacentElement(grid,rottenPeriod,queue,cr+1,cc,rottenMinutes);
            }
            if(cc<cols-1) {
                rotAdjacentElement(grid,rottenPeriod,queue,cr,cc+1,rottenMinutes);
            }

        }

        // for (int i=0 ; i< rows;i++) {
        //     for(int j=0;j<cols;j++) {
        //         if(grid[i][j] == 1)
        //             return -1;
        //     }
        // }

        if(totalNumber > 0) {
            return -1;
        }

        return rottenMinutes == 0 ? rottenMinutes : (rottenMinutes-1);
    }
}
