package CSES;

import java.util.Scanner;

public class CountingDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int original = n;
        int totalDivisors = 1;

        for (int i = 2; i * i <= n; i++) {
            int count = 0;
            while (n % i == 0) {
                count++;
                n /= i;
            }
            if (count > 0) {
                totalDivisors *= (count + 1);
            }
        }


        // If n is still greater than 1, it is a prime number
        if (n > 1) {
            totalDivisors *= 2; // because prime^1 → (1+1)
        }

        System.out.println(original + totalDivisors);
    }
}
