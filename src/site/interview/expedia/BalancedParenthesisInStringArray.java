package site.interview.expedia;

import java.util.HashMap;
import java.util.Stack;

public class BalancedParenthesisInStringArray {

    public static boolean isValid(String s, HashMap<Character, Character> mappings) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    static String[] braces(String[] values) {
        HashMap<Character, Character> mappings = new HashMap<>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        int n = values.length;
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            if (isValid(values[i], mappings)) {
                ans[i] = "YES";
            } else {
                ans[i] = "NO";
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] values = {"[{}]", "[{]}"};
        braces(values);

    }
}
