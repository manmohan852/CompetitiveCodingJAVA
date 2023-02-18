package MySite.LeetCode.Stack;

import java.util.Stack;
// https://cheonhyangzhang.gitbooks.io/leetcode-solutions/content/716-max-stack.html
public class maxStack {
    public static void main(String[] args) {

    }
    Stack<Integer> data = new Stack<Integer>();
    Stack<Integer> max = new Stack<Integer>();
    public void push(int x) {
        data.push(x);
        if (max.isEmpty()) {
            max.push(x);
        }
        else {
            max.push(Math.max(x, max.peek()));
        }
    }
    //O(1);
    public int pop() {
        max.pop();
        return data.pop();
    }
    //O(1);
    public int top() {
        return data.peek();
    }
    //O(1);
    public int peekMax() {
        return max.peek();
    }
    //O(n);
    public int popMax() {
        int res = max.peek();
        Stack<Integer> tmp = new Stack<Integer>();
        while (data.peek() != res) {
            tmp.push(data.pop());
            max.pop();
        }
        data.pop();
        max.pop();
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return res;
    }
}
