package MTE.Misc;

import java.util.HashMap;
import java.util.Map;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] arr={1,2,3,3,4,5};
        System.out.println(dupli(arr));
    }
    private static int dupli(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        return -1;
    }
}
