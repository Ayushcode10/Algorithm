package MTE.slidingWindow;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class DequeMaxSlideWindow {
    /*Algo
        1.Use a deque to store indexes of useful elements in curr window
        2.Remove elements outside the window
        3.Maintain deque in decreasing order
        4.First element is max of the window
 */
    public static void main(String[] args) {
        int[] arr = {1,3,-1,-3,5,3,6,7};
        int[] res = prac(arr,3);
        System.out.println(Arrays.toString(res));
    }
    private static int[] max(int[] arr, int k){
        int n = arr.length;
        if(n == 0) return new int[0];
        int[] res = new int[n-k+1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if(!deque.isEmpty() && deque.peek() == i-k){
                deque.poll();
            }
            while(!deque.isEmpty() && arr[deque.peekLast()] < arr[i]){
                deque.pollLast();
            }
            deque.offer(i);
            if(!deque.isEmpty() && i >= k-1){
                res[i-k+1] = arr[deque.peek()];
            }
        }
        return res;
    }

    private static int[] prac(int[] arr, int k){
        int n = arr.length;
        if(n == 0) return new int[0];
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if(!dq.isEmpty() && dq.peek() == i-k){
                dq.poll();
            }
            while(!dq.isEmpty() && arr[dq.peekLast()] < arr[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(!dq.isEmpty() && i >= k-1){
                res[i-k+1] = arr[dq.peek()];
            }
        }
        return res;
    }

}
