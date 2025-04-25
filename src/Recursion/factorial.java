package Recursion;
public class factorial {
    public static int factorialHelper(int n, int accumulator) {
        if (n == 0 || n == 1) {
            return accumulator;  // Base case: return the accumulated result
        }
        return factorialHelper(n - 1, n * accumulator);  // Pass the updated accumulator
    }

    public static int factorial(int n) {
        return factorialHelper(n, 1);  // Start with accumulator = 1
    }

    public static void main(String[] args) {
        System.out.println(factorial(5));  // Output: 120
    }
}
