package MySite.LeetCode.SlidingWindow;
// https://leetcode.com/problems/max-consecutive-ones/
public class maxConsecutiveOnes {
    public static void main(String[] args) {

    }
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int maxLen = 0;
        int counter = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                counter = 0;
            }else{
                counter++;
                maxLen = Math.max(maxLen, counter);
            }
        }
        return maxLen;
    }
}
