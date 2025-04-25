package CSES;

import java.util.*;

public class FactoryMachines {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long t = sc.nextLong();
        long[] a = new long[n];

        long max = 0;
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
            max = Math.max(max, a[i]);
        }

        long low = 0, high = max * t;
        long res = -1;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (possible(mid, a, t)) {
                res = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(res);
    }

    public static boolean possible(long time, long[] a, long t) {
        long total = 0;
        for (long machine : a) {
            total += time / machine;
            if (total >= t) return true;
        }
        return false;
    }
}
