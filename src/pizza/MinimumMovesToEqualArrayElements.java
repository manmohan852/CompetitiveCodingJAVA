package pizza;

import java.util.Arrays;

public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int count = minMoves2(nums);
        System.out.println(count);
    }
    private static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while(i < j){
            count += Math.abs(nums[j] - nums[i]);
            i++;
            j--;
        }
        return count;
    }
}

