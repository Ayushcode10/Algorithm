package PrefixSum;

public class PivotIndex {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        System.out.println(pivot(arr));
    }

    public static int pivot(int[] arr){
        int n = arr.length;
        int total = 0;
        int lsum = 0;
        for(int i : arr){
            total += i;
        }
        for (int i = 0; i < n; i++) {
            if(2*lsum + arr[i] == total){
                return i;
            }
            lsum += arr[i];
        }
        return -1;
    }
}
