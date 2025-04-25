package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ks {
    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 2, 3};
        int w = 5;
        System.out.println(kp(w,val,wt));
    }

    private static int kp(int w, int[] val, int[] wt){
        int n = val.length;
        int[][] dp = new int[n+1][w+1];
        for(int i=1;i<=n;i++){
            for (int j = 1; j <=w ; j++) {
                int inc = Integer.MIN_VALUE;
                if(j>=wt[i-1]){
                    inc = val[i-1] + dp[i-1][j-wt[i-1]];
                }
                int exc = dp[i-1][j];
                dp[i][j] = Math.max(inc,exc);
            }
        }
        return dp[n][w];
    }

    private static int helper(int i, int w, int[] val, int[] wt,int[][] dp){
        if(i == 0 || w == 0) return 0;
        if(dp[i][w] != -1) return dp[i][w];
        int inc = Integer.MIN_VALUE;
        if(w>=wt[i-1]){
            inc = val[i-1] + helper(i-1,w-wt[i-1],val,wt,dp);
        }
        int exc = helper(i-1,w,val,wt,dp);
        dp[i][w] = Math.max(inc,exc);
        return dp[i][w];
    }
}
