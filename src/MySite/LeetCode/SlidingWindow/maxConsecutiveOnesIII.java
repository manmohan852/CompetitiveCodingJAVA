package MySite.LeetCode.SlidingWindow;
// https://leetcode.com/problems/max-consecutive-ones-iii/
public class maxConsecutiveOnesIII {
    public static void main(String[] args) {

    }
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        if(n < 2 && k > 0) return n;
        int l = 0, r = 0;
        int counter = 0;
        int maxLen = 0;
        while(r < n){
            if(nums[r] == 0){
                counter++;
            }
            while(counter > k){
                if(nums[l] == 0){
                    counter--;
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;

        }
        return maxLen;
    }
}
