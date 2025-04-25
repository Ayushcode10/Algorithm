package Matrix2D;

public class BooleanMatrix {
    public static void main(String[] args) {

    }
    public static void bool(int[][] arr){
        int m = arr.length, n = arr[0].length;
        boolean[] row  = new boolean[m];
        boolean[] col  = new boolean[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(arr[i][j] == 1){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(row[i] || col[i]){
                    arr[i][j]= 1;
                }
            }
        }
    }
}
