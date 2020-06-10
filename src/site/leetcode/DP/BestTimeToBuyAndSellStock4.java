package site.leetcode.DP;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
//188. Best Time to Buy and Sell Stock IV
//https://www.evernote.com/shard/s688/client/snv?noteGuid=bac328a0-a62e-4b61-89fb-b28d69d7e6d1&noteKey=5e7fff43bfe40f37&sn=https%3A%2F%2Fwww.evernote.com%2Fshard%2Fs688%2Fsh%2Fbac328a0-a62e-4b61-89fb-b28d69d7e6d1%2F5e7fff43bfe40f37&title=123.%2BBest%2BTime%2BTo%2Bbuy%2Band%2Bsell%2Bstock%2Biii
public class BestTimeToBuyAndSellStock4 {
    public int maxProfit(int k, int[] ps) {
        int n = ps.length;
        if (n < 2) return 0;
        if (k >= n>>1) return accumu(ps);
        int[][][] dp = new int[k+1][n][2];  // tx, day, stock holds
        for (int i = 1 ; i <= k; i++){
            dp[i][0][1] = - ps[0];
            for (int j = 1; j < n; j++) {
                dp[i][j][0] = Math.max(dp[i][j-1][0], dp[i][j - 1][1] + ps[j]); //sell
                dp[i][j][1] = Math.max(dp[i][j-1][1], dp[i - 1][j - 1][0] - ps[j]);//buy
            }
        }
        return dp[k][n-1][0];
    }

    //if(K > N/2){
    private int accumu(int[] ps){
        int res = 0;
        for (int i = 1; i < ps.length; i++) {
            res += Math.max(0, ps[i] - ps[i - 1]);
        }
        return res;
    }
}

//    This question can be asked with any no of transactions so i'll tell you how to solve it for K transactions allowed
//        create an array dp[N][K][2]
//
////N number of days
//// max K transactions
//// cash and hold <--- {0,1}
////also we can sell and then buy on same day but not the reverse
//        where dp[i][k][0]   is the maximum cash money obtained after K transactions on day i
//        dp[i][k][1] is the maximum invested money(hold) in stock after K transaction on day i
//
//        Initials :
//        dp[0][k][0] = 0;                              // we cannot sell on first day
//        dp[0][k][1] = -prices[i];                  // we can buy on first day
//
//        for 1st transaction:
//        dp[i][0][0] = max(don't sell on this day, sell on this day)
//        = max(dp[i-1][0][0], dp[i-1][0][1] + prices[i])       // prices[i] -> selling price  and dp[i-1][0][1] -> buying price
//
//        dp[i][0][1] = max(don't buy on this day, buy on this day)
//        = max(dp[i-1][0][1], -prices[i])
//
//
//        for any other transaction k>0:                             (0 means 1st transaction)
//        dp[i][k][0] = max(don't sell on this day, sell on this day)
//        = max(dp[i-1][k][0], dp[i-1][k][1] + prices[i])
//        dp[i][k][1] = max(don't buy on this day, buy on this day)
//        = max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i])
//// dp[i-1][k-1][0] is the profit obtained uptill k-1th transaction
//// if now  buy a stock hold income will become : dp[i-1][k-1][0] - prices[i]
//
//        finally, return dp[N-1][K-1][0]                                    //N-1 and K-1 because indices start with 0 but meaning is same Nth day and Kth transaction
