package Matrix2D;

public class BeautifulMatrix {
    public static void main(String[] args) {

    }

    public static int findMinOp(int[][] arr){
        int n = arr[0].length;
        int[] rowsum = new int[n];
        int[] colsum = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowsum[i] += arr[i][j];
                colsum[j] += arr[i][j];
            }
        }

        int max  = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max,rowsum[i]);
            max = Math.max(max,colsum[i]);
        }
        int op =0;
        for (int i = 0; i < n; i++) {
            op+=(max-rowsum[i]);
        }
        return op;

    }
}
