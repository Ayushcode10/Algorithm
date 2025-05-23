package CSES;

import java.util.Scanner;

public class CountingDivisors {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int MAX = 1000001; //10^6
        int[] divisorCount = new int[MAX];

        //1,2,3,4,5,6,7,8,9,10
        //0,1,2,3,4,5,6,7,8,9,10
        //[0,1,2,2,3,2,3,1,3,2,3] --> count of divisors
        for (int i = 1; i < MAX ; i++) {
            for (int j = i; j < MAX; j+=i) {
                divisorCount[j]++;
            }
        }
        //number of testcases
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            //number
            int x = sc.nextInt();
            System.out.println(divisorCount[x]);
        }

    }
}
