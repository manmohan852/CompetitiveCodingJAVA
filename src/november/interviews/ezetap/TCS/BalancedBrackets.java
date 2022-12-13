package november.interviews.ezetap.TCS;

import java.util.Stack;

public class BalancedBrackets {
    public static void main(String[] args) {
        String str = "({[{}]})";
        boolean ans = BalancedBrackets(str);
        System.out.println(ans);
    }
    public static boolean BalancedBrackets(String str){

        Stack<Character> st = new Stack<Character>();

        for(int i = 0; i < str.length(); i++){
            char expr = str.charAt(i);
            if(expr == '(' || expr == '[' || expr == '{'){
                st.push(expr);
                continue;
            }
            char check = st.peek();
            if(expr == ')' && check == '(') {
                st.pop();
            }else if(expr == ']' && check == '[') {
                st.pop();
            }else if(expr == '}' && check == '{'){
                st.pop();
            }
        }
        if(st.isEmpty()) return true;
        else return false;
    }
}
