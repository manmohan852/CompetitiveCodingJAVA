package site.leetcode.DP;

//https://leetcode.com/problems/jump-game/
public class JumpGame {


    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    //BAckTracking
    //Time complexity : O(2^n)
    //Space complexity : O(n)
    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    //Greedy
    //Time complexity : O(n)
    //Space complexity : O(1)
    public boolean canJump3(int[] nums){
        if(nums.length==0)
            return false;
        int moves_available = nums[0];
        for(int i=1;i<nums.length;i++){
            moves_available--;
            if(moves_available<0){
                return false;
            }
            moves_available = Math.max(moves_available,nums[i]);
        }
        return true;
    }

    //Greedy
    //Time complexity : O(n)
    //Space complexity : O(1)
    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }



}
