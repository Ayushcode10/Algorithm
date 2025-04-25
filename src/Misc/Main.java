package Misc;

import javax.management.ObjectName;
import java.lang.management.MemoryType;
import java.util.Arrays;
import java.util.HashMap;


public class Main{
    public static void main(String[] args){
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(rangeSum2D(arr, 0,0,2,2));
    }



    public static int[] runningSum(int[] arr){
        int n = arr.length;
        int[] preSum = new int[n];
        preSum[0] = arr[0];

        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i-1] + arr[i];
        }
        return preSum;
    }

    public static int largestAltitude(int[] gain){
        //calculate the running sum and the max val resp.
        int currAlt = 0, MaxAlt = 0;

        //iterate through the Misc.arr
        for(int g:gain){
            //running sum
            currAlt += g;
            //MaxAlt in each iteration
            MaxAlt = Math.max(MaxAlt,currAlt);
        }

        return MaxAlt;
    }

    public static int minStartVal(int[] arr){
        // to track the minSum and running sum respectively
        int minSum = 0, sum = 0;

        for(int i : arr){ // iterate through the Misc.arr
            //calculate the running sum
            sum += i;
            //calculate the minSum in each iteration
            minSum = Math.min(minSum, sum);
        }
        //return the minSum and subtract it from 1, to ensure
        // the ans always stays greater than 1;
        return 1-minSum;
    }

    public static int maxWealth(int[][] acc){
        int maxWealth = 0;
        for(int[] cust : acc){
            int wealth = 0;
            for(int i : cust){
                wealth += i;
                maxWealth = Math.max(maxWealth, wealth);
            }
        }
        return maxWealth;
    }

    public static int[] absoluteDiff(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        int total = 0;
        int preSum = 0;
        for(int num : nums){
            total += num;
        }
        for (int i = 0; i < n; i++) {
            int lsum = nums[i]*i - preSum;
            int rsum = (total - preSum - nums[i]) - (n - i -1)*nums[i];
            res[i] = lsum + rsum;
            preSum += nums[i];
        }
        return res;
    }

    public static int[][] oneDTotwoDarr(int[] og, int m, int n){
        if (og.length != m*n){
            return new int[0][0];
        }
        //m->rows , n->cols
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = og[i*n + j];
            }
        }
        return arr;
    }
    public static int[][] reshape(int[][] mat, int r, int c){
        int m = mat.length;
        int n = mat[0].length;
        if(m*n != r*c){
            return mat;
        }
        int[][] res = new int[r][c];
        int row = 0;
        int col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[row][col] = mat[i][j];
                col++;
                if(col == c){
                    row++;
                    col = 0;
                }
            }
        }
        return res;
    }
    public static int[][] TwoDprefix(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;
        int[][] pre = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i+1][j+1] = arr[i][j] + pre[i][j+1] + pre[i+1][j] - pre[i][j];
            }
        }
        return pre;
    }

    public static int[][] MatrixBlockSum(int[][] arr, int k){
        int m = arr.length;
        int n = arr[0].length;
        int[][] ans = new int[m][n];
        int[][] pre = new int[m+1][n+1];
        pre = TwoDprefix(arr);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(0,i-k) , r2 = Math.min(m-1,i+k);
                int c1 = Math.max(0,j-k) , c2 = Math.min(n-1,j+k);

                ans[i][j] = pre[r2+1][c2+1]
                            - pre[r1][c2+1]
                            -pre[r2+1][c1]
                            +pre[r1][c1];

            }
        }
            return ans;
    }

    public static int rangeSum2D(int[][] arr, int  r1, int c1, int r2, int c2){
        int m = arr.length;
        int n = arr[0].length;
        int[][] pre = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                pre[i+1][j+1] = arr[i][j] + pre[i][j+1] + pre[i+1][j] - pre[i][j];
            }
        }

        return pre[r2+1][c2+1] - pre[r2+1][c1] - pre[r1][c2+1] + pre[r1][c1];
    }

}