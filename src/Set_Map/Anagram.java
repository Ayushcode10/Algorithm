package Set_Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Anagram {
    public static List<List<String>> groupAnagram(String[] st){
        HashMap<String,List<String>> m = new HashMap<>();
        for(String s : st){
            char[] arr = new char[26];
            Arrays.sort(arr);
            String sortedWord = new String(arr);
            m.putIfAbsent(sortedWord, new ArrayList<>());
            m.get(sortedWord).add(s);
        }
        return new ArrayList<>(m.values());
    }

}
