package Set_Map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class UniqueOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2};
        System.out.println(unique(arr));

    }

    public static boolean unique(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();


        for(int i : arr){
            map.put(i,map.getOrDefault(i,0)+1);
        }
        set.addAll(map.values());
        return set.size() == map.values().size();
    }
}
