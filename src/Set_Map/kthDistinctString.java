package Set_Map;

import java.util.HashMap;

public class kthDistinctString{
    public static void main(String[] args) {
        String[] arr = {"d","b","c","b","c","a"};
        System.out.println(kthDistinct(arr,2));
    }
    public static String kthDistinct(String[] arr, int k){
        HashMap<String,Integer> map = new HashMap<>();
        for(String s : arr){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        int count = 0;
        for(String s : arr){
            if(map.get(s) == 1){
                count++;
                if (count == k){
                    return s;
                }
            }
        }
        return "";
    }
}
