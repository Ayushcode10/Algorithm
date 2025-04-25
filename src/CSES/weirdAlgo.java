package CSES;

import java.util.Scanner;

public class weirdAlgo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        weird(n);
    }
    public static void weird(long n){
        System.out.print(n + " ");
        if(n == 1){
            return;
        }
        if(n%2==0) weird(n/2);
        else{
            weird((n*3)+1);
        }
    }
}
