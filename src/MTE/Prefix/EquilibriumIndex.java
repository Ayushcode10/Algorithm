package MTE.Prefix;

import java.util.Arrays;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,6};
        System.out.println(e(arr));
    }

    //SC O(n)
    public static int findEqui(int[] arr){
        int totalSum = 0;
        int n = arr.length;
        //O(n) TC
        for(int i: arr){
            totalSum += i;
        }
        int lsum = 0;
        //O(N) TC
        for(int i=0;i<n;i++){
            int rsum = totalSum-lsum-arr[i];
            if (lsum == rsum){
                return i;
            }
            lsum += arr[i];
        }
        return -1;
    }

    private static int e(int[] arr){
        int n = arr.length;
        int ls =0;
        int ts = 0;
        for(int i : arr){
            ts += i;
        }
        for (int i = 0; i < n; i++) {
            int rs = 0;
            rs += ts - ls - arr[i];
            if(ls == rs){
                return arr[i];
            }
            ls += arr[i];
        }
        return -1;
    }
}
