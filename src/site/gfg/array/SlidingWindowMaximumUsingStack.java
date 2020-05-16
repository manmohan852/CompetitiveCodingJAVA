package site.gfg.array;

import java.util.Stack;

//https://www.geeksforgeeks.org/sliding-window-maximum-maximum-of-all-subarrays-of-size-k-using-stack-in-on-time/?ref=rp
//O(n)
public class SlidingWindowMaximumUsingStack {

    static void print_max(int a[], int n, int k) {
        int[] max_upto = new int[n];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int i = 1; i < n; i++) {
            while (!s.empty() && a[s.peek()] < a[i]) {
                max_upto[s.peek()] = i - 1;
                s.pop();
            }
            s.push(i);
        }
        while (!s.empty()) {
            max_upto[s.peek()] = n - 1;
            s.pop();
        }
        int j = 0;
        for (int i = 0; i <= n - k; i++) {
            while (j < i || max_upto[j] < i + k - 1) {
                j++;
            }
            System.out.print(a[j] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int a[] = {9, 7, 2, 4, 6, 8, 2, 1, 5};
        int n = a.length;
        int k = 3;
        print_max(a, n, k);

    }
}


