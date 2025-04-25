package Matrix2D;

import java.util.Arrays;

public class SpiralII {
    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(gen(3)));
    }
    public static int[][] gen(int n){
        int[][] arr = new int[n][n];
        int srow = 0, scol = 0;
        int erow = n-1, ecol = n-1;
        int count = 1;
        int t = 0;

        while(t < n*n){
            for(int i = scol;i<=ecol;i++) {
                arr[srow][i] = count;
                count++;
            }
            srow++;
            for(int i = srow;i<=erow;i++) {
                arr[i][ecol] = count;
                count++;
            }
            ecol--;
            for(int i = ecol;i>=scol;i--) {
                arr[erow][i] = count;
                count++;
            }
            erow--;
            for(int i = erow;i>=srow;i--) {
                arr[i][scol] = count;
                count++;
            }
            scol++;
            t++;
        }
        return arr;
    }

}
