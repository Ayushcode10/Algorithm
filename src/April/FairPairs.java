package April;

import java.util.Arrays;
//leetcode 2563 april 19/2025
public class FairPairs {
    public static void main(String[] args) {
        int[] arr = {0,1,7,4,4,5};
        System.out.println(countFairPairs(arr,3,6));
    }
    public static long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < n; i++) {
            int left = lb(nums,i+1,n-1,lower-nums[i]);
            int right = ub(nums,i+1,n-1,upper-nums[i]);
            count += (right-left+1);
        }
        return count;
    }

    private static int lb(int[] arr, int low, int high, int target){
        while(low<=high){
            int m = low+(high-low)/2;
            if(arr[m]<target){
                low = m+1;
            }
            else high = m-1;
        }
        return low;
    }
    private static int ub(int[] arr, int low, int high, int target){
        while(low<=high){
            int m = low+(high-low)/2;
            if(arr[m]>=target){
                low = m+1;
            }
            else high = m-1;
        }
        return high;
    }
}
