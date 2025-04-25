package Misc;

import java.util.ArrayList;

public class LargestRowSum {

    public static void main(String[] args) {
        int[][] arr = {{3,4,11},{2,12,1},{7,8,7}};
        System.out.println(largest(arr));
    }

    public static int largest(int[][] arr){
        int r = arr.length;
        int rIndx = -1;
        int c = arr[0].length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            int sum = 0;
            for (int j = 0; j < c; j++) {
                sum += arr[i][j];
            }
            if(max < sum){
                max = sum;
                rIndx = i;
            }
        }

        return rIndx;
    }
}
