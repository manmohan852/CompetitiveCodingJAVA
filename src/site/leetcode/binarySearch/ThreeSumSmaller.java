package site.leetcode.binarySearch;

import java.util.Arrays;
//https://leetcode.com/problems/3sum-smaller/
public class ThreeSumSmaller {

    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    private static int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {-2,0,1,3};
        int target = 2;
        threeSumSmaller(nums, target);
    }

}
