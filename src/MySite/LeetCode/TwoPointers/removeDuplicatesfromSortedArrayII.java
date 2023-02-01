package MySite.LeetCode.TwoPointers;

public class removeDuplicatesfromSortedArrayII {
    public static void main(String[] args) {

    }
    public  static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int l = 0;
        int r = 1;
        int counter = 0;
        while(r < n){
            if(nums[l] != nums[r]){
                l++;
                nums[l] = nums[r];
                counter = 0;
            }else if(nums[l] == nums[r] && counter < 1){
                counter++;
                l++;
                nums[l] = nums[r];
            }
            r++;
        }
        return l + 1;
    }
}
