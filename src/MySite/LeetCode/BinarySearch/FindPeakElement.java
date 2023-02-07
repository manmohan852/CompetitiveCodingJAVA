package MySite.LeetCode.BinarySearch;
// https://leetcode.com/problems/find-peak-element/
public class FindPeakElement {
    public static void main(String[] args) {

    }
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l = 0, r = n - 1;
        int mid = 0;
        while(l < r){
            mid = l + (r - l) / 2;
            if(nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }else{
                r = mid;
            }
        }
        return r;
    }
}
