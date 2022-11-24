package site.leetcode.DP;

//https://leetcode.com/problems/unique-paths-ii/
//63. Unique Paths II
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] grid) {
        int dp[][] = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    if (i == 0 && j == 0) {
                        dp[i][j] = 1;
                    } else if (i == 0) {
                        dp[i][j] = (grid[i][j - 1] == 0) ? dp[i][j - 1] : 0;
                    } else if (j == 0) {
                        dp[i][j] = (grid[i - 1][j] == 0) ? dp[i - 1][j] : 0;
                    } else {
                        dp[i][j] = ((grid[i - 1][j] == 0) ? dp[i - 1][j] : 0) + ((grid[i][j - 1] == 0) ? dp[i][j - 1] : 0);
                    }
                }
            }
        }
        return dp[grid.length - 1][dp[0].length - 1];
    }

}
