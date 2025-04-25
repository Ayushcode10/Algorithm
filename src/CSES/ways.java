package CSES;

import java.util.Arrays;

public class ways {
    public static void main(String[] args) {
        int n =10;
        int[] dp = new int[n+1];
        int ans = tab(10,dp);
        System.out.println(ans);
    }

    private static int calls = 0;
    private static int combi(int n,int[] dp){
//        calls++;
        if(n == 0) return 1;
//        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        if(dp[n] != -1){
            return dp[n];
        }
        dp[n] = combi(n/2,dp)+combi(n/3,dp);
        return dp[n];
    }

    private static int tab(int n,int[] dp){
        calls++;
        dp[0] = 1;
        for (int i = 1; i <=n; i++) {
            dp[i] = dp[i/2] + dp[i/3];
        }
        return dp[n];
    }

}
