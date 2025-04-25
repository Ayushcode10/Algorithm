package PrefixSum;

import java.util.Arrays;

public class productExceptSelf {
    public static void main(String[] args) {
        int[] arr = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(ans(arr)));
    }

    public static int[] ans(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        int count0 = 0;
        int totalP = 1;
        for(int i:arr){
            if(i == 0){
                count0++;
                continue;
            }
            totalP *= i;
        }
        for (int i = 0; i < n; i++) {
            if(arr[i] == 0){
                res[i] = (count0 == 1)?totalP : 0;
            }
            else {
                res[i] = (count0>0)?0: totalP/arr[i];
        }
        }
        return res;
    }
}
