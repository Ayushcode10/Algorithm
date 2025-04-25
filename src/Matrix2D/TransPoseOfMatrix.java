package Matrix2D;

import java.util.Arrays;

public class TransPoseOfMatrix {
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(transpose(arr)));
    }


    //this only handles square matrices and does it in place
    public static int[][] transpose(int[][] arr){
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
        return arr;
    }
    //this also handles when m!=n, but needs extra space;
    public static int[][] transpose2(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int[][] res = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][i] = arr[i][j];
            }
        }
        return res;
    }
}
