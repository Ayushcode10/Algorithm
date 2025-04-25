package DP;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] arr = {1,5,11,7};
        System.out.println(canPartition(arr));
    }
    public static boolean canPartition(int[] arr){
        int sum = 0;
        int n = arr.length;
        for(int i : arr) sum += i;
        if(sum%2 != 0) return false;
        Boolean[][] dp = new Boolean[n+1][sum/2+1];
        return helper(0,sum/2,arr,dp);
    }

    private static boolean helper(int i, int target, int[] arr, Boolean[][] dp){
        if(i>=arr.length){
            return target == 0;
        }
        if(dp[i][target] != null) return dp[i][target];
        boolean inc = helper(i+1,target-arr[i],arr,dp);
        boolean exc = helper(i+1, target, arr,dp);
        return dp[i][target] = inc || exc;
    }
}
