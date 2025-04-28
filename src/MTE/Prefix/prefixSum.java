package MTE.Prefix;

import java.util.Arrays;

//Q2
public class prefixSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int[] pre = presum(arr);
        System.out.println(rangeSum(pre,4,5));
    }



    //building prefix arr --> (O(N))
    public static int[] presum(int[] arr){
        int n = arr.length;
        //space complexity->O(N)
        int[] pre = new int[n];
        pre[0] = arr[0];
        for (int i = 1; i <n; i++) {
            pre[i] = pre[i-1] + arr[i];
        }
        return pre;
    }

    //Query time--> (O(1))
    private static int rangeSum(int[] prefix, int left, int right){
        if(left == 0) return prefix[right];
        else{
            return prefix[right] - prefix[left-1];
        }
    }
}
