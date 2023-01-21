package MySite.LeetCode.Array;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int result = maxProfit(prices);
        System.out.println(result);
    }
    public static int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            else {
                max = Math.max(max, prices[i] - min);
            }
        }
        return max;
    }
}
