package MySite.LeetCode.BinarySearch;
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
public class FindMinimuminRotatedSortedArray {
    public static void main(String[] args) {

    }
    public int findMin(int[] nums) {
        int n = nums.length;
        int L = 0, R = n - 1;
        if(nums[L] < nums[R]) return nums[L];
        while(L + 1 < R){
            int mid = L + (R - L)/ 2;
            if(nums[mid] > nums[R]) {
                L = mid;
            }else {
                R = mid;
            }
        }
        return Math.min(nums[L] , nums[R]);
    }
}
