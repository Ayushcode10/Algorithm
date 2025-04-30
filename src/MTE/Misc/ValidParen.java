package MTE.Misc;

import java.lang.invoke.VarHandle;
import java.util.Stack;

public class ValidParen {
    public static void main(String[] args) {
        System.out.println(isvalid("(())"));
    }
    private static boolean isvalid(String s){
        Stack<Character> st = new Stack<>();
        for(char c : s.toCharArray()){
            if(c == '{' || c=='[' || c=='('){
                st.push(c);
            }
            else{
                if (st.isEmpty()) return false;
                if((c=='}' && st.pop() != '{') ||
                        (c == ']' && st.pop() != '[') ||
                        (c==')' && st.pop() != '(')) return false;
            }
        }
        return st.isEmpty();
    }
}
