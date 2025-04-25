package BinarySearch;

public class countNegIn2D {
    public static void main(String[] args) {

    }

    public static int countNeg(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int count = 0;
        int i = m-1, j = 0;
        while(i>=0 && j<n){
            if(grid[i][j] >= 0){
                j++;
            }
            else{
                count += (n-j + 1);
                i--;
            }
        }
        return count;
    }
}
