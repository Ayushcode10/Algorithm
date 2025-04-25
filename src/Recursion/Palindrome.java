package Recursion;

public class Palindrome {
    public static void main(String[] args) {
        String s = "aabbcc";
        System.out.println(isPalindrome(s,0,s.length()-1));
    }

    public static boolean isPalindrome(String s, int left, int right){
        if(left>=right){
            return true;
        }

        return (s.charAt(left) == s.charAt(right));
    }
}
