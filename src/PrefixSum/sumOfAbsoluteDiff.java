package PrefixSum;

import java.util.Arrays;

//1685

public class sumOfAbsoluteDiff {

    public static void main(String[] args) {
        int[] arr = {2,3,5};
        int[] res = getsumAbsoluteDifferences(arr);
        System.out.println(Arrays.toString(res));
    }
    public static int[] getsumAbsoluteDifferences(int[] nums){
        int n = nums.length;
        int[] res = new int[n];
        int total = 0;
        int prefix = 0;

        for(int num:nums){
            total += num;
        }

        for (int i = 0; i <n; i++) {
            int lsum = nums[i]*i - prefix;
            int rsum = (total - prefix - nums[i]) - (n-i-1)*nums[i] ;
            res[i] = lsum + rsum;
            prefix += nums[i];
        }
        return res;
    }


}
