package DP;


//LEETCODE 1137
public class NthTRIBONACCI {
    public int tribonacci(int n) {

        //---> this solution is normal recursion and will give TLE;
        // if(n==0) return 0;
        // if(n==1) return 1;
        // if(n==2) return 1;
        // return tribonacci(n-1)+tribonacci(n-2)+tribonacci(n-3);

        // Arrays.fill(dp,-1);
        // return dpans(n,dp);
        int[] dp = new int[n+1];
        return tab(n,dp);
    }
    //--> this solution is done using memoization(top-down)
    private int dpans(int n, int[] dp){
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 1;
        if(dp[n]!=-1){
            return dp[n];
        }
        dp[n] = dpans(n-1,dp)+dpans(n-2,dp)+dpans(n-3,dp);
        return dp[n];
    }

    private int tab(int n,int[] dp){
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for(int i = 3; i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}
