package Set_Map;

import java.util.Arrays;
import java.util.HashMap;

public class missingAndRepeated {
    public static void main(String[] args) {
        int[][] arr = {{1,3},{2,2}};
        System.out.println(Arrays.toString(find(arr)));
    }
    public static int[] find(int[][] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        int missing = -1, repeated = -1;
        for (int[] a : arr) {
            for (int i : a) {
                map.put(i, map.getOrDefault(i, 0) + 1);
            }
        }
        for(int i = 1; i<=n*n ; i++){
            int fq = map.getOrDefault(i,0);
                    if(fq == 2) repeated = i;
                   else if(fq == 0) missing = i;
        }
        return new int[]{missing,repeated};
    }
}