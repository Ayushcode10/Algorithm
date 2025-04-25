package Set_Map;

import java.util.HashMap;

public class rabbitsInForest {
    public static void main(String[] args) {
        int[] arr = {1,1,2};
        System.out.println(numRabits(arr));
    }
    public static int numRabits(int [] answers){
        HashMap<Integer,Integer> map = new HashMap<>();
        int total = 0;
        for(int ans : answers){
            map.put(ans,map.getOrDefault(ans,0)+1);
        }
        for(int key : map.keySet()){
            int group = key + 1;
            int count = map.get(key);
            total += ((count + group)/group);
        }
        return total;
    }
}
