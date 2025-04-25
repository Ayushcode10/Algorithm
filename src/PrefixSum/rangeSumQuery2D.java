package PrefixSum;

public class rangeSumQuery2D {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        rangeSumQuery2D a = new rangeSumQuery2D(arr);
        System.out.println(ans(0,0,2,0));
    }

    private static int[][] pre;
    public rangeSumQuery2D(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        pre = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i+1][j+1] = arr[i][j] 
                                + pre[i][j+1] 
                                + pre[i+1][j]
                                - pre[i][j];
            }
        }
    }
    
    public static int ans(int  r1, int c1, int r2, int c2){
        return pre[r2+1][c2+1]
                - pre[r1][c2+1]
                - pre[r2+1][c1]
                + pre[r1][c1];
    }
    
    
}
