package site.leetcode.DP;

import java.util.Arrays;

//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
//123. Best Time to Buy and Sell Stock III
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/discuss/135704/Detail-explanation-of-DP-solution
public class BestTimeToBuyAndSellStock3 {

    //time complexity is O(n)
    public int MaxProfitDpCompactFinal(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }

//    Time complexity is O(kn), space complexity is O(kn).
    public int MaxProfitDpCompact1(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[3][prices.length];
        for (int k = 1; k <= 2; k++) {
            int min = prices[0];
            for (int i = 1; i < prices.length; i++) {
                min = Math.min(min, prices[i] - dp[k-1][i-1]);
                dp[k][i] = Math.max(dp[k][i-1], prices[i] - min);
            }
        }
        return dp[2][prices.length - 1];
    }

    //    Time complexity is O(kn), space complexity is O(kn).
    public int MaxProfitDpCompact1T(int[] prices) {
        if (prices.length == 0) return 0;
        int[][] dp = new int[3][prices.length];
        int[] min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.min(min[k], prices[i] - dp[k-1][i-1]);
                dp[k][i] = Math.max(dp[k][i-1], prices[i] - min[k]);
            }
        }
        return dp[2][prices.length - 1];
    }

    public int MaxProfitDpCompact2(int[] prices) {
        if (prices.length == 0) return 0;
        int[] dp = new int[3];
        int[] min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < prices.length; i++)  {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.min(min[k], prices[i] - dp[k-1]);
                dp[k] = Math.max(dp[k], prices[i] - min[k]);
            }
        }
        return dp[2];
    }
}
