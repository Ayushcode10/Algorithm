package MTE.Hashing;

import java.util.HashMap;
import java.util.Map;

public class MaxFreq {
    public static void main(String[] args) {
        int[] arr = {1,1,1,11,1,2,2,2,2,2,2,2,3,4};
        System.out.println(prac(arr));
    }
    private static int freq(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int maxfreq = 0;
        int res = arr[0];
        for (int j : arr) {
            int freq = map.getOrDefault(j, 0) + 1;
            map.put(j,freq);
            if (freq > maxfreq) {
                maxfreq = freq;
                res = j;
            }
        }
        return res;
    }

    private static int prac(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        int max = 0, res = arr[0];
        for(int i : arr){
            int frq = map.getOrDefault(i,0)+1;
            map.put(i,frq);
            if(frq>max){
                max = frq;
                res = i;
            }
        }
        return res;
    }
}
