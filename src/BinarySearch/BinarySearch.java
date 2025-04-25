package BinarySearch;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {8,7,6,-5,-10,-11,-15,-20,-20, -22};
//        System.out.println(bs2(Misc.arr, -20,0,Misc.arr.length-1))
        System.out.println(neg(arr));
    }

    public static int neg(int[] arr){
        int count = 0;
        int f = 0;
        int l = arr.length-1;

        while(f<=l){
            int m = (f+l)/2;

            if(arr[m] < 0){

                count = arr.length-m;
                l = m-1;
            }
            else if(arr[m] > 0){
                f = m+1;
            }
        }
        return count;
    }
    public static int bs2(int[] arr, int k, int f, int l){

        if(f>l){
            return -1;
        }
        int m = (f+l)/2;
        if(arr[m] == k){
            return m;
        }
        else if(arr[m] < k){
            return bs2(arr,k,f,m-1);
        }
        else {
            return bs2(arr, k, m+1,l);
        }
    }
    public static int bs(int[] arr, int k){
        int f = 0;
        int l = arr.length-1;

        while(f<=l){
            int m = (f+l)/2;

            if(arr[m] < k){
                l = m-1;
            }
            else if (arr[m] > k) {
               f = m+1;
            }
            else {
                return m;
            }
        }
        return -1;
    }
}
