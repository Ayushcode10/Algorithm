package BinarySearch;

import java.util.Arrays;

public class shipCapacity {
    public static int shipWithinDays(int[] weights, int days){
        int l = Arrays.stream(weights).max().getAsInt();
        int r = Arrays.stream(weights).sum();

        while(l<r){
            int m = l+(r-l)/2;
            if(calc(weights,days,m)){
                r = m;
            }
            else {
                l = m+1;
            }
        }
        return l;
    }
    private static boolean calc(int[] weights, int days, int cap){
        int load = 0;
        int dayCount = 1;

        for(int w : weights){
            if(load + w > cap){
                dayCount++;
                load = 0;
            }
            load += w;
        }
        return dayCount <=days;
    }
}
