package Misc;

import java.util.Arrays;
import java.util.Scanner;

public class arr {
    public static void main(String[] args) {
        int n; //for  size of the Misc.arr

        //initialize scanner obj
        Scanner sc = new Scanner(System.in);
        System.out.println("enter size");
        n = sc.nextInt(); //take user input
        //init Misc.arr
        int[] arr = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            System.out.println("enter ele no." + i);
            int a = sc.nextInt();
            arr[i] = a;
            sum += a;
        }
        int avg = sum/n;

        System.out.println(Arrays.toString(arr));
        System.out.println("sum:" + sum);
        System.out.println("avg:" + avg);
    }


}
