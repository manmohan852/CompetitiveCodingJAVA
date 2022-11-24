package site.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Asked in amazon
//https://leetcode.com/problems/partition-equal-subset-sum/#:~:text=Partition%20Equal%20Subset%20Sum%20%2D%20LeetCode&text=Given%20a%20non%2Dempty%20array,element%20will%20not%20exceed%20100.
public class PartitionEqualSubsetSum {
    //Recursive
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        Arrays.sort(nums);
        List<Integer> list2 = new ArrayList<>();
        for (int num : nums) {
            list2.add(num);
        }
        return matchSum(list2,sum>>1);
    }

    private static boolean matchSum(List<Integer> nums, int target) {
        int total = 0;
        List<Integer> subList = new ArrayList<>();
        for(Integer num :nums){
            total += num;
            subList.add(num);
            if(total == target){
                return true;
            }else if(total > target){
                if(total - target >= target){
                    return false;
                }
                if(matchSum(subList,total-target)){
                    return true;
                }
            }
        }
        return target == 0;
    }

    //DP
    public static boolean canPartition2 (int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        sum >>= 1;
        boolean[] dp = new boolean[sum + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num]; //dp[0] will make dp[num] as true, similarly in the end, dp[sum] will be true of possible.
            }
        }
        return dp[sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5}; //true
        int[] nums1 = {1, 2, 3, 5}; //false

        canPartition2(nums);

    }
}
