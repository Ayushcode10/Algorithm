package Greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class ShortestJobFirst {
    public static void main(String[] args) {
        int[] arr = {4,3,7,1,2};
        System.out.println(sjf(arr));
    }

    private static int sjf(int[] arr){
        //why are we sorting.?
        //cuz we want the shortest job to be completed first
        //this way we can tackle the shortest job first
        Arrays.sort(arr);
        int t = 0;
        int w = 0;
        for(int i : arr){
            //calculate waiting time
            w += t;
            //calculate starting time
            t += i;
        }
        return (int) Math.floor((double) w /arr.length);
    }
}
