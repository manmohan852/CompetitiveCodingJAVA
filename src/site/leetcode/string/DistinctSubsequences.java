package site.leetcode.string;
//https://leetcode.com/problems/distinct-subsequences/
public class DistinctSubsequences {

    //for visuals see leetcode solutions
    public static int numDistinct(String s, String t) {
        int M = s.length();
        int N = t.length();
        int[][] dp = new int[M + 1][N + 1];
        for (int j = 0; j <= N; j++) {
            dp[M][j] = 0;
        }
        for (int i = 0; i <= M; i++) {
            dp[i][N] = 1;
        }
        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                dp[i][j] = dp[i + 1][j];
                if (s.charAt(i) == t.charAt(j)) {
                    dp[i][j] += dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String source = "rabbbit";
        String target = "rabbit";
        numDistinct(source,target);
    }
}