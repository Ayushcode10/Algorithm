package CSES;

import java.util.Locale;
import java.util.Scanner;

public class MissingNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long[] arr = new long[(int) (n-1)];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(missing(n, arr));
    }
    public static long missing(long n, long[] arr){
        long sum = 0;
        long total = (n*(n+1))/2;
        for (long j : arr) {
            sum += j;
        }
        return total - sum;
    }
}
