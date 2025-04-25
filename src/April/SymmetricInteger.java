package April;

public class SymmetricInteger {
    public static void main(String[] args) {
        System.out.println(count(1,100));
    }

    public static int countSymmetricIntegers(int low, int high) {
        int count = 0;
        int sum1 = 0, sum2 = 0;

        while(low<=high){
            int digits = String.valueOf(Math.abs(low)).length();
            if (digits % 2 == 0) {
                sum1 += helper(low/(int)Math.pow(10, (double) digits /2), 0);
                sum2 += helper(low%(int)Math.pow(10, (double) digits /2), 0);
            }
            low++;
            if(digits%2 == 0 && sum1 == sum2){
                count++;
            }
            sum1 = 0;
            sum2 = 0;

        }
        return count;
    }

    public static int helper(int x, int sum){
        if(x == 0) return sum;
        int rem = x%10;
        sum += rem;
        return helper(x/10,sum);
    }

    // Static array to store how many symmetric integers
    // exist ≤ i, for 0 <= i <= 10,000
    // We're using 'short' to save memory,
    // as the count will never exceed 10,000
    private static final short[] symCount = new short[10_001];
    public static int countSymmetricOptimized(int low, int high){
        // Build the symCount array only once, the first time the method is called
        if(symCount[11] == 0) buildCounts();
        // Return how many symmetric integers lie in the range [low, high]
        // This is just a prefix sum query: symCount[high] - symCount[low - 1]
        return symCount[high] - symCount[low-1];
    }

    // One-time build of the symCount array
    private static void buildCounts(){
        // 1️⃣ Fill in 2-digit numbers (from 11 to 99)
        // All 2-digit symmetric numbers are divisible by 11: 11, 22, ..., 99
        // So we can directly compute the count using num / 11
        for (int i = 11; i <= 99; i++){
            symCount[i] = (short)(i / 11);
        }
        // 2️⃣ Fill in 3-digit numbers (from 100 to 999)
        // 3-digit numbers can't be symmetric since they have odd number of digits
        // So we just copy the previous count (from symCount[99])
        short prev = symCount[99];
        for (int i = 100; i <=999; i++) {
            symCount[i] = prev;
        }
        // 3️⃣ Fill in 4-digit numbers (from 1000 to 9999)
        // Symmetric 4-digit numbers have equal sum of first two digits and last two digits: abcd → a+b == c+d
        // We brute-force every 4-digit number from 1000 to 9999, and check for symmetry
        prev = symCount[999];// Start from the last known count
        int idx = 1000;// Start from 1000

        // First two digits: high10 (thousands place), high1 (hundreds place)
        for (int high10 = 1; high10 <= 9 ; high10++) {
            for (int high1 = 0; high1 <= 9; high1++) {
                final int highsum = high10 + high1;// Sum of first two digits
                // Last two digits: low10 (tens place), low1 (ones place)
                for (int low10 =0; low10 <=9 ; low10++) {
                    for (int low1 = 0; low1 <=9 ; low1++) {
                        final int lowsum = low10 + low1;
                        // If sum of first half == sum of second half, it's symmetric
                        // New symmetric number found, increment count
                        // if not found, Update prefix count at this index
                        symCount[idx++] = (short) ((highsum == lowsum) ? ++prev : prev);
                    }
                }
                // 4️⃣ Handle edge case: 10,000 is not symmetric (only has 5 digits)
                // So just copy the count from 9999
                symCount[10_000] = symCount[9999];
            }


        }
    }
        public static int count(int low, int high){
            if(symCount[11]==0){
                bc();
            }
            return symCount[high] - symCount[low-1];
        }
        private static void bc(){
            for (int i = 11; i <= 99; i++) {
                symCount[i] = (short)(i/11);
            }
            short prev = symCount[99];
            for (int i = 100; i <=999 ; i++) {
                symCount[i] = prev;
            }
            prev = symCount[999];
            int idx = 1000;
            for (int h10 = 1; h10 <= 9; h10++) {
                for (int h1 = 0; h1 <= 9; h1++) {
                    final int high = h1 + h10;
                    for (int l10 = 0; l10 <=9 ; l10++) {
                        for (int l1 = 0; l1 <=9; l1++) {
                            final int low = l1 + l10;
                            symCount[idx++] = (short)((high == low) ? ++prev : prev);
                        }
                    }
                }
            }
            symCount[10_000] = symCount[9999];
        }
}
