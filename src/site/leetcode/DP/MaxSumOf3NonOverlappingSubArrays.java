package site.leetcode.DP;
//https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/
//689. Maximum Sum of 3 Non-Overlapping Subarrays
//https://leetcode.com/problems/maximum-sum-of-3-non-overlapping-subarrays/discuss/485832/Java-75-Clean-Solution-with-Explanation
public class MaxSumOf3NonOverlappingSubArrays {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[nums.length];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i >= k) {
                sum -= nums[i - k];
            }
            if (i >= k - 1) {
                dp[i - k + 1] = sum;
            }
        }
        // Calculate best possible right subarray at every index.
        int[] maxFromRight = new int[n];
        maxFromRight[n - 1] = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (dp[i] >= dp[maxFromRight[i + 1]]) {
                maxFromRight[i] = i;
            } else {
                maxFromRight[i] = maxFromRight[i + 1];
            }
        }
        // Calculate best possible left subarray at every index.
        int[] maxFromLeft = new int[n];
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[maxFromLeft[i - 1]]) {
                maxFromLeft[i] = i;
            } else {
                maxFromLeft[i] = maxFromLeft[i - 1];
            }
        }
        int max = 0;
        int maxIndex = k;
        // Calculate best possible mid-subarray along with left and right.
        for (int i = k; i <= n - (k * 2); i++) {
            sum = dp[i] + dp[maxFromLeft[i - k]] + dp[maxFromRight[i + k]];
            if (sum > max) {
                max = sum;
                maxIndex = i;
            }
        }
        return new int[]{maxFromLeft[maxIndex - k], maxIndex, maxFromRight[maxIndex + k]};
    }
}