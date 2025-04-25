package Matrix2D;

import java.util.ArrayList;
import java.util.Arrays;

public class PrintWave {
    public static void main(String[] args) {
        int[][] arr = {{1,2},{3,4}};
        System.out.println(wave(arr,2,2));
    }

    public static ArrayList<Integer> wave(int[][] arr, int r , int c){
        ArrayList<Integer> a=new ArrayList<>();
        for (int i = 0; i < c; i++) {
            if(i%2 != 0){
                for (int j = r-1; j >= 0; j--) {
                    a.add(arr[j][i]);
                }
            }
            else {
                for (int j = 0; j < r; j++) {
                    a.add(arr[j][i]);


                }

            }
        }
        return a;
    }
    
}
