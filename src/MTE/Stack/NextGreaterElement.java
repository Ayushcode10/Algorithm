package MTE.Stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    /*Algo
        1.use a stack to store indices
        2.Traverse the array from left to right
        3.for each element
            -pop elements from stack <= current
            -if stack is empty, ans = -1;
            -else->answer=stack.peek();
            -push curr element to the stack
   */
    public static void main(String[] args) {
        int[] arr = {4,5,2,10};
        System.out.println(Arrays.toString(prac(arr)));
    }
    public static int[] nge(int[] arr){
        int n = arr.length;
        int[] res = new int[n];

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i< n; i++) {
            while(!st.isEmpty() &&  st.peek() <= arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }

    private static int[] prac(int[] arr){
        int n = arr.length;
        int[] res = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            while(!st.isEmpty() && st.peek() <= arr[i]){
                st.pop();
            }
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }
}
