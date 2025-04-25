//package CSES;

import java.util.Arrays;
import java.util.Scanner;

public class DiceCombinations {
    static int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp,-1);
        System.out.println(dpCombi(n, dp));
    }

    private static int dpCombi(int n, int[] dp){
        if(n == 0) return 1; // Base case: 1 way to make 0
        if(n < 0) return 0;  // No way to make negative sum
        if(dp[n] != -1) return dp[n]; // Return if already computed

        long ways = 0;
        for(int i = 1; i <= 6; i++){
            ways = (ways + dpCombi(n - i, dp)) % MOD;
        }
        return dp[n] = (int) ways;
    }

    private static int tabCombi(int n, int[] dp){
        dp[0] = 1;
        for (int i = 1; i <=n; i++) {
            for (int j =1; j <=6; j++) {
                if(i-j>=0){
                    dp[i] = (dp[i]+dp[i-j])%MOD;
                }
            }
        }
        return dp[n];
    }
//    private static int combi(int n){
//            if(n == 0) return 1;
//            int s = 0;
//            for (int i = 1; i <= 6; i++) {
//                if(n - i >=0){
//                    s += combi(n-i);
//                }
//            }
//            return s;
//        }
}

