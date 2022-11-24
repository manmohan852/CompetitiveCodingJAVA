package site.gfg.dp;

import java.util.Arrays;

//https://www.geeksforgeeks.org/painting-fence-algorithm/
public class PaintingFenceProblem {

    static long countWays(int n, int k) {
        long dp[] = new long[n + 1];
        Arrays.fill(dp, 0);
        int mod = 1000000007;
        dp[1] = k;
        int same = 0, diff = k;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = (int) (dp[i - 1] * (k - 1));
            diff = diff % mod;
            dp[i] = (same + diff) % mod;
        }
        return dp[n];
    }

    static long countWays2(int n, int k) {
        long total = k;
        int mod = 1000000007;
        int same = 0, diff = k;
        for (int i = 2; i <= n; i++) {
            same = diff;
            diff = (int) total * (k - 1);
            diff = diff % mod;
            total = (same + diff) % mod;
        }
        return total;
    }

    public static void main(String[] args) {
        int n = 3, k = 2;
        System.out.println(countWays(n, k));
    }
}

