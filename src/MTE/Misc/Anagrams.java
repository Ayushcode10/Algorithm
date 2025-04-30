package MTE.Misc;

public class Anagrams {
    public static void main(String[] args) {

    }
    private static boolean isAnagram(String s, String t){
        if (s.length() != t.length()) return false;
        int[] count = new int[26];
        for(char c : s.toCharArray()) count[c-'a']++;
        for (char c : t.toCharArray()){
            if (--count[c-'a']<0) return false;
        }
        return true;
    }
}
