package site.gfg.matrix;

//https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
public class AllPossiblePaths {

    //O(2^n) : exponential
    static int numberOfPaths1(int m, int n) {
        if (m == 1 || n == 1)
            return 1;
        return numberOfPaths1(m - 1, n) + numberOfPaths1(m, n - 1);
    }

    //O(mn)
    static int numberOfPaths2(int m, int n) {
        int count[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            count[i][0] = 1;
        for (int j = 0; j < n; j++)
            count[0][j] = 1;
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++)
                count[i][j] = count[i - 1][j] + count[i][j - 1]; //+ count[i-1][j-1];
        }
        return count[m - 1][n - 1];
    }

    //O(mn),space optimized
    //store the result for a single row at a time, size of the row = no of columns.
    static int numberOfPaths3(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }

    public static void main(String args[]) {
        System.out.println(numberOfPaths1(3, 3));
    }
}

