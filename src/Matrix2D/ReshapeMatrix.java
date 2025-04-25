package Matrix2D;

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] mat, int r,int c){

        int m = mat.length, n = mat[0].length;
        if(m*n != r*c){
            return mat;
        }

        int[][] reshaped = new int[r][c];
        int index = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    reshaped[index/c][index%c] = mat[i][j];
                    index++;
                }
            }
        return reshaped;
    }

    public int[][] matrixReshape1(int[][] mat, int r,int c){

        int m = mat.length, n = mat[0].length;
        if(m*n != r*c){
            return mat;
        }

        int[][] reshaped = new int[r][c];
        int index = 0;

        for (int i = 0; i <r; i++) {
            for (int j = 0; j < c; j++) {
                if(c == n){
                    c = 0;
                    r++;
                }
                reshaped[i][j] = mat[i][j];
                c++;
            }
        }
        return reshaped;
    }
}
