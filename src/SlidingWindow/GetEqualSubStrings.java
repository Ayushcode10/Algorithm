package SlidingWindow;

public class GetEqualSubStrings {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";
        System.out.println(equalSubStrings(s,t,3));
    }

    public static int equalSubStrings(String s, String t, int maxCost){
        int cost = 0, maxlen = 0;
        int i = 0, j = 0;
        while (j < s.length()){
            //adding cost of changing (s(j) -> t(j))
            cost += Math.abs(s.charAt(j) - t.charAt(j));
            //if cost of changing increases maxCost then shrink the window
            //from the left size
            while(cost > maxCost){
                cost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;//move left pointer by one place
            }
            //update max valid substring length
            maxlen = Math.max(maxlen ,j-i+1);
            j++;//expand window
        }
        return maxlen;
    }
}

