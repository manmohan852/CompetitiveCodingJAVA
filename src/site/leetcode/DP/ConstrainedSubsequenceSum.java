package site.leetcode.DP;

import java.util.Deque;
import java.util.LinkedList;
//https://leetcode.com/problems/constrained-subsequence-sum/
public class ConstrainedSubsequenceSum {

    //DP Straight forward - TLE
    //Time: O(N*K)
    //Space: O(N)
    public int constrainedSubsetSum(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = Math.max(i - k, 0); j < i; j++) { // choose the max element in latest k elements, it's in range [i-k, i-1]
                max = Math.max(max, dp[j]);
            }
            dp[i] = arr[i] + max;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    //DP + Decreasing Monotonic Queue
    //We need to get the max element in k latest elements in O(1) by using Decreasing Monotonic Queue
    //Time: O(N)
    //Space: O(N)
    public int constrainedSubsetSum2(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = Math.max(0, deque.isEmpty() ? 0 : dp[deque.peekFirst()]);
            dp[i] = arr[i] + max;
            ans = Math.max(ans, dp[i]);
            while (!deque.isEmpty() && dp[i] >= dp[deque.peekLast()]) { // If dp[i] >= deque.peekLast() -> Can discard the tail since it's useless
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - deque.peekFirst() + 1 > k) { // remove the last element of range k
                deque.removeFirst();
            }
        }
        return ans;
    }

    //DP + Decreasing Monotonic Queue + Optimized Space
    //Time: O(N)
    //Space: O(K)
    public int constrainedSubsetSum3(int[] arr, int k) {
        int n = arr.length;
        Deque<Integer> deque = new LinkedList<>();
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int max = Math.max(0, deque.isEmpty() ? 0 : arr[deque.peekFirst()]);
            arr[i] += max;
            ans = Math.max(ans, arr[i]);
            while (!deque.isEmpty() && arr[i] >= arr[deque.peekLast()]) { // If dp[i] >= deque.peekLast() -> Can discard the tail since it's useless
                deque.pollLast();
            }
            deque.addLast(i);
            if (i - deque.peekFirst() + 1 > k) { // remove the last element of range k
                deque.removeFirst();
            }
        }
        return ans;
    }

}
