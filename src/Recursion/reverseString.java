package Recursion;

public class reverseString {

    public static void main(String[] args) {
        System.out.println(reverse("abcd"));
    }
    public static String reverse(String s){
        //what is the base case?
        if(s.equals("")){
            return "" ;
        }
        //what is the smallest amt. of work, I can do in each iteration
        return reverse(s.substring(1)) + s.charAt(0);
    }

}
