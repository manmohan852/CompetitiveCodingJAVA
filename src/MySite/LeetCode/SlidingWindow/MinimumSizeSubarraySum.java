package MySite.LeetCode.SlidingWindow;
//https://leetcode.com/problems/minimum-size-subarray-sum/description/
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        int ans = minSubArrayLen(target, nums);
        System.out.println(ans);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            while(sum >= target){
                result = Math.min(result, i + 1 - left);
                sum -= nums[left];
                left++;
            }
        }
        return (result != Integer.MAX_VALUE) ? result : 0;
    }
}
