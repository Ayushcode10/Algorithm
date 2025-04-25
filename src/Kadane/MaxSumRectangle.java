package Kadane;

public class MaxSumRectangle {
    public static void main(String[] args) {
        int[][] arr = {{1,2,-1,-4,-20},
                        {-8,-3,4,2,1},
                        {3,8,10,1,3},
                        {-4,-1,1,7,-6}};

        System.out.println(maximumSumRectangle(arr));
    }
    public static int kadane(int[] arr){
        int rows = arr.length;
        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < rows; i++) {
            sum += arr[i];

            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static int maximumSumRectangle(int mat[][]) {
        // code here
        int row = mat.length, col = mat[0].length;
        int[] arr = new int[row];
        int max = Integer.MIN_VALUE;
        for(int left = 0;left<col;left++){
            for(int i = 0;i<row;i++){
                arr[i] = 0;
            }
            for(int right = left ;right<col;right++){
                for (int j= 0; j < row; j++) {
                    arr[j] += mat[j][right];
                }
                int sum = kadane(arr);
                max = Math.max(max,sum);
            }
        }
        return max;
    }
}
