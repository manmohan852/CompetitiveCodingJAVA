package site.gfg.dp;

//https://www.geeksforgeeks.org/count-number-of-ways-to-partition-a-set-into-k-subsets/

public class WaysToPartitionSetsIntoKSubsets {

    //Time complexity:O(n*k).
    static int countPartitionDP(int n, int k) {
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= k; i++)
            dp[0][k] = 0;
        for (int i = 1; i <= n; i++)
            for (int j = 1; j <= k; j++)
                if (j == 1 || i == j)
                    dp[i][j] = 1;
                else
                    dp[i][j] = j * dp[i - 1][j] + dp[i - 1][j - 1];

        return dp[n][k];

    }

    //    Time complexity: O(2^n).
    public static int countPartition(int n, int k) {
        if (n == 0 || k == 0 || k > n)
            return 0;
        if (k == 1 || k == n)
            return 1;

        return (k * countPartition(n - 1, k)
                + countPartition(n - 1, k - 1));
    }

    public static void main(String[] args) {
        System.out.println(countPartition(5, 2));
    }
}

