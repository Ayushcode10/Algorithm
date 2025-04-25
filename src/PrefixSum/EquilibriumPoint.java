package PrefixSum;

public class EquilibriumPoint {
    public static void main(String[] args) {
        int arr[] = { -7, 1, 5, 2, -4, 3, 0 };
        int arr_size = arr.length;

        // Function call
        System.out.println("First Point of equilibrium "
                + "is at index "
                + eqi(arr, arr_size));
    }
    public static int eqi(int[] arr, int n){
        n = arr.length;
        int[] pre = new int[n];
        int[] suf = new int[n];
        pre[0] = arr[0];
        suf[n-1] = arr[n-1];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i-1]+arr[i];
            suf[n-i-1] = suf[n-i] + arr[n-i-1];
        }
        for (int i = 0; i < n; i++) {
            if(pre[i] == suf[i]){
                return i;
            }
        }
        return -1;
    }
}
