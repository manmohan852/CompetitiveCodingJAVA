package site.leetcode.DP;

import java.util.Arrays;
//https://leetcode.com/problems/jump-game-v/
//1340. Jump Game V
public class JumpGameV {
    public int maxJumps(int[] a, int d) {
        if (a == null || a.length == 0) return 0;
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, solve(i, a, d, dp));
        }
        return max + 1;
    }

    private int solve(int i, int[] a, int d, int[] dp) {
        int n = a.length;
        if (dp[i] != -1) return dp[i];
        int max = 0;
        for (int j = i + 1; j <= Math.min(i + d, n - 1); j++) {
            if (a[j] >= a[i]) break;
            max = Math.max(max, 1 + solve(j, a, d, dp));
        }
        for (int j = i - 1; j >= Math.max(i - d, 0); j--) {
            if (a[j] >= a[i]) break;
            max = Math.max(max, 1 + solve(j, a, d, dp));
        }
        dp[i] = max;
        return max;
    }
}
