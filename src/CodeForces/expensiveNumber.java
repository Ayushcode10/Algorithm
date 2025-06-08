package CodeForces;

import java.util.Scanner;

public class expensiveNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long t = sc.nextLong();
        sc.nextLine();
        while (t-- > 0) {
            String s = sc.nextLine();
            long cz = 0, z = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    z++;
                } else {
                    cz += z;
                    z = 0;
                }
            }
            long ans = s.length() - cz - 1;
            System.out.println(ans);
        }
        sc.close();
    }
}