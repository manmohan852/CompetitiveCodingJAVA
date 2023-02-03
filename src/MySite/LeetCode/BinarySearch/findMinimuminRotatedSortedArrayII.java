package MySite.LeetCode.BinarySearch;
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
public class findMinimuminRotatedSortedArrayII {
    public static void main(String[] args) {

    }
    public int findMin(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        while(l < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > nums[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return Math.min(nums[l], nums[r]);
    }
}
