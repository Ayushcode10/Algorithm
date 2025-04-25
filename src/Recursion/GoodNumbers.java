package Recursion;

public class GoodNumbers {
    public static void main(String[] args){

        long n = 50;
        System.out.println(countGoodNumbers(n));
    }

    private static final int MOD = 1_000_000_007;
    public static int countGoodNumbers(long n){
        long evenPos = n/2;
        long oddPos = (n+1)/2;
        return (int) ((pow(5, oddPos, MOD) * pow(4, evenPos, MOD)) % MOD);
    }

    private static long pow(int n, long r, int mod){
        if(r == 0) return 1;
        long half = pow(n,r/2,mod)%mod;
        long res = (half*half)%mod;

        if(r%2 != 0){
            res = (res*n)%mod;
        }
        return res;
    }
}
