package Matrix2D;

public class MaximumRecScore {

//    valid rectangle ->
//        1. which contains all identical elements.
//        2. each side length should be at least 2 units.

    /*
        score is the value of the element in the valid rectangle
    */
    public static void main(String[] args) {
        int[][] arr = {{1,2,2,2},{2,2,2,2},{3,4,2,8}};
        System.out.println(score(arr));
    }

    public static int score(int[][] arr){
        int m = arr.length, n = arr[0].length;
        int score = 0;
        for (int i = 0; i < m-1; i++) {
            for (int j = 0; j < n-1; j++) {
                if(arr[i][j] == arr[i][j+1] &&
                        arr[i][j] == arr[i+1][j] &&
                        arr[i][j] == arr[i+1][j+1]){
                    score = Math.max(score, arr[i][j]);
                }
            }
        }
        return score;
    }

}
