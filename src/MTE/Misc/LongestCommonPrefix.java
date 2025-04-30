package MTE.Misc;

import java.awt.*;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] st = {"flower", "flow", "flight"};
        System.out.println(lcp(st));
    }
    private static String lcp(String[] str){
        if (str.length == 0) return "" ;
        String prefix = str[0];

        for (int i = 1; i <str.length ; i++) {
            while (!str[i].startsWith(prefix)){
                prefix = prefix.substring(0,prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}
