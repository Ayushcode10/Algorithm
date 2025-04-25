package CSES;

import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(dna(s));
    }
    public static int dna(String s) {
        if (s.isEmpty()) return 0;

        int left = 0, right = 0, maxLen = 0;
        int n = s.length();

        while (right < n) {
            // Expand the window as long as characters match
            while (right < n && s.charAt(right) == s.charAt(left)) {
                right++;
            }
            // Update max length
            maxLen = Math.max(maxLen, right - left);
            // Move left to start of new window
            left = right;
        }

        return maxLen;
    }
}
