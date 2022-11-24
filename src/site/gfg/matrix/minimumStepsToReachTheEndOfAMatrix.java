package site.gfg.matrix;
//https://www.geeksforgeeks.org/find-minimum-steps-required-to-reach-the-end-of-a-matrix-set-1/
public class minimumStepsToReachTheEndOfAMatrix {

    static int n = 3;
    static int dp[][] = new int[n][n];
    static int[][] v = new int[n][n];
    static int minSteps(int i, int j, int arr[][]) {
        if (i == n - 1 && j == n - 1) {
            return 0;
        }
        if (i > n - 1 || j > n - 1) {
            return Integer.MAX_VALUE;
        }
        if (v[i][j] == 1) {
            return dp[i][j];
        }
        v[i][j] = 1;
        dp[i][j] = 1 + Math.min(minSteps(i + arr[i][j], j, arr), minSteps(i, j + arr[i][j], arr));
        return dp[i][j];
    }

    public static void main(String[] args) {
        int arr[][] = {{2, 1, 2}, {1, 1, 1}, {1, 1, 1}};
        int ans = minSteps(0, 0, arr);
        if (ans >= Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }
}