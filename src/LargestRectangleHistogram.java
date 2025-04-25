import java.util.Stack;

public class LargestRectangleHistogram {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(largest(arr));
    }

    private static int largest(int[] arr){
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int n = arr.length;
        int[] prevS = new int[n];
        int[] nextS = new int[n];
        prevS[0] = -1;
        nextS[n-1] = n;
        int max = Integer.MIN_VALUE;
        //prev smaller
        for (int i = 1; i < n; i++) {
            while (st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            prevS[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        //next smaller
        st.clear();
        for (int i = n-1; i >= 0; i--) {
            while (st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            nextS[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(max,arr[i]*(nextS[i] - prevS[i] - 1));
        }
        return max;
    }
}
