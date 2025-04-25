package April;

import java.lang.management.MemoryType;
import java.util.Arrays;

//2140 LeetCode
public class BrainPower {
    public static void main(String[] args) {
        int[][] arr = {{3,2},{4,3},{4,4},{2,5}};
        System.out.println(mostPoint(arr));
    }
    public static long mostPoint(int[][] questions){
//        int n = questions.length;
//        long[] memo = new long[n];
//        Arrays.fill(memo,-1);
//        return backtrackDP(questions,0,memo);
        return mostPoints(questions);
    }

    //this is (2^n) approach -- not effective / bruteforce
    public static long backtrack(int[][] arr, int i){
        if(i>=arr.length) return 0;
        int points = arr[i][0];
        int cost = arr[i][1];
        long exclude = backtrack(arr,i+1);
        long include = points + backtrack(arr,i+1+cost);
        long max = Math.max(include,exclude);
        return max;
    }
    //this is top down DynamicProgramming approach O(n)
    //uses memoization
    /* 1. stores the max of (skip,solve) in an array(caching)
        2. if already computed value is needed again, it returns the ans
            from the memo which solves repetitive computation
     */
    public static long backtrackDP(int[][] arr, int i, long[] memo){
        if(i>= arr.length) return 0;
        //if the memo contains the ans for that
        // particular question , then return it
        if(memo[i] != -1) return memo[i];
        int points = arr[i][0];
        int cost = arr[i][1];
        long exclude = backtrackDP(arr,i+1,memo);
        long include = points + backtrackDP(arr,i+1+cost,memo);
        //add the max value in the memo array (caching)
        memo[i] = Math.max(exclude,include);
        return memo[i];
    }

    //bottom up approach --> O(n)

    public static long mostPoints(int[][] arr){
        int n = arr.length;
        long[] dp = new long[n+1];
        for(int i = n-1;i>=0;i--){
            int points = arr[i][0];
            int cost = arr[i][1];
            int nextIndex = i + cost + 1;
            if(nextIndex>n){
                dp[i] = Math.max(points,dp[i+1]);
            }
            else{
                dp[i] = Math.max(points + dp[nextIndex],dp[i+1]);
            }
        }
        return dp[0];
    }

}
