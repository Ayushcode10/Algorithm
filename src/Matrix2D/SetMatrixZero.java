package Matrix2D;

import java.util.Arrays;

public class SetMatrixZero {
    public static void main(String[] args) {
        int[][] arr= {{1,1,1},{1,0,1},{1,1,1}};
        setZeros(arr);
        System.out.println(Arrays.deepToString(arr));
    }

    public static void setZeros(int[][] mat){
        int m = mat.length, n = mat[0].length;
        boolean[] rows = new boolean[m];
        boolean[] cols = new boolean[n];

        for(int i = 0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(mat[i][j] == 0){
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for(int i = 0;i<m;i++){
            for (int j = 0; j < n; j++) {
                if(rows[i] || cols[j]){
                    mat[i][j] = 0;
                }
            }
        }
    }
}
