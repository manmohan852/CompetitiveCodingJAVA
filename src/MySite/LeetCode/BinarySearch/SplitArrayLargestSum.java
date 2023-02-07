package MySite.LeetCode.BinarySearch;
// https://leetcode.com/problems/split-array-largest-sum/description/
public class SplitArrayLargestSum {
    public static void main(String[] args) {

    }
    public int splitArray(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        int ans = 0;
        for(int i = 0; i < nums.length; i++){
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        while(low <= high){
            int mid = low + (high - low)/ 2;
            int n = check(nums, mid);
            if(n > k){
                low = mid + 1;
            }
            else{
                ans = mid;
                high = mid - 1;
            }
        }
        return ans;
    }
    private int check(int[] nums, int mid){
        int sum = 0, count = 1;
        for(int i = 0; i < nums.length; i++){
            if(sum + nums[i] > mid){
                count++;
                sum = nums[i];
            }
            else{
                sum += nums[i];
            }
        }
        return count;
    }
}
