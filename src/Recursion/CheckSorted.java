package Recursion;

public class CheckSorted {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        System.out.println(isSorted(arr, 0));
    }

    public static boolean isSorted(int[] arr, int n){
        if(n == arr.length-1){
            return true;
        }
        if(arr[n] > arr[n+1]){
            return false;
        }
        return isSorted(arr,n+1);
    };

}
