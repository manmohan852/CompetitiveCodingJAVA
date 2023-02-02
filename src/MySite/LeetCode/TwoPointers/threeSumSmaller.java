package MySite.LeetCode.TwoPointers;
// https://leetcode.com/problems/3sum-smaller/
import java.util.Arrays;

public class threeSumSmaller {
    public static void main(String[] args) {

    }
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int counter = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            int L = i + 1, R = n - 1;
            while(L < R){
                int curSum = nums[L] + nums[R] + nums[i];
                if(curSum < target){
                    counter += R - L;
                    L++;
                }else {
                    R--;
                }
            }
        }
        return counter;
    }
}
