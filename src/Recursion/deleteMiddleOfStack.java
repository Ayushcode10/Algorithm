package Recursion;

import java.util.Stack;

public class deleteMiddleOfStack {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);
        s.push(50);
        delete(s);
        System.out.println(s);
    }
    public static void delete(Stack<Integer> s){
        helper(s,0,s.size());
    }

    public static void helper(Stack<Integer> s, int i,int n){
        if(i == n){
            return;
        }
        int t = s.peek();
        s.pop();
        helper(s,i+1,n);
        if(i == n/2) return;
        else s.push(t);
    }

}
