package MTE.Stack;

import javax.xml.transform.stax.StAXResult;
import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        System.out.println(Arrays.toString(nse(arr)));
    }

    private static int[] nse(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
        }
        return res;
    }

}
