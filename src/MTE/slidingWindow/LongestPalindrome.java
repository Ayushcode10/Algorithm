package MTE.slidingWindow;

public class LongestPalindrome {
    /*Algo:
        1.
    */
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(longestPal(s));
    }
    private static String longestPal(String s){
        if(s.isEmpty()) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s,i,i); //odd len
            int len2 = expandAroundCenter(s,i,i+1); //even len
            int len = Math.max(len1,len2);
            if(len > end-start){
                start = i - (len-1)/2;
                end = i + len/2;
            }
        }
        return s.substring(start,end+1);
    }
    private static int expandAroundCenter(String s, int left, int right){
        while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }

    private static String palin(String s){
        if(s.isEmpty()) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = helper(s,i,i);
            int len2 = helper(s,i,i+1);
            int len = Math.max(len1,len2);
            if(len > end - start){
                start = i - (len-1)/2   ;
                end = i + (len/2);
            }
        }
        return s.substring(start,end+1);
    }
    private static int helper(String s, int left, int right){
        while(left>=0 && right<s.length()&& s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
