package MySite.LeetCode.Random;
// https://leetcode.com/problems/jump-game/solutions/3435741/simple-clean-java-solution/
public class JumpGame {
    public static void main(String[] args) {

    }
    public boolean canJump(int[] nums) {
        if(nums.length <= 1){
            return true;
        }
        int stepsleft = nums[0];
        int index = 1;
        while(stepsleft > 0){
            if (index == nums.length-1){
                return true;
            }
            stepsleft = Math.max(stepsleft-1, nums[index]);
            index++;
        }
        return false;
    }
}
