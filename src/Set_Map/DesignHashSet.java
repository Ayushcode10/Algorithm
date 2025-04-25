package Set_Map;

import java.util.ArrayList;
import java.util.Iterator;

public class DesignHashSet {
    public static void main(String[] args) {
        DesignHashSet hashSet = new DesignHashSet();
        hashSet.add(5);
        System.out.println(hashSet.contains(5)); // true
        hashSet.remove(5);
        System.out.println(hashSet.contains(5)); // false
    }

    static int s = 100000;
    static ArrayList<ArrayList<Integer>> set;
    public DesignHashSet(){
        set = new ArrayList<>(s);
        for (int i = 0; i < s; i++) {
            set.add(new ArrayList<>());
        }
    }

    public static void add(int key){
        int ind = key % s;
        for (int val : set.get(ind)) {
            if (val == key) {
                return;
            }
        }
        set.get(ind).add(key);
    }
    public static void remove(int key){
        int ind = key % s;
        set.get(ind).remove(Integer.valueOf(key));
    }
    public static boolean contains(int key){
        int ind = key % s;
        return set.get(ind).contains(key);
    }
}
