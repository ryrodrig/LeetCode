package leetcode.graphs.dfsbfs.easy;

/**
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 *
 * You are also given three integers sr, sc, and newColor. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with newColor.
 *
 * Return the modified image after performing the flood fill.
 *
 * https://leetcode.com/problems/flood-fill/
 *Input: image = [[1,1,1],[1,1,0],[1,0,1]], sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation: From the center of the image with position (sr, sc) = (1, 1) (i.e., the red pixel), all pixels connected by a path of the same color as the starting pixel (i.e., the blue pixels) are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected to the starting pixel.
 */
public class FloodFill {

    private void floodFillRecursive(int[][] image, int sr, int sc, int newColor,boolean[][] visited) {
        int rows = image.length;
        int columns = image[0].length;
        int pixelValue = image[sr][sc];
        image[sr][sc] = newColor;
        visited[sr][sc] = true;

        if((sr-1)>=0 && (sr-1)<rows && image[sr-1][sc] == pixelValue && (!visited[sr-1][sc])) {
            System.out.println("visited[sr-1][sc]" + visited[sr-1][sc]);
            floodFillRecursive(image,sr-1,sc,newColor,visited);
        }
        if((sr+1)>=0 && (sr+1)<rows && image[sr+1][sc] == pixelValue && (!visited[sr+1][sc])) {
            System.out.println("visited[sr+1][sc]" + visited[sr+1][sc]);
            floodFillRecursive(image,sr+1,sc,newColor,visited);
        }
        if((sc-1)>=0 && (sc-1)<columns && image[sr][sc-1] == pixelValue && (!visited[sr][sc-1])) {
            System.out.println("visited[sr][sc-1]" + visited[sr][sc-1]);
            floodFillRecursive(image,sr,sc-1,newColor,visited);
        }
        if((sc+1)>=0 && (sc+1)<columns && image[sr][sc+1] == pixelValue && (!visited[sr][sc+1])) {
            System.out.println("visited[sr][sc+1]" + visited[sr][sc+1]);
            floodFillRecursive(image,sr,sc+1,newColor,visited);
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        boolean[][] visited = new boolean[image.length][image[0].length];
        floodFillRecursive(image,sr,sc,newColor,visited);
        return image;

    }

}
