package DP;

import java.util.Arrays;

public class MaxAlternateSubseqSum {
    public static void main(String[] args) {
        int[] arr = {4,2,5,3};
        System.out.println(maxAlternatingSum(arr));
    }
    public static long maxAlternatingSum(int[] nums) {
//        int n = nums.length;
//        long[][] dp = new long[n][2];
//        return dpmax(nums,0,1,dp);
        return helper(nums,0,1);
    }


    private static int helper(int[] arr, int i, int isEven){
        if(i == arr.length) return 0;
        int take;
        if(isEven==1){
            take = arr[i] + helper(arr,i+1,0);
        }
        else {
            take = -arr[i] + helper(arr,i+1,1);
        }
        int skip = helper(arr,i+1,isEven);
        return Math.max(take,skip);
    }

    private static long dpmax(int[] arr, int i,int isEven, long[][] dp){
        if(i==arr.length) return 0;
        if(dp[i][isEven] != 0) {
            return dp[i][isEven];
        }
        long take;
        if(isEven==1){
            take = arr[i] + dpmax(arr,i+1,0,dp);
        }
        else{
            take = -arr[i] + dpmax(arr,i+1,1,dp);
        }
        long skip = dpmax(arr,i+1,isEven,dp);
        dp[i][isEven] = Math.max(take,skip);
        return dp[i][isEven];
    }

    private static long tab(int[] arr, int i){
        if(i == arr.length) return 0;
        int n = arr.length;
        long[][] dp = new long[n+1][2];
        dp[0][0] = 0;
        dp[1][0] = 0;
        for (int j = 1; j <=n ; j++) {
            dp[i][0] = Math.max(dp[i-1][1]-arr[i],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]+arr[i],dp[i-1][1]);
        }
        return Math.max(dp[n][0],dp[n][1]);
    }
}
