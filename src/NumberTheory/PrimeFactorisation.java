package NumberTheory;

public class PrimeFactorisation {
    public static void main(String[] args) {
        System.out.println(factor(2358811));
    }

    //tc --> (O(N))
    private static int countPrimeFactors(int n){
        int count = 0;
        for (int i = 2; i <= n; i++) {
            if(n%i==0){
                while(n%i == 0){
                    count++;
                    n = n/i;
                }
            }
        }
        return count;
    }


    //optimised approach --> tc=O(sqrtN)
    private static int countPF(int n){
        int count = 0;
        //check if n is divisible by 2
        if(n%2==0){
            count++;
            n/=2;
        }

        //if not then check from 3 to sqrt of n and increment +2
        //odd numbers only, as all prime no.s except 2 are odd
        for (int i = 3; i*i <= n; i+=2) {
            while(n%i==0){
                count++;
                n/=i;
            }
        }
        return count;
    }

    private static int factor(int n){
        int count = 0;
        for (int i = 2; i <=n; i++) {
            while(n%i==0){
                count++;
                n/=i;
            }
        }
        return count;
    }
}
