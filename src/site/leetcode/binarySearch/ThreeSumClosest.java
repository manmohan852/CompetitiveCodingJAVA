package site.leetcode.binarySearch;

import java.util.Arrays;

//https://leetcode.com/problems/3sum-closest/
//https://www.interviewbit.com/problems/3-sum/
public class ThreeSumClosest {

    public static int threeSumClosest(int[] A, int B) {
        int res = 0, diff = Integer.MAX_VALUE;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            int j = i + 1, k = A.length - 1;
            while (j < k) {
                int sum = A[i] + A[j] + A[k];
                if (sum == B) return sum;
                else if (sum > B) k--;
                else j++;
                if (Math.abs(B - sum) < diff) {
                    res = sum;
                    diff = Math.abs(B - sum);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        threeSumClosest(nums, target);
    }
}
