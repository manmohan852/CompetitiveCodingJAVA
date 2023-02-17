package MySite.LeetCode.Stack;

import java.util.Stack;
// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public static void main(String[] args) {

    }
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) return false;
        Stack<Character> st = new Stack();
        for(int i = 0; i < s.length(); i++){
            char x = s.charAt(i);
            if(x == '(' || x == '[' || x == '{'){
                st.push(x);
            }
            else if(x == ')' && !st.isEmpty() && st.peek() == '('){
                st.pop();
            }else if(x == ']' && !st.isEmpty() && st.peek() == '['){
                st.pop();
            }else if(x == '}' && !st.isEmpty() && st.peek() == '{'){
                st.pop();
            }
            else return false;
        }

        return st.isEmpty();
    }
}
