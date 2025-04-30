package MTE.Misc;

import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6};
        System.out.println(find(arr,3));
    }

    private static int find(int[] arr, int k){
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for(int i : arr){
            heap.offer(i);
            if (heap.size() > k) heap.poll();
        }
        return heap.isEmpty() ? -1 : heap.peek();
    }
}
