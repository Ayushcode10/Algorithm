package PrefixSum;

public class shiftLetters {
    public static void main(String[] args) {
        String s  = "abc";
        System.out.println(shift(s, new int[]{3, 5, 9}));
    }
    public static String shift(String s, int[] shifts){
        int n = shifts.length;
        char[] res = s.toCharArray();
        for(int i = n-2; i>=0;i--){
            shifts[i] += shifts[i+1];
            shifts[i] %= 26;
        }
        for(int i = 0;i<n;i++){
            int newChar = (res[i] - 'a' + shifts[i])%26;
            res[i] = (char) ('a'  +  newChar);
        }
        return new String(res);
    }


}
