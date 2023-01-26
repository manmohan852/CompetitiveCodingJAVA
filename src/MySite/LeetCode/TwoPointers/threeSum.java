package MySite.LeetCode.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class threeSum {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6 ,1 ,2, 1};
        
    }
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outputArray = new ArrayList<>();
        int n = nums.length;
        for(int i = 0; i < n - 2; i++){
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1]) ){
                int L = i + 1;
                int R = n - 1;
                int sum = 0 - nums[i];
                while(L < R){
                    if(nums[L] + nums[R] == sum) {
                        outputArray.add(Arrays.asList(nums[i], nums[L], nums[R]));
                        while(L < R && nums[L] == nums[L + 1]) L++;
                        while(L < R && nums[R] == nums[R - 1]) R--;
                        L++;
                        R--;
                    }
                    else if(nums[L] + nums[R] > sum){
                        R--;
                    }
                    else{
                        L++;
                    }
                }
            }
        }
        return outputArray;
    }
}
