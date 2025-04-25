//package CSES;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MinimizingCoins {
    public static void main(String[] args) {
        int n = 3;
        int x = 11;
        long[] dp =  new long[x+1];
        Arrays.fill(dp,-1);
        System.out.println(min(n, x, new int[]{1, 5, 7},dp));
    }

    private static long min(int n, int x, int[] arr, long[] dp) {
        if (x == 0) return 0;
        if (x < 0) return Integer.MAX_VALUE;
        if(dp[x] != -1){
            return dp[x];
        }
        long res = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long sub = min(n, x - arr[i], arr,dp);
            if (sub != Integer.MAX_VALUE) {
                res = Math.min(res, sub + 1);
            }
        }
        dp[x] = res;
        return dp[x];
    }
}
