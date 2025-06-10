package BitManuipulation;

import java.io.PrintStream;

public class BM1 {
    static void printBin(int n){
        for (int i = 10; i >=0 ; --i) {
            System.out.print((n>>i)&1);
        }
    }
    public static void main(String[] args) {
//        int a = (1 << 31) - 1;
//        int b = (int) Math.pow(2,32) - 1;
//
//        System.out.println(a);
//        System.out.println(b);
        printBin(9);
        int a = 9;
        int i = 3;
        System.out.println();
        /*  9 = 1001
            9 & (1<<1) ==>  1001
                          & 0010
                          --------
                            0000
            since 1st bit is not 1 therefore not set in(1001)
            for example lets check for 3rd bit in 9
            9=1001
            shift 3 bits to check for 3rd set/unset bit
            9 & (1<<3) ==>  1001
                          & 1000
                          --------
                            1000
            since 3rd bit in the ans is set therefore it shows that
            the 3rd bit in '9' is also set
         */

        //to check whether the bit is set or not on the ith position
        if ((a & (1 << i)) != 0) {
            System.out.println("set");
        } else {
            System.out.println("unset");
        }


        //to set a bit on the ith position
        /*  9 = 1001
            9 | (1<<1) ==>  1001
                          | 0010
                          --------
                            1011
            therefore the first bit is set now
         */
        int b = (a | (1 << i));
        System.out.print("set ith bit : ");
        printBin(b);
        System.out.println();

        //to unset certain bit
        /*  9 = 1001
            ~(1000) = 0111  --> inversion
            9 & ~((1<<3)) ==>  1001
                             & 0111
                             --------
                               0001  -> therefore the 3d bit is unset
         */
        int c = a & (~(1 << i));
        System.out.print("unset ith bit : ");
        printBin(c);
        System.out.println();

        //toggle ith bit
        /*  9 = 1001
            9 ^ (1<<2)) ==>  1001
                           ^ 0100
                            --------
                             1101  -> therefore the 3d bit is unset
         */
        System.out.print("toggle ith bit : ");
        printBin(a ^ (1 << 2));

        //count set bits
        int count=0;
        for (int j = 32; j >=0; --j) {
            if((a&(1<<j)) != 0){
                count++;
            }
        }
        System.out.println();
        System.out.println(count);
    }
}
