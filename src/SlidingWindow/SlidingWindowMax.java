package SlidingWindow;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindowMax {
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(maxInWindow1(arr,3)));
    }


    //this is the bruteforce approach
    public static int[] maxInWindow1(int[] arr, int k){
        int n = arr.length;
        int[] res = new int[n-k+1];
        for (int i = 0; i <= n-k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = i; j < i+k; j++) {
                max = Math.max(max,arr[j]);
            }
            res[i] = max;
        }
        return res;
    }

//    this is an optimal solution
    public static int[] maxInWindow2(int[] arr, int k){
        int n = arr.length;
        int[] res = new int[n-k+1];
        Deque<Integer> q = new LinkedList<>();
        int i = 0, j = 0;
        while (j<n){

        while(!q.isEmpty() && arr[q.peekLast()] <= arr[j]){
            q.pollLast();
        }
        q.offerLast(j);
        while (!q.isEmpty() && q.peekFirst() < j-k+1){
            q.pollFirst();
        }
        if(j>=k-1){
            res[i] = arr[q.peekFirst()];
            i++;
        }
            j++;
        }
        return res;
    }
}
