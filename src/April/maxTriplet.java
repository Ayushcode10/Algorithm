package April;


public class maxTriplet {
    public static void main(String[] args) {
        int[] arr = {12,6,1,2,7};
        System.out.println(optimized(arr));
    }


    //O(n^3) solution
    public static long bruteforce(int[] arr){
        int n = arr.length;
        long max = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    if(arr[i]-arr[j] > 0){
                        max = Math.max(max,((long) (arr[i] - arr[j]) *arr[k]));
                    }
                }
            }
        }
        return max;
    }

    //O(n) solution
    public static long optimized(int[] nums){
        //----GREEDY APPROACH-----//
        int n = nums.length;
        int imax = 0; //this stores the max value in the arr
        int dmax = 0; //this store the max difference seen in the arr so far
        long res = 0; // this calcs the max res by multiplying dmax*nums[num];
        for(int num : nums){
            res = Math.max(res,(long)dmax*num);
            dmax = Math.max(dmax,imax-num);
            imax = Math.max(imax, num);
        }
        return res;
    }
}
