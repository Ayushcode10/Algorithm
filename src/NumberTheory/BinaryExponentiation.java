package NumberTheory;

public class BinaryExponentiation {
    //in simple words, binary exponentiation is a technique to
    //calculate a^n in (O(logN)) time complexity
    public static void main(String[] args) {
        System.out.println(powerBE(5,5));
    }
    //naive  tc-->O(N)
    private static int power(int base, int n){
        int res = 1;
        while(n>=1){
            res *= base;
            n--;
        }
        return res;
    }

    //optimised approach (Binary Exponentiation)
    private static int powerBE(int base, int n){
        int res = 1;
        while(n>0){
            if(n%2 == 1){
                res *= base;
                n--;
            }
            else{
                base *= base;
                n /=2;
            }
        }
        return res;
    }

}
