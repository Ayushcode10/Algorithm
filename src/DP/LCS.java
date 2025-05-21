package DP;

public class LCS {
    public static void main(String[] args) {
        String s1 = "adbcfg";
        String s2 = "abcg";

        System.out.println(longestCommonSubsequence(s1,s2));
    }

    public static int longestCommonSubsequence(String s1, String s2) {
        return lcs(s1,s2,0,0);
    }


    private static int lcsTab(String s1,String s2,int n, int m, int[][] dp){
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i+1][j+1];
                }
                else{
                   dp[i][j] =  Math.max(dp[i+1][j],dp[i][j+1]);
                }
            }
        }
        return dp[n][m];
    }

    private static int lcsMemo(String s1, String s2, int i , int j, int[][] dp){
        if(i==0|| j ==0){
            return 0;
        }
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i-1) == s2.charAt(j-1)){
            return dp[i][j] = 1+ lcsMemo(s1,s2,i-1,j-1,dp);
        }
        else{
          dp[i][j] = Math.max(
                    lcsMemo(s1,s2,i-1,j,dp),
                    lcsMemo(s1,s2,i,j-1,dp)
            );
        }
        return dp[i][j];
    }

    private static int lcs(String s1, String s2, int i, int j){
        if(i == s1.length() || j == s2.length()) return 0;
        if(s1.charAt(i) == s2.charAt(j)){
            return 1+lcs(s1,s2,i+1,j+1);
        }
        else {
            return Math.max(
                    lcs(s1,s2,i+1,j),
                    lcs(s1,s2,i,j+1)
            );
        }
    }
}
