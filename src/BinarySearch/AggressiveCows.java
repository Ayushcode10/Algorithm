package BinarySearch;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int[] arr = {1,2,4,8,9};
        System.out.println(cows(arr, 3));
    }
    public static boolean canPlace(int[] arr, int k , int minD){
        int count = 1;
        int lastPos = arr[0];
        for(int i = 1 ; i<arr.length ; i++){
            if(arr[i] - lastPos >= minD){
                count++;
                lastPos = arr[i];
            }
            if(count >= k){
                return true;
            }
        }
        return false;
    }
    public static int cows(int[] stalls, int k){
        Arrays.sort(stalls);
        int l = 1, r = stalls[stalls.length-1] - stalls[0];
        int best = 0;

        while(l<=r){
            int m = l+(r-l)/2;
            if(canPlace(stalls, k, m)){
                best = m;
                l = m+1;
            }
            else {
                r = m-1;
            }
        }
        return best;
    }
}
