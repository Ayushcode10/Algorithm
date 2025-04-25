package DP;

public class DeleteOperation {
    public static void main(String[] args) {
        String s1 = "sea";
        String s2 = "eat";
        System.out.println(minDistance(s1,s2));
    }
    public static int minDistance(String w1, String w2){
        int m = w1.length(), n = w2.length();
        return ans(w1,w2,m,n);
    }

    private static int ans(String s1, String s2, int m, int n){
        int[][] dp = new int[m+1][n+1];
        for (int i =1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
        return dp[m][n];
    }
}
