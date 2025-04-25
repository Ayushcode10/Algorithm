package April;
//416 leetcode
import java.util.Arrays;

public class PartitionEqualSubSetSum {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        System.out.println(canSplitDP(arr));
    }

    //bruteforce (O(2^n)) cuz this will throw TLE for large inputs
    public static boolean canPartition(int[] arr){
        int sum = 0; //calculate sum of all elements
        for(int i : arr){
            sum += i;
        }
        //if the sum is not even then it can't be split therefore false
        if(sum%2!=0) return false;
        return sub(arr,0,0,sum/2);
    }
    public static boolean sub(int[] arr, int i, int sum, int target){
        // if we found elements adding equal to target
        if(sum == target) return true;
        //if we did not get the elements equal to target in this traversal
        //or the sum exceeded the target, or  we exhausted the arr
        if(i>=arr.length || sum > target) return false;

        if(sub(arr,i+1,sum+arr[i],target)) return true;//choosing the element for addition
        return sub(arr,i+1,sum,target); //excluding the element and moving forward
    }

    //efficient solution
    //memoization (O(n)) !!
    public static boolean canSplitDP(int[] arr){
        int sum = 0;
        for(int i:arr){
            sum += i;
        }
        if(sum%2 != 0) return false;
        //create a 2d dp arr with m=index, n = sum;
        //we will store already computed value in this alongside the
        //specific coordinates
        int[][] dp = new int[arr.length+1][sum+1];
        //initialize all the elements as -1;
        for(int[] d : dp){
            Arrays.fill(d,-1);
        }
        return dp(arr,0,sum/2,0,dp) == 1;
    }

    public static int dp(int[] arr, int i , int target, int sum, int[][] dp){
        //if all elements exhausted
        if(i>= arr.length){
            //check if we found any elements sum == target
            if(sum == target){
                //if yes mark 1 to the corresponding sum and index
                dp[i][sum] = 1;
                return 1;
            }
            else {
                //if we didnot get the target sum but calculated then mark as 0;
                dp[i][sum] = 0;
                return 0;
            }
        }
        //before calling the recursive function
        //check if the call is already computed
        if(dp[i][sum] != -1){
            //if yes return the value;
            return dp[i][sum];
        }
        //if not, check
        int num = arr[i];
        if(sum + num <= target){
            //include the element
            if(dp(arr,i+1,target,sum+num,dp)  == 1){
                dp[i][sum] = 1;
                return 1;
            }
        }
        //exclude the element
        if(dp(arr,i+1,target,sum,dp) == 1){
            dp[i][sum] = 1;
            return 1;
        }
        //if neither works return 0
        dp[i][sum] = 0;
        return 0;
    }
}
