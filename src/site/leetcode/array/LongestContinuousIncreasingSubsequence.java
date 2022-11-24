package site.leetcode.array;
//https://leetcode.com/problems/longest-continuous-increasing-subsequence/
public class LongestContinuousIncreasingSubsequence {

    //Time Complexity: O(N),
    public static int findLengthOfLCIS(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 1, 2, 3};
        findLengthOfLCIS(nums);
    }
}
