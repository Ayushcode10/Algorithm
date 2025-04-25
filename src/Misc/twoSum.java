package Misc;

import java.util.Arrays;

public class twoSum {
    public static void main(String[] args) {
        int[] arr = {3,3};
        System.out.println(Arrays.toString(twoSum(arr,6)));
    }
    public static int[] twoSum(int[] arr, int target) {
        int[] nums = new int[2];
        int n = arr.length;
        for(int i=0;i<n;i++){
            for(int j=n-1;j>=0;j--){
                if(arr[i] + arr[j] == target){
                    nums[0] = i;
                    nums[1] = j;
                }
            }
        }
        return nums;
    }
}
