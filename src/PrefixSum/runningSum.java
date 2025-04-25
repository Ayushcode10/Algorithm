package PrefixSum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class runningSum {

        public static int[] runningSum(int[] arr) {
            int n = arr.length;
            int[] result = new int[n];
            //simply using prefix sum
            result[0] = arr[0];

            for (int i = 1; i < n; i++) {
                result[i] = result[i - 1] + arr[i];
            }

            return result;
        }

        public static void prefixSumInPlace(int[] arr){
            for (int i = 1; i < arr.length; i++) {
                arr[i] = arr[i - 1] + arr[i];
            }
        }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        int[] a =  runningSum(arr);
        System.out.println(Arrays.toString(a));

    }

}
