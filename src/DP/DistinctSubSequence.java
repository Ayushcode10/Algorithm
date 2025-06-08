package DP;

import java.util.Arrays;

class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()][t.length()];
        for (int[] row : dp) Arrays.fill(row, -1);
        return countWays(s, t, 0, 0, dp);
    }

    private int countWays(String s, String t, int i, int j, int[][] dp) {
        if (j == t.length()) return 1; // all characters in t matched
        if (i == s.length()) return 0; // s exhausted, but t n ot

        if (dp[i][j] != -1) return dp[i][j];

        int ways = 0;
        if (s.charAt(i) == t.charAt(j)) {
            // Match or skip
            ways += countWays(s, t, i + 1, j + 1, dp);
        }
        // Always have the choice to skip s[i]
        ways += countWays(s, t, i + 1, j, dp);

        return dp[i][j] = ways;
    }
}
