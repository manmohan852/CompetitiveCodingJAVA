package MySite.LeetCode.Random;
// https://leetcode.com/problems/jump-game-ii/description/
public class JumpGameII {
    public static void main(String[] args) {
    int[] nums = {2, 3, 1, 1, 4};
    int jumps = jump(nums);
    System.out.println(jumps);
    }// we know that the test case is  designed to make you reach the n - 1, so we calculate the
    // farthest the point we can reach at each iteration then when our current position is equal to farthest
    public static int jump(int[] nums) {
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