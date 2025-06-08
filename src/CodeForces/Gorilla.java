package CodeForces;

import java.util.*;

public class Gorilla {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tcase = 1; tcase <= t; tcase++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Map<Integer, Integer> freq = new HashMap<>();
            Set<Integer> unique = new HashSet<>();

            for (int i = 0; i < n; i++) {
                int ai = sc.nextInt();
                freq.put(ai, freq.getOrDefault(ai, 0) + 1);
                unique.add(ai);
            }

            int N = unique.size();
            // Create list of pairs (frequency, number)
            List<int[]> x = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                x.add(new int[] {entry.getValue(), entry.getKey()});
            }

            // Sort by frequency ascending
            x.sort(Comparator.comparingInt(a -> a[0]));

            int sum = 0;
            for (int i = 0; i < x.size(); i++) {
                if (sum + x.get(i)[0] <= k) {
                    N--;  // removing this unique number
                    sum += x.get(i)[0];
                }
            }

            System.out.println(Math.max(1, N));
        }

        sc.close();
    }
}
