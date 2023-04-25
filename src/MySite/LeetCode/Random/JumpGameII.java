package MySite.LeetCode.Random;
// https://leetcode.com/problems/jump-game-ii/description/
public class JumpGameII {
    public static void main(String[] args) {

    }
    public int jump(int[] nums) {
        int farthest = 0, current = 0, jumps = 0;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            farthest = Math.max(farthest, i + nums[i]);
            if(current == n - 1) break;
            //when i == n - 1 and current is also n - 1 then an extra jump is added.
            if(i == current){
                current = farthest;
                jumps++;
            }
        }
        return jumps;
    }
}
