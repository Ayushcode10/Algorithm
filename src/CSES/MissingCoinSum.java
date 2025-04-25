package CSES;

import java.util.Arrays;
import java.util.Scanner;

public class MissingCoinSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] arr = new long[(int) n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        long ps = 0;
        long res = 1;
        long target = 1;
        Arrays.sort(arr);
        for (int i = 0; i < n; i++) {
            if(arr[i] <= ps+1){
                ps+= arr[i];
            }
            else{
                System.out.println(ps+1);
                return;
            }
        }
        System.out.println(ps+1);
    }

}
