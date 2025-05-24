package NumberTheory;


/*
    Sieve of Eratosthenes is an algorithm for finding all
    the prime numbers in a segment [1,n]
    O(n log log n)operations.

*/
public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 100; // Example usage
        int count = primes(n);
        System.out.println("Number of primes up to " + n + ": " + count);
    }
    private static int primes(int n){
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = 1;
            arr[0] = arr[1] = 0;
        }
        for (int i = 2; i <=n; i++) {
            if(arr[i] == 1){
                for (int j = i*i; j <=n; j+=i) {
                    arr[j] = 0;
                }
            }
        }
        int count = 0;
        for (int i = 2; i <= n ; i++) {
            if(arr[i] == 1){
                count++;
            }
        }
        return count;
    }
}
