package MySite.LeetCode.Array;

import java.util.HashSet;
// https://leetcode.com/problems/longest-consecutive-sequence/
public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        int max = 0, prevVal = 0, nextVal = 0, res = 0;
        for(int i : nums){
            max = 1;
            prevVal = i - 1;
            nextVal = i + 1;
            while(set.contains(prevVal)){
                max++;
                set.remove(prevVal--);
            }
            while(set.contains(nextVal)){
                max++;
                set.remove(nextVal++);
            }
            res = Math.max(max, res);
        }
        return res;
    }
}
