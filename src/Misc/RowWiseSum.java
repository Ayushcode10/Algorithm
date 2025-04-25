package Misc;

import java.util.ArrayList;

public class RowWiseSum {
    public static void main(String[] args) {
        int[][] arr = {{3,4,11},{2,12,1},{7,8,7}};
        System.out.println(RowSum(arr));
        System.out.println(colSum(arr));
    }

    public static ArrayList<Integer> RowSum(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < r; i++) {
            int sum = 0;
            for (int j = 0; j < c; j++) {
                sum += arr[i][j];
            }
            a.add(sum);
        }
        return a;
    }

    public static ArrayList<Integer> colSum(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        ArrayList<Integer> a = new ArrayList<>();
        for (int i = 0; i < c; i++) {
            int s = 0;
            for (int j = 0; j < r; j++) {
                s += arr[j][i];
            }
            a.add(s);
        }
        return a;
    }
}
