package BinarySearch;

public class singleElementSorted {
    public static void main(String[] args) {
        int[] arr = {3,3,7,7,10,11,11};
        System.out.println(singleNonDuplicate(arr,arr.length));
    }
    public static int singleNonDuplicate(int[] arr, int n){
        n = arr.length;
        if(n==1 || arr[0] != arr[1]) return arr[0];
        if(arr[n-1] != arr[n-2]) return arr[n-1];
        int l = 1, r= n-2;
        while(l<=r){
            int m = l+(r-l)/2;
            if (arr[m] != arr[m - 1] && arr[m] != arr[m + 1]) {
                return arr[m];
            }

            if ((m % 2 == 0 && arr[m] == arr[m + 1]) || (m % 2 == 1 && arr[m] == arr[m - 1])) {
                l = m + 1;
            } else {
                r = m - 1;
            }

        }
        return -1;
    }
}
