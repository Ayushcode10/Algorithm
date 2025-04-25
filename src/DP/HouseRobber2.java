package DP;

import java.util.Arrays;

public class HouseRobber2 {
    public static void main(String[] args) {
        int[] arr = {2,3,2};
        System.out.println(rob(arr));
    }
    public static int rob(int[] arr){
        if(arr.length == 1) return arr[0];
        int n = arr.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int case1 = memo(arr, 0, n - 2, dp1); // exclude last
        int case2 = memo(arr, 1, n - 1, dp2); // exclude first

        return Math.max(case1, case2);
    }
    private static int helper(int[] arr, int start,int end){
        if(start>end) return 0;
        int rob = arr[start] + helper(arr,start+2,end);
        int skip = helper(arr,start+1,end);
        return Math.max(rob,skip);
    }
    private static int memo(int[] arr,int start, int end, int[] dp){
        if(start>end)return 0;
        int n = arr.length;
        if(dp[n] != -1) return dp[n];
        int rob = arr[start] + memo(arr,start+2,end,dp);
        int skip= memo(arr,start+1,end,dp);
        dp[n] = Math.max(rob,skip);
        return dp[n];
    }

    private static int tab(int[] arr, int s, int e){
        int n = e-s+1;
        if(n==0)return 0;
        if(n==1) return arr[s];
        int[] dp = new int[n+1];
        dp[0] = arr[s];
        dp[1] = arr[Math.max(arr[s],arr[s+1])];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i-1], arr[s+i] + dp[i-2]);
        }
        return dp[n-1];
    }

}
