package MTE.slidingWindow;
public class maxSumSubarr {

    /*
        Algo:-
        1.Calculate sum of first k elements (initial window)
        2.Slide the window across the array
        3.At each slide, add new element and remove the old one
     */

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 2;
        System.out.println(max(arr, k));
    }

    private static int window(int[] arr, int k) {
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        int window = 0;
        for (int i = 0; i < k; i++) {
            window += arr[i];
        }
        max = window;
        for (int i = k; i < n; i++) {
            window += arr[i] - arr[i - k];
            max = Math.max(max, window);
        }
        return max;
    }
    private static int max(int[] arr, int k){
        int n = arr.length;
        int window = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <k; i++) {
            window += arr[i];
        }
        max = window;
        for (int i = k; i < n; i++) {
            window += arr[i] - arr[i-k];
            max = Math.max(max,window);
        }
        return max;
    }
}