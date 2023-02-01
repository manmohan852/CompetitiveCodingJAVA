package MySite.LeetCode.TwoPointers;

import java.util.Arrays;

public class threeSumClosest {
    public static void main(String[] args) {

    }
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int gap = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int l = i + 1;
            int r = n - 1;
            while(l < r){
                int curSum = nums[i] + nums[l] + nums[r];
                if(curSum == target){
                    return curSum;
                }else if(curSum < target){
                    l++;
                }
                else r--;
                int curGap = Math.abs(curSum - target);
                if(curGap < gap){
                    gap = curGap;
                    ans = curSum;
                }
            }
        }
        return ans;
    }
}
