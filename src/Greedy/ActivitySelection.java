package Greedy;

import javax.lang.model.type.ArrayType;
import java.lang.reflect.AnnotatedArrayType;
import java.util.ArrayList;
import java.util.Arrays;

public class ActivitySelection {
    public static void main(String[] args){
        int[] start = { 1, 3, 0, 5, 8, 5 };
        int[] finish = { 2, 4, 6, 7, 9, 9 };

        System.out.println(Selection(start, finish));
    }

    public static int Selection(int[] start, int[] finish){
        int n = start.length;
        int[][] pair = new int[n][2];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            pair[i][0] = finish[i];
            pair[i][1] = start[i];
        }
        Arrays.sort(pair,(a,b) -> Integer.compare(a[0],b[0]));
       
        int finishtime = -1;
        for (int i = 0; i < n; i++) {
            if(pair[i][1] > finishtime){
                finishtime = pair[i][0];
                ans++;
            }
        }
        return ans;
    }
}
