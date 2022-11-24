package site.leetcode.DP;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
//121. Best Time to Buy and Sell Stock
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, sell = 0;
        for(int p: prices){
            sell = Math.max(sell,buy+p);
            buy = Math.max(buy, -p);
        }
        return sell;
    }
}
