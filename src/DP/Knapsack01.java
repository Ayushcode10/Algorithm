package DP;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Knapsack01 {

    public static void main(String[] args) {
        int[] val = {10, 40, 30, 50};
        int[] wt = {5, 4, 2, 3};
        int w = 5;
        System.out.println(tab(w,val,wt));
    }
    public static int knapsack(int w, int[] val, int[]wt){
        int n = val.length;
        int[][] dp = new int[n+1][w+1];
        for(int[] r : dp){
            for(int i : r){
                Arrays.fill(r,-1);
            }
        }
        return MEMO(n,w,val,wt,dp);
    }


    private static int tab(int w, int[] val, int[] wt){
        int n = val.length;
        int[][] dp = new int[n+1][w+1];
        for (int i = 1; i <=n ; i++) {
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


    //Memoization (O(nW)) np hard
    private static int MEMO(int i, int w, int[] val, int[] wt, int[][] dp){
        if(i == 0 || w == 0) return 0;
        if(dp[i-1][w] != -1){
            return dp[i-1][w];
        }
        int inc = Integer.MIN_VALUE;
        if(w>=wt[i-1]){
            inc = val[i-1] + MEMO(i-1,w-wt[i-1],val,wt,dp);
        }
        int exc = MEMO(i-1,w,val,wt,dp);
        dp[i-1][w] = Math.max(inc,exc);
        return dp[i-1][w];
    }

    //recursive solution (O(2^n))
    private static int helper(int i, int w, int[] val, int[] wt){
        if(i == 0 || w == 0) return 0;

        int inc = Integer.MIN_VALUE;
        if(wt[i-1]<=w){
            inc = val[i-1] + helper(i-1,w-wt[i-1],val,wt);
        }
        int exc = helper(i-1,w,val,wt);
        return Math.max(inc,exc);
    }
}
