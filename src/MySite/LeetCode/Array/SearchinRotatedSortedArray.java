package MySite.LeetCode.Array;
//https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchinRotatedSortedArray {
    public static void main(String[] args) {

    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        int L = 0;
        int R = n - 1;
        while(L <= R){
            int mid = L + (R - L) / 2;
            if(nums[mid] == target) return mid;
            if(nums[L] <= nums[mid]){
                if(target >= nums[L] && target < nums[mid]){
                    R = mid - 1;
                }
                else{
                    L = mid + 1;
                }
            }
            else{
                if(target <= nums[R] && target > nums[mid]){
                    L = mid + 1;
                }
                else{
                    R = mid - 1;
                }
            }
        }
        return -1;
    }
}
