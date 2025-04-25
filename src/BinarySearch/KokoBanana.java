package BinarySearch;

import java.util.Arrays;

public class KokoBanana {
public static void main(String[] args) {
    int[] piles = {3,6,7,11};
    System.out.println(minEatingSpeed(piles, 8));
}

    public static int minEatingSpeed(int[] piles, int h){
        int l = 1;
        int r = Arrays.stream(piles).max().getAsInt();
        while(l<r){
            int m = l+(r-l)/2;
            if(eat(piles, h, m)){
                r= m;
            }
            else {
                l = m + 1;
            }
        }
        return l;

    }
        private static boolean eat(int[] piles, int h, int k){
            int hours = 0;
            for(int pile : piles){
                hours += (pile + k -1)/k;
            }
            return hours <= h;
        }
}
