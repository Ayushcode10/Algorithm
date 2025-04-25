package Set_Map;

import java.util.HashMap;

public class GoodPairs {
    public static void main(String[] args) {

        int[] arr = {1,2,3,1,1,3};
        System.out.println(pairs(arr));
    }


    public static int pairs(int [] arr){
        HashMap<Integer,Integer> h = new HashMap<>();
        for(int i : arr){
            h.put(i, h.getOrDefault(i,0)+1);
        }
            int res = 0;
            for(int key : h.keySet()){
                int val = h.get(key);
                if(val>1){
                    res += ((val)*(val-1))/2;
                }
            }
            return res;
    }

    //this is done using freq array which is more efficient
    public static int pairs1(int[] arr){
        int[] freq = new int[102];

        for(int i : arr){
            freq[i]++;
        }
        int totalCount = 0;
        for(int k : freq){
            totalCount += ((k)*(k-1))/2;
        }
        return totalCount;
    }
}
