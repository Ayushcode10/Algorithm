package PrefixSum;

import java.util.ArrayList;
import java.util.Arrays;

public class suffixSum {
    public static int[] suffix(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        res[n-1] = arr[n-1];
        for (int i = n-2 ; i >= 0; i--) {
            res[i] = res[i+1] + arr[i];
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] a =  suffix(arr);
        System.out.println(Arrays.toString(a));


    }
}
