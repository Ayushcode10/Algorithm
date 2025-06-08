package Greedy;

public class JumpGame {
    public static void main(String[] args) {
        int[] arr = {1,2};
        System.out.println(jumpGreedy(arr));
    }

    private static boolean jumpGreedy(int[] arr) {
        //greedy about max jump??-- lets see

        int n = arr.length;
        int farthest = 0;
        for(int i =0; i<n; i++){
            if(i>farthest){
                return false;
            }
            farthest = Math.max(farthest,i+arr[i]);
            if(farthest >= n-1) return true;
        }
        return false;
    }
}
