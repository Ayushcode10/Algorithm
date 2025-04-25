package BinarySearch;

public class SearchInRotatedMat {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr,0));
    }
    public static int search(int[] arr, int target){
        int n = arr.length;
        int left = 0;
        int right = n-1;

        while(left <= right){
            int m = left + (right - left)/2;
            if(arr[m] == target){
                return m;
            }
            if(arr[left]<=arr[m]){
                if(target >= arr[left] && target < arr[m]){
                    right = m-1;
                }
                else{
                    left = m+1;
                }
            }
            else {
                if(target > arr[m] && target <= arr[right]){
                    left = m+1;
                }
                else {
                    right = m-1;
                }
            }
        }
        return -1;
    }
}
