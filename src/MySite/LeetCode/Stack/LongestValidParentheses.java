package MySite.LeetCode.Stack;

import java.util.Stack;

// https://leetcode.com/problems/longest-valid-parentheses/description/
public class LongestValidParentheses {
    public static void main(String[] args) {

    }
    public int longestValidParentheses(String s) {
        Stack<Character> st = new Stack();
        Stack<Integer> index = new Stack();
        index.push(-1);
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                st.push(c);
                index.push(i);
            }
            else{
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                    index.pop();
                    max = Math.max(max, i - index.peek());
                }else{
                    index.push(i);
                }
            }
        }
        return max;
    }
}
