public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int profit = 0;
        int cur_profit = 0;
        for (int i = 1; i < prices.length; ++i) {
            cur_profit += prices[i] - prices[i - 1];
            if (cur_profit > profit)
                profit = cur_profit;
            else if (cur_profit < 0)
                cur_profit = 0;
        }
        return profit;
    }
}