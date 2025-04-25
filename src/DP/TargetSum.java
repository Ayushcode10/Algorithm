package DP;

public class TargetSum {
    public static void main(String[] args) {
        int[] arr = {1,1,1,1,1};
        int target = 3;
        System.out.println(find(arr,target));
    }

    private static int find(int[] arr, int target){
        int n = arr.length;
        return helper(n,target,arr);
    }

    private static int helper(int i, int target, int[] arr){
        if(i == 0){
            return target == 0?1:0;
        }
        int inc = helper(i-1,target-arr[i-1],arr);
        int exc = helper(i-1,target+arr[i-1],arr);
        return inc + exc;
    }
    private static int DP(int i, int target, int[] arr,int[][] dp){
        if(i == 0){
            return target == 0?1:0;
        }
        if(dp[i][target] != -1){
            return dp[i][target];
        }
        int inc = DP(i-1,target-arr[i-1],arr,dp);
        int exc = DP(i-1,target+arr[i-1],arr,dp);
        return inc + exc;
    }
}
