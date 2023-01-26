package MySite.LeetCode.TwoPointers;
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
public class twoSumSortedArray {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};

    }
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n - 1;
        int sum = 0;
        while(l < r){
            sum = nums[l] + nums[r];
            if(sum == target) return new int[] {l + 1, r + 1};
            else if(sum > target){
                r--;
            }
            else if (sum < target){
                l++;
            }
        }
        return new int[] {-1, -1};
    }
}
