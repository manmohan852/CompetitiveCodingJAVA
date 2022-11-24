package site.leetcode.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/minimum-size-subarray-sum/solution/
public class MinimumSizeSubarraySum {


    //    Time complexity: O(n^2)
//    Time complexity to find all the subarrays is O(n^2)
//    Sum of the subarrays is calculated in O(1) time.
//    Thus, the total time complexity: O(n^2 * 1) = O(n^2)
//Space complexity: O(n)
    public static int minSubArrayLen3(int target, int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[n];
        sums[0] = nums[0];
        for (int i = 1; i < n; i++)
            sums[i] = sums[i - 1] + nums[i];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = sums[j] - sums[i] + nums[i]; // sum[i] - nums[i] = sum[i-1]
                // sum = sum[j] - sum [i-1]
                if (sum >= target) {
                    ans = Math.min(ans, (j - i + 1));
                    break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
                }
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }


    //Using Binary search
//    https://leetcode.com/problems/minimum-size-subarray-sum/discuss/672784/Binary-Search-on-Possible-Solutions%3A-O(nlogn)-Java-Solution-Beats-99.88-Time-and-98.94-Space
//    If the maximum subarray sum for every contiguous array of size K is smaller than the given target sum,
//    we can determine that any contiguous array of size K' (where K' < K)
//    will not have array sum that's greater than our target sum.

    public int minSubArrayLen4(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int minLen = Integer.MAX_VALUE;
        int n = nums.length;
        // Construct array of prefix sum
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            prefixSum[i] = nums[i - 1] + prefixSum[i - 1];
        }
        // Do binary search on possible lengths from 0 to n
        // For each possible length len, we check every contiguous arrays with size len
        // to see if the sum is greater than s, if so, we update the min length, if not, keep searching
        int l = 0, r = n;
        while (l < r) {
            int len = (r + l) / 2;
            for (int i = len; i <= n; i++) {
                if (prefixSum[i] - prefixSum[i - len] >= s) {
                    minLen = len;
                    r = len;
                    break;    // once we find a sum of contiguous array with size len, we can stop searching for current length
                }
            }
            if (r != len) {
                l = len + 1;
            }
        }
        for (int i = r; i <= n; i++) {
            if (prefixSum[i] - prefixSum[i - r] >= s) {
                minLen = r;
                break;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

//    public static int minSubArrayLen2(int target, int[] nums) {
//        int n = nums.length;
//        if (n == 0)
//            return 0;
//        int ans = Integer.MAX_VALUE;
//        int[] sums = new int[n + 1];
//        //size = n+1 for easier calculations
//        //sums[0]=0 : Meaning that it is the sum of first 0 elements
//        //sums[1]=A[0] : Sum of first 1 elements
//        //ans so on...
//        for (int i = 1; i <= n; i++)
//            sums[i] = sums[i - 1] + nums[i - 1];
//
//        for (int i = 1; i <= n; i++) {
//            int to_find = target + sums[i - 1];
//            int lowerBound = bound(sums, to_find, true);
//            if (lowerBound != sums.length) {
//                ans = Math.min(ans, lowerBound - (sums.begin() + i - 1)));
//            }
//        }
//        return (ans != Integer.MAX_VALUE) ? ans : 0;
//    }

    public static Integer bound(int[] A, int to_find, boolean searchFirst) {
        List<Integer> C = Arrays.stream(A).boxed().collect(Collectors.toList());
        return bound(C, to_find, searchFirst);
    }

    public static Integer bound(final List<Integer> A, int B, boolean searchFirst) {
        int n = A.size();
        int low = 0;
        int high = n - 1;
        int res = -1;   //if element not found
        int mid;
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (A.get(mid) == B) {
                res = mid;
                if (searchFirst) {
                    high = mid - 1;
                }    //to find first , go left
                else {
                    low = mid + 1;
                }                // to find last, go right
            } else if (B > A.get(mid)) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    //Two Pointers Approach
    //Time complexity: O(n)
    //Space complexity: O(1)
    public static int minSubArrayLen(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int sum = 7;
        int minlength = minSubArrayLen(sum, nums);
        System.out.println(minlength);
    }
}
