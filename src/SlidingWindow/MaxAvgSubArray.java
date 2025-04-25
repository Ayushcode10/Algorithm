package SlidingWindow;

public class MaxAvgSubArray {
    public static void main(String[] args) {
        int[] arr = {1,12,-5,-6,50,3};
        System.out.println(sub(arr,4));
    }

    public static double sub(int[] arr, int k) {
        int n = arr.length;
        int left =0, right = 0;
        int sum = 0, max = Integer.MIN_VALUE;
        while (right<n){
            sum += arr[right];
            if(right - left + 1 == k){
                max = Math.max(max, sum);
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return (double) max/k;
    }

}
