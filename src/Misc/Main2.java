package Misc;

import java.util.Arrays;
import java.util.PropertyPermission;

public class Main2 {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4}};
        System.out.println(Arrays.deepToString(ans(arr)));
    }

    public static int[][] ans(int[][] og){
        int m = og.length;
        int n = og[0].length;
        int[][] res = new int[m+1][n+1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[i+1][j+1] = og[i][j] + res[i][j+1] +
                        res[i+1][j] - res[i][j];
            }
        }
        return res;
    }

}
