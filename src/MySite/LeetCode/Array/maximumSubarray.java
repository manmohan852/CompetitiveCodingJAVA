package MySite.LeetCode.Array;
// https://leetcode.com/problems/maximum-subarray/description/
public class maximumSubarray {
    public static void main(String[] args) {

    }
    public int maxSubArray(int[] nums) {


//      We will need two variables. One will store current sub-array sum.
//      Other will store maximum sub-array sum.

        int curSum = nums[0];
        int maxSum = nums[0];   // consider 1st element to be greatest sub-array.

        for(int i = 1; i < nums.length; i++){

            // If the cur sub-array sum is negative then reset is to 0.
            if(curSum < 0)
            {
                curSum = 0;
            }

            // Iterate over the array and calculate sub-array sum.
            curSum += nums[i];

            // maxSum will be greater of curSum and maxSum.
            maxSum = Math.max(maxSum, curSum);

        }

        // finally, return the maxSum.
        return maxSum;

    }
}
