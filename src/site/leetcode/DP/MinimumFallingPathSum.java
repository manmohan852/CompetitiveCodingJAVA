package site.leetcode.DP;

//https://leetcode.com/problems/minimum-falling-path-sum/
//931. Minimum Falling Path Sum
public class MinimumFallingPathSum {

    public int minFallingPathSum(int[][] A) {
        int n = A.length;
        if (n == 1) {
            return A[0][0];
        }
        int[][] s = new int[n][n];
        for (int i = 0; i < n; i++) {
            s[0][i] = A[0][i];
        }
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    s[j][i] = Math.min(
                            s[j - 1][i], s[j - 1][i + 1]) + A[j][i];
                } else if (i == n - 1) {
                    s[j][i] = Math.min(s[j - 1][i], s[j - 1][i - 1]) + A[j][i];
                } else {
                    s[j][i] = A[j][i] + Math.min(
                            Math.min(s[j - 1][i], s[j - 1][i + 1]),
                            s[j - 1][i - 1]);
                }
            }
        }
        int res = s[n - 1][0];
        for (int i = 1; i < n; i++) {
            if (s[n - 1][i] < res) {
                res = s[n - 1][i];
            }
        }
        return res;
    }
}
