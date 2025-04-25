package DP;

import java.util.Arrays;

public class LIS {
    public static void main(String[] args) {
        int[] arr = {10,9,2,5,3,7,101,18};
        System.out.println(tab(arr));
    }
    public static int lenOfLIS(int[] arr){
        int n = arr.length;
        int[][] dp = new int[n][n+1];
        for(int[] r : dp){
            Arrays.fill(r,-1);

        }
        return helper(0,-1,arr,dp);
    }


    private static int tab(int[] arr){
        int n = arr.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp,1);
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<n;i++){
            int temp = 0;
            for(int j = i-1;j>=0;j--){
                if(arr[j] < arr[i])
                    temp = Math.max(temp,dp[j]);
            }
            dp[i] = 1 + temp;
        }
        return Math.max(max,dp[n-1]);
    }
    private static int helper(int i, int prev, int[] arr,int[][] dp){
        if(i == arr.length) return 0;
        int inc = Integer.MIN_VALUE;
        if(dp[i][prev+1] != -1) return dp[i][prev+1];
        if(prev == -1 || arr[i] > arr[prev]){
            inc = 1+helper(i+1,i,arr,dp);
        }
        int exc = helper(i+1,prev,arr,dp);
        dp[i][prev+1] = Math.max(inc,exc);
        return dp[i][prev+1];
    }
}
