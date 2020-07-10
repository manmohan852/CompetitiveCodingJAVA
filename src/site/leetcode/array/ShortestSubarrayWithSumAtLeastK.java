package site.leetcode.array;

import java.util.Deque;
import java.util.LinkedList;

//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/
//explanation: https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/discuss/653554/Java-Code-with-detailed-explanation
public class ShortestSubarrayWithSumAtLeastK {

    /**
     * Idea:
     * The problem can be solved using prefix sum and some more idea.
     * Here we maintain prefix sum of each elements.
     * PrefixSum(i) = A[0] + A[1] + .. + A[i-1]
     *
     * Our goal is to find two index in A (x, y) such that y > x and [PrefixSum(y) - PrefixSum(x)] >= K
     *
     * Now the catch is we always have to keep increasing prefix sums which can be a valid x,y
     * Say we are evaluating a and b as to be x, now a < b but PrefixSum(a) > PrefixSum(b)
     * Then 'a' can never be a candidate for x becasue,
     * PrefixSum(a) <= PrefixSum(y) - k
     * Then, PrefixSum(b) <= PrefixSum(a) <= PrefixSum(y) - k
     * From above equation we can see 'b' will be a better candidate to be 'x' because originally index b is closer to index y
     * Meaning (y - b) < (y - a) [as a < b]
     * So we can never work with a smaller prefix sum after a larger prefix sum, our goal is to reduce length as much as possible
     * **** We have to maintain a monotonically increasing queue of prefix sums ****
     *
     * 1. Maintain a queue of indexes
     * 2. Indexes can only be in the queue if the current index being scanned is having a higher prefixSum
     * 3. Meaning we pop all indexes from back which are having higher prefix sum
     * 4. Then we pop all indexes from the front which satisfies the criteria PrefixSum(current index) - PrefixSum(front index) >= k
     * 5. We keep track of minimum as we do operation of step 4
     *
     * Time and Space Complexity: O(N)
     */

    //Time and Space Complexity: O(N)
    public int shortestSubarray(int[] A, int K) {
        long[] prefixSums = new long[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + A[i];
        }
        int shortestLength = A.length + 1; // This is not a valid value
        // The is queue of index which maintains only those index which is having
        // monotonically increasing prefix sum
        Deque<Integer> indexQofincreasingPreSum = new LinkedList();
        // idx represents the index of actual value
        for (int idx = 0; idx < prefixSums.length; idx++) {
            // Remove any index which is having the larger prefix sum then current index
            // because for larger prefix sums, if they are > k then definitely we have
            // already considered them for min length
            while (!indexQofincreasingPreSum.isEmpty()
                    && prefixSums[idx] <= prefixSums[indexQofincreasingPreSum.peekLast()]) {
                indexQofincreasingPreSum.pollLast();
            }
            // We check from beginning of the queue to see if any index is matching our criteria
            // We keep on checking if the criteria is matched
            while (!indexQofincreasingPreSum.isEmpty()
                    && prefixSums[idx] >= prefixSums[indexQofincreasingPreSum.peekFirst()] + K) {
                int frontIndex = indexQofincreasingPreSum.pollFirst();
                shortestLength = Math.min(shortestLength, (idx - frontIndex));
            }
            indexQofincreasingPreSum.addLast(idx);
        }
        return shortestLength < A.length + 1 ? shortestLength : -1;
    }

}
