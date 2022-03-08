package leetcode;

public class ReshapeTheMatrix {
    public static int[][] matrixReshape(int[][] mat, int r, int c) {
        if((mat.length * mat[0].length) != (r * c)) {
            return mat;
        }

        int xSrcAxis = 0;
        int ySrcAxis = 0;
//        int xDestAxis = 0;
//        int yDestAxis = 0;
//        int ctr = 0;
        int[][] destMat = new int[r][c];
        for(int i =0 ; i < r; i ++) {
            for(int j=0; j< c ; j++) {
                if(ySrcAxis >= mat.length) {
                    xSrcAxis ++;
                    ySrcAxis=0;
                }
                destMat[i][j] = mat[xSrcAxis][ySrcAxis];
            }

        }
    return destMat;

    }

    public static void main(String[] args) {
        int[][] matrix = new int[2][2];
        matrixReshape(matrix , 2 ,2);
    }
}
