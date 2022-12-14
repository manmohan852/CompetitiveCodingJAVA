package MySite.TwoPointers;

public class removeDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int nums[] = {0,0,1,1,1,2,2,3,3,4};
        int ans = removeDuplicates(nums);
        System.out.println(ans);
    }
    public static int removeDuplicates(int[] nums) {
        int l = 0;
        int n = nums.length;
        int r = 1;
        while(r < n){
            if(nums[l] != nums[r]){
                l++;
                nums[l] = nums[r];
            }
            r++;
        }
        return l + 1;
    }
}
