package Recursion;

public class reverseExponential {

    public static void main(String[] args) {

    }

    public static int reverseExponentiation(int n) {
        // code here
        int reversed = rev(n,0);
        return power(n,reversed);
    }
    public static int rev(int n, int reversed){
        if(n == 0){
            return reversed;
        }
        return rev(n/10,reversed*10+n%10);
    }

    public static int power(int base,int exp){
        if(exp == 0) return 1;
        if(exp == 1) return base;
//        int m = (int) (1e9+7);
        int res = 1;
        int t = power(base,exp/2);
        if(base%2 == 0) res = res*base;
        return res*(t*t);
    }

    private long power(long base, long exp, int mod) {
        if (exp == 0) return 1;

        long halfPower = power(base, exp / 2, mod) % mod;
        long result = (halfPower * halfPower) % mod;

        if (exp % 2 != 0) {
            result = (result * base) % mod;
        }
        return result;
    }
}
