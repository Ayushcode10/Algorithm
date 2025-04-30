package MTE.Misc;

import jdk.jshell.spi.SPIResolutionException;

public class isPalin {
    public static void main(String[] args) {
        System.out.println(ispalin("abbbda"));
    }
    private static boolean ispalin(String s){
        int i = 0;
        int j = s.length()-1;
        while(i<j){
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }

        return true;
    }
}
