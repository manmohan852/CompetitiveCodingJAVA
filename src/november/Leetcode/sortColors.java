package november.Leetcode;
//https://leetcode.com/problems/sort-colors/description/
//https://leetcode.com/problems/move-zeroes/description/

//Time complexity : O(N) since it's one pass along the array of length N.
//
//        Space complexity : O(1) since it's a constant space solution.
public class sortColors {
    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        sortColors(nums);
        for(int i = 0; i < nums.length; i++){
            System.out.print(nums[i]);
        }
    }
    public static void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int curr = 0;
        int temp = 0;
        while(curr <= right){
            if(nums[curr] == 0){
                temp = nums[curr];
                nums[curr] = nums[left];
                nums[left] = temp;
                left++;
                curr++;
            }
            else if(nums[curr] == 2){
                temp = nums[curr];
                nums[curr] = nums[right];
                nums[right] = temp;
                right--;
            }
            else curr++;
        }
    }
}
