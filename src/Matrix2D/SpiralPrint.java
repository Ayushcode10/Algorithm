package Matrix2D;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

public class SpiralPrint {
    public static void main(String[] args) {
        int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiral(arr));
    }
    public static ArrayList<Integer> spiral(int[][] arr){
        int r = arr.length;
        int c = arr[0].length;
        ArrayList<Integer> a = new ArrayList<>();
        int count = 0;
        int total = r*c;
        //indexes
        int startRow = 0, startCol = 0;
        int endRow = r-1, endCol = c-1;
        while (count<total){
            //print starting row->
            for (int i = startCol; count<total && i <= endCol; i++) {
                a.add(arr[startRow][i]);
                count++;
            }
            startRow++;
            //print ending col->
            for (int i = startRow; count<total && i <=endRow ; i++) {
                a.add(arr[i][endCol]);
                count++;
            }
            endCol--;

            //print end row
            for (int i = endCol; count<total && i >= startCol ; i--) {
                a.add(arr[endRow][i]);
                count++;
            }
            endRow--;
            //print starting col->
            for (int i = endRow; count<total && i >= startRow; i--) {
                a.add(arr[i][startCol]);
                count++;
            }
            startCol++;


        }

        return a;
    }
}
