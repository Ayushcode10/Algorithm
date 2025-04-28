package MTE.Prefix;

public class splitEqualParts {
    public static void main(String[] args) {
        int[] arr = {1,5,3,9};
        System.out.println(canSplit(arr));
    }

    public static boolean canSplit(int[] arr){
        int ts = 0;
        for(int i:arr){
            ts += i;
        }
        int lsum = 0;
        for (int j : arr) {
            lsum += j;
            int rsum = ts - lsum;
            if (rsum == lsum) {
                return true;
            }
        }
        return false;
    }
}
