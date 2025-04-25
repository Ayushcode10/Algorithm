package CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class SumOfTwoValues {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] first = br.readLine().split(" ");
        int n = Integer.parseInt(first[0]);
        int x = Integer.parseInt(first[1]);

        String[] nums = br.readLine().split(" ");
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int current = Integer.parseInt(nums[i]);
            int complement = x - current;
            if (map.containsKey(complement)) {
                System.out.println(map.get(complement) + 1 + " " + (i + 1));
                return;
            }
            map.put(current, i);
        }

        System.out.println("IMPOSSIBLE");
    }
}
