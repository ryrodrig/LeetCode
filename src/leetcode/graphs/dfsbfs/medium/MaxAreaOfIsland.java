package leetcode.graphs.dfsbfs.medium;

/**
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.
 *
 * The area of an island is the number of cells with a value 1 in the island.
 *
 * Return the maximum area of an island in grid. If there is no island, return 0.
 *
 *Input: grid = [[0,0,1,0,0,0,0,1,0,0,0,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,1,1,0,1,0,0,0,0,0,0,0,0],[0,1,0,0,1,1,0,0,1,0,1,0,0],[0,1,0,0,1,1,0,0,1,1,1,0,0],[0,0,0,0,0,0,0,0,0,0,1,0,0],[0,0,0,0,0,0,0,1,1,1,0,0,0],[0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * Output: 6
 * Explanation: The answer is not 11, because the island must be connected 4-directionally.
 */
public class MaxAreaOfIsland {

    private int dfs(int[][] grid, int row, int col) {
        grid[row][col] = 0;
        int islandArea = 1;
        if((row-1)>=0 && grid[row-1][col] == 1) {
            int connIslArea = dfs(grid,row-1,col);
            islandArea += connIslArea;
        }
        if((row+1)<grid.length && grid[row+1][col] == 1) {
            int connIslArea = dfs(grid,row+1,col);
            islandArea += connIslArea;
        }
        if((col-1)>=0 && grid[row][col-1] == 1) {
            int connIslArea = dfs(grid,row,col-1);
            islandArea += connIslArea;
        }
        if((col+1)<grid[0].length && grid[row][col+1] == 1) {
            int connIslArea = dfs(grid,row,col+1);
            islandArea += connIslArea;
        }
        return islandArea;
    }

    public int maxAreaOfIsland(int[][] grid) {

        int rows = grid.length;
        int col= grid[0].length;
        int maxArea = 0;

        for(int i=0;i<rows;i++) {
            for(int j=0;j<col;j++) {
                if(grid[i][j] == 1) {
                    int islandArea = dfs(grid,i,j);
                    if(islandArea > maxArea) {
                        maxArea = islandArea;
                    }
                }
            }
        }

        return maxArea;

    }
}
