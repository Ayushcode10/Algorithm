package PrefixSum;

import java.util.Arrays;

public class MatrixBlockSum {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(Arrays.deepToString(sum(arr,1)));
    }
//    public static void fxn(int[][] answer, int[][] matrix, int i, int j, int m, int n, int k){
//        int r1 = i-k, r2 =  i+k;
//        if(r1<0) r1 = 0;
//        if(r2>=n) r2=n-1;
//        int c1 = j-k, c2 = j+k;
//        if(c1<0) c1 = 0;
//        if(c2>=m) c2 = m-1;
//        int temp = 0;
//        for (int l = r1; l < r2; l++) {
//            for (int o = c1; o < c2; o++) {
//                temp = matrix[l][o];
//            }
//            answer[i][j] = temp;
//        }
//    }




    public static int[][] sum(int[][] mat, int k){
        int m = mat.length, n = mat[0].length;
        int[][] ans = new int[m][n];
        int[][] pre = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i+1][j+1] = mat[i][j] + pre[i+1][j]
                                +pre[i][j+1] - pre[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0,i-k), r2 = Math.min(m-1,i+k);
                int c1 = Math.max(0,j-k), c2 = Math.min(n-1,j+k);
                r1++;r2++;c1++;c2++;

                ans[i][j] = pre[r2][c2] - pre[r1-1][c2] -
                            pre[r2][c1-1] + pre[r1-1][c1-1];
            }
        }
        return ans;

    }
}
