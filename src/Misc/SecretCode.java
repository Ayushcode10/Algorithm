package Misc;

import java.util.Arrays;
import java.util.Scanner;

public class SecretCode {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the letter");
        String s = sc.nextLine();
        System.out.println("enter the code");
        String code = sc.nextLine();
        System.out.println(contains(s, code));
    }

    private static boolean contains(String s, String code) {
        if (s.length() < code.length()) {
            return false;
        }
        if (helper(s.substring(0, code.length()), code)) {
            return true;
        }
        return contains(s.substring(1), code);
    }

    private static boolean helper(String s1, String s2) {
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}