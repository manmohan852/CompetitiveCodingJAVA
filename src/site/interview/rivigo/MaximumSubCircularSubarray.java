package site.interview.rivigo;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/maximum-sum-circular-subarray/solution/
public class MaximumSubCircularSubarray {

    //Approach 2: Prefix Sums + Monoqueue
    //Time Complexity: O(N)
    //Space Complexity: O(N)
    public static int maxSubarraySumCircular(int[] A) {
        int N = A.length;
        // Compute P[j] = B[0] + B[1] + ... + B[j-1]
        // for fixed array B = A+A
        int[] P = new int[2 * N + 1];
        for (int i = 0; i < 2 * N; ++i)
            P[i + 1] = P[i] + A[i % N];
        // Want largest P[j] - P[i] with 1 <= j-i <= N
        // For each j, want smallest P[i] with i >= j-N
        int ans = A[0];
        // deque: i's, increasing by P[i]
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        for (int j = 1; j <= 2 * N; ++j) {
            // If the smallest i is too small, remove it.
            if (deque.peekFirst() < j - N)
                deque.pollFirst();

            // The optimal i is deque[0], for cand. answer P[j] - P[i].
            ans = Math.max(ans, P[j] - P[deque.peekFirst()]);

            // Remove any i1's with P[i2] <= P[i1].
            while (!deque.isEmpty() && P[j] <= P[deque.peekLast()])
                deque.pollLast();

            deque.offerLast(j);
        }
        return ans;
    }


//Approach 3: Kadane's (Sign Variant)
//Time Complexity: O(N)
//Space Complexity: O(1)

    //    concept: For two-interval subarrays, let BB be the array AA with each element multiplied by -1−1.
//    Then the answer for two-interval subarrays is \text{sum}(A) + \text{kadane}(B)sum(A)+kadane(B).
//
//    Except, this isn't quite true, as if the subarray of BB we choose is the entire array,
//    the resulting two interval subarray [0, i] + [j, N-1][0,i]+[j,N−1] would be empty.
//
//    We can remedy this problem by doing Kadane twice: once on BB with the first element removed,
//    and once on BB with the last element removed.
    public static int maxSubarraySumCircular2(int[] A) {
        int S = 0;  // S = sum(A)
        for (int x : A)
            S += x;

        int ans1 = kadane(A, 0, A.length - 1, 1);
        int ans2 = S + kadane(A, 1, A.length - 1, -1);
        int ans3 = S + kadane(A, 0, A.length - 2, -1);
        return Math.max(ans1, Math.max(ans2, ans3));
    }

    public static int kadane(int[] A, int i, int j, int sign) {
        // The maximum non-empty subarray for array
        // [sign * A[i], sign * A[i+1], ..., sign * A[j]]
        int ans = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for (int k = i; k <= j; ++k) {
            cur = sign * A[k] + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }
        return ans;
    }

    //Approach 3: Kadane's (Min Variant)
    //Time Complexity: O(N)
    //Space Complexity: O(1)
    //the interior [i+1, j-1][i+1,j−1] must be non-empty, we can break up our search into a search on A[1:] and on A[:-1].
    public int maxSubarraySumCircular3(int[] A) {
        // S: sum of A
        int S = 0;
        for (int x : A)
            S += x;

        // ans1: answer for one-interval subarray
        int ans1 = Integer.MIN_VALUE;
        int cur = Integer.MIN_VALUE;
        for (int x : A) {
            cur = x + Math.max(cur, 0);
            ans1 = Math.max(ans1, cur);
        }

        // ans2: answer for two-interval subarray, interior in A[1:]
        int ans2 = Integer.MAX_VALUE;
        cur = Integer.MAX_VALUE;
        for (int i = 1; i < A.length; ++i) {
            cur = A[i] + Math.min(cur, 0);
            ans2 = Math.min(ans2, cur);
        }
        ans2 = S - ans2;

        // ans3: answer for two-interval subarray, interior in A[:-1]
        int ans3 = Integer.MAX_VALUE;
        cur = Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 1; ++i) {
            cur = A[i] + Math.min(cur, 0);
            ans3 = Math.min(ans3, cur);
        }
        ans3 = S - ans3;

        return Math.max(ans1, Math.max(ans2, ans3));
    }

    public static void main(String[] args) {
        int[] arr = {3, -1, 2, -1};
        int[] arr2 = {-3, -1, -2, -1};
        maxSubarraySumCircular2(arr2);
    }


}
