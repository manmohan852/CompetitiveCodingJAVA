package site.leetcode.DP;
//https://leetcode.com/problems/number-of-dice-rolls-with-target-sum/
public class NumberOfDiceRollsWithTargetSum {

    ////O(d * f * target)
    public static int numRollsToTarget(int d, int f, int target) {
        int mod = 1_000_000_007;
        int[][] dp = new int[d + 1][target + 1];
        for(int j = 1; j <= f && j <= target; j++) {
            dp[1][j] = 1;
        }
        for(int i = 2; i <= d; i++) {
            for(int j = 1; j <= target; j++) {
                for(int k = 1; k < j && k <= f; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][j-k]) % mod;
                }
            }
        }
        return dp[d][target];
    }

    //O(d * target)
    public static int numRollsToTarget2(int d, int f, int target) {
        int[][] dp = new int[d + 1][target + 1];
        int mod = (int) 1e9 + 7;
        for (int i = 1; i <= Math.min(target, f); i++) dp[1][i] = 1;
        for (int i = 2; i <= d; i++) {
            int sum = 0;
            for (int j = 0; j <= Math.min(target, i * f); j++) { // past j = i * f, all values will be zero, so we can stop here
                dp[i][j] = sum;
                // keep a running sum by adding new numbers to the sum
                sum = (sum + dp[i - 1][j]) % mod;
                if (j >= f) {
                    // remove numbers which have fallen out of the current tracked segment
                    sum = (sum - dp[i - 1][j - f] + mod) % mod;
                }
            }
        }
        return dp[d][target];
    }

    public static void main(String[] args) {
        //case 1
        int d = 2;
        int f = 6;
        int target = 7;
        numRollsToTarget(d,f,target);
    }
}
