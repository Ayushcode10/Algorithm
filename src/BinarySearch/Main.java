package BinarySearch;

public class Main {
    public static void main(String[] args) {
        int[] arr = {-2,-1,0,4,5,6};
        System.out.println(countNeg(arr));
    }

    public static int bs(int[] arr, int target){
        int n = arr.length;
        int l = 0;
        int r = n-1;
        while(l<=r){
            int m = l+(r-l)/2;
            if(arr[m] == target){
                return m;
            }
            else if (arr[m] < target) {
                l = m+1;
            }
            else{
                r = m-1;
            }
        }
        return -1;
    }

    public static int countNeg(int[] arr){ //in sorted Misc.arr
        int l = 0;
        int r = arr.length-1;
        int count = 0;
        while (l<=r){
            int m = l + (r-l)/2;
            if(arr[m] < 0){
                count = m+1;
                l= m+1;

            } else if (arr[m]>=0) {
                r = m-1;
            }
        }
        return count;
    }
}
