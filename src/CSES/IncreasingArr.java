package CSES;

import java.util.Scanner;

public class IncreasingArr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        System.out.println(getMinimumMoves(n, arr));
    }

    public static long getMinimumMoves(int n, long[] arr) {
        long moves = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                moves += arr[i - 1] - arr[i];
                arr[i] = arr[i - 1]; // fix: make it non-decreasing
            }
        }
        return moves;
    }
}
