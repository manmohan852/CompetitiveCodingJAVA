package site.leetcode.stack;

//https://leetcode.com/problems/design-a-stack-with-increment-operation/
//1381. Design a Stack With Increment Operation
public class StackWithIncrementOperation {
}

class CustomStack {
    int[] arr;
    int head, maxSize;

    public CustomStack(int maxSize) {
        arr = new int[maxSize];
        this.maxSize = maxSize;
        head = 0;
    }

    public void push(int x) {
        if (head < maxSize) {
            arr[head++] = x;
        }
    }

    public int pop() {
        if (head > 0) {
            return arr[--head];
        }
        return -1;
    }

    public void increment(int k, int val) {
        for (int i = 0; i < Math.min(k, head); i++) {
            arr[i] += val;
        }
    }

}