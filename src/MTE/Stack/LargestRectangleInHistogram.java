package MTE.Stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    /*Algo:
        1.Append 0 at the end of the height to flush stack
        2.use stack to keep increasing heights
        3.when height[i] < height[st.peek()], pop and:
            -calculate the width = i-st.peek()-1;
            -calculate area = h*w;
            update max area;
    */
    public static void main(String[] args){
        int[] arr = {2, 1, 5, 6, 2, 3};
        System.out.println(largestRec(arr));
    }
    private static int largestRec(int[] arr){
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;
        int[] h  = Arrays.copyOf(arr,arr.length+1);//add sentinel 0
        for (int i = 0; i < h.length; i++) {
            while (!st.isEmpty() && h[i] < h[st.peek()]){
                int height = h[st.pop()];
                int width = st.isEmpty()?-1:i-st.peek()-1;
                maxArea = Math.max(maxArea,height*width);
            }
            st.push(i);
        }
        return maxArea;
    }
}
