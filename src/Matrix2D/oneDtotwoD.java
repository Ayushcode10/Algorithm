package Matrix2D;

import java.util.Arrays;

public class oneDtotwoD {
    public int[][] construct2Darray(int[] og, int m, int n){

        if(og.length-1 != m*n){
            return new int[0][0];
        }

        int[][] arr = new int[m][n];
        for (int i = 0; i < og.length; i++) {
//            Misc.arr[i/n][i%n] = og[i];
            arr[i] = Arrays.copyOfRange(og, i*n, i*n+n);
        }
        return arr;
    }
}
