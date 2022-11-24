package site.interview.microsoft;

import java.util.Arrays;
//https://leetcode.com/problems/max-chunks-to-make-sorted/
public class MaxChunksToSortArray {

    public static void main(String[] args) {
        int[] nums1 = {2,4,1,6,5,9,7};
        int[] nums2 = {4,3,2,6,1};
        int[] nums3 = {2,1,6,4,3,7};
        System.out.println(solve(nums1));
        System.out.println(solve(nums2));
        System.out.println(solve(nums3));
    }

    private static int solve(int[] nums) {
        int res = 0, copySum = 0, oriSum = 0;
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);
        for(int i=0;i<nums.length;i++) {
            copySum += copy[i];
            oriSum += nums[i];
            if(copySum == oriSum)
                res++;
        }
        return res;
    }

    public static int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            if (max == i) ans++;
        }
        return ans;
    }
}
