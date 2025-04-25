package SlidingWindow;

public class MinSizeSubArr {
    public static void main(String[] args) {
        int[] arr = {2,3,1,2,4,3};
        System.out.println(minSubArrLen(7,arr));
    }
    public static int minSubArrLen(int target, int[] arr){
        int n = arr.length;
        int i = 0, j = 0;
        int sum = 0, minSize = Integer.MAX_VALUE;

        while(j<n){
            sum += arr[j];
            while(sum>=target){
                minSize = Math.min(minSize,j-i+1);
                sum-=arr[i];
                i++;
            }
            j++;
        }
        return (minSize == Integer.MAX_VALUE) ? 0 : minSize;
    }
}
