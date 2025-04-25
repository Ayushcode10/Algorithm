package Matrix2D;

import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(rotate(arr)));
    }

    public static int[][] rotate(int[][] mat) {

        //transpose the matrix
        int n = mat.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int t1 = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = t1;
            }
        }
        //reverse the transposed matrix
        for(int i = 0; i<n;i++){
            for(int j=0;j<n/2;j++){
                int t2 = mat[i][j];
                mat[i][j] = mat[i][n-j-1];
                mat[i][n-j-1] = t2;
            }
        }
        return mat;
    }
}
