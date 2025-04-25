package DP;

import java.lang.management.MemoryType;
import java.util.Arrays;

//leetcode 198
public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = {1,2,3,1};
        System.out.println(rob(arr));
    }
    public static int rob(int[] arr){
//        int n = arr.length;
//        int[] dp = new int[n+1];
//        Arrays.fill(dp,-1);
//        return dpmax(arr,0,dp);
        return tab(arr);
    }

    private static int max(int[] arr,int i){
        if(i >= arr.length){
            return 0;
        }
        int rob = arr[i] + max(arr,i+2);
        int skip = max(arr,i+1);

        return Math.max(rob,skip);
    }

    private static int dpmax(int[] arr, int i, int[] dp){
        if(i>=arr.length) return 0;
        if(dp[i] != -1){
            return dp[i];
        }
        int rob = arr[i] + dpmax(arr,i+2,dp);
        int skip = dpmax(arr,i+1,dp);
        dp[i] = Math.max(rob,skip);
        return dp[i];
    }

    private static int tab(int[] arr){
        int n = arr.length;
        if(n == 0) return 0;
        if(n == 1) return arr[0];
        int[] dp = new int[n];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0],arr[1]);
        for(int i = 2;i<n;i++){
            dp[i] = Math.max(dp[i-1],arr[i]+dp[i-2]);
        }
        return dp[n-1];
    }

}
