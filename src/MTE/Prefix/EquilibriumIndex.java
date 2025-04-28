package MTE.Prefix;

import java.util.Arrays;

public class EquilibriumIndex {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        System.out.println(findEqui(arr));
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
}
