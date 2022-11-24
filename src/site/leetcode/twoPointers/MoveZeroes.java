package site.leetcode.twoPointers;

import java.util.ArrayList;

//https://leetcode.com/problems/move-zeroes/
public class MoveZeroes {

    //Time Complexity: O(n);;  Space Complexity : O(n).
    void moveZeroes(int[] nums) {
        int n = nums.length;
        // Count the zeroes
        int numZeroes = 0;
        for (int i = 0; i < n; i++) {
            numZeroes += (nums[i] == 0) ? 1 : 0;
        }
        // Make all the non-zero elements retain their original order.
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                ans.add(nums[i]);
            }
        }
        // Move all zeroes to the end
        while (numZeroes > 0) {
            ans.add(0);
            numZeroes--;
        }
        // Combine the result
        for (int i = 0; i < n; i++) {
            nums[i] = ans.get(i);
        }
    }

    //Time Complexity: O(n);;  Space Complexity : O(1).
    void moveZeroes2(int[] nums) {
        int lastNonZeroFoundAt = 0;
        // If the current element is not 0, then we need to
        // append it just in front of last non 0 element we found.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }
        // After we have finished processing new elements,
        // all the non-zero elements are already at beginning of array.
        // We just need to fill remaining array with 0's.
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }


}
