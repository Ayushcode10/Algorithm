package MTE.Prefix;

import java.util.Arrays;

public class Suffix {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(suf(arr)));
    }

    private static int[] suf(int[] arr){
        int n = arr.length;
        int[] s = new int[n];
        s[n-1] = arr[n-1];
        for(int i = n-2;i>=0;i--){
            s[i] = s[i+1] + arr[i];
        }
        return s;
    }

}
