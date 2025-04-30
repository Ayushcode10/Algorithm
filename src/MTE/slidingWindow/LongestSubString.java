package MTE.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {
//find the len of the longest substring without repeating chars
    /*Algo:-
        1. use l and r pointer to form a window
        2. make a hashset to store unique chars
        3. expand r pointer, if duplicate move left(dynamic)
        4. keep track of the max window len
    */
    public static void main(String[] args) {
        String s = "abccaabcdefgddd";
        System.out.println(len(s));
    }
    private static int length(String s){
        Set<Character> set = new HashSet<>();
        int left = 0;
        int maxlen= 0;
        for (int right = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            maxlen = Math.max(maxlen,right-left+1);
        }
        return maxlen;
    }
    private static int len(String s){
        Set<Character> set = new HashSet<>();
        int left = 0;
        int max = 0;
        for (int right = 0; right < s.length(); right++) {
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            max = Math.max(max,right-left+1);
        }
        return max;

    }
}
