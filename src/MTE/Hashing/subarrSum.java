package MTE.Hashing;

import java.util.HashMap;
import java.util.Map;

public class subarrSum {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(sum(arr,5));
    }
    private static int sum(int[] arr, int k){
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int sum = 0;
        int count = 0;
        for (int j : arr) {
            sum += j;
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
