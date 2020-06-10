package site.leetcode.DFS;

import java.util.Arrays;
//https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
//329. Longest Increasing Path in a Matrix
public class LongestIncreasingPathInMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        int max = 0;
        long[][] memo = new long[matrix.length][matrix[0].length];
        Arrays.stream(memo).forEach(a -> Arrays.fill(a, Long.MIN_VALUE));
        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j<matrix[0].length; j++) {
                max = Math.max(dfs(matrix, i, j, Long.MIN_VALUE, memo), max);
            }
        }
        return max;
    }

    private int dfs(int[][] matrix, int r, int c, long prev, long[][] memo) {
        if(r >= matrix.length || r < 0 || c >=matrix[0].length || c < 0 || matrix[r][c] <= prev) {
            return 0;
        }
        if(memo[r][c] != Long.MIN_VALUE) {
            return (int)memo[r][c];
        }
        int up = dfs(matrix, r+1, c, matrix[r][c], memo);
        int down = dfs(matrix, r -1, c, matrix[r][c], memo);
        int left = dfs(matrix, r, c -1, matrix[r][c], memo);
        int right = dfs(matrix, r, c+1, matrix[r][c], memo);
        int max = Math.max(up, Math.max(down, Math.max(left, right)));
        memo[r][c] = 1 + max;
        return 1 + max;
    }
}
