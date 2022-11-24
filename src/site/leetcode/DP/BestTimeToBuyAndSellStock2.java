package site.leetcode.DP;
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
//122. Best Time to Buy and Sell Stock II
//In every iteration, if the next value is greater than the current value keep moving forward,
// else we got our highest point.
//Subtract this value from the lowest point and add it to the result.
public class BestTimeToBuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int profit = 0;
        int i= 0,j=0;
        while(j<prices.length-1){
            if(prices[j] > prices[j+1]){  // check if price[j] is the highest point
                profit += prices[j]-prices[i];
                i=j+1; // store the next lowest point in i
            }
            j++;
        }
        profit+=prices[j]-prices[i];
        return profit;
    }
}
