public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        int pos = 0;
        int maxProfit = 0;
        while (pos < prices.length - 1) {
            while (pos < prices.length - 1 && prices[pos] >= prices[pos + 1]) ++pos;
            int valley = prices[pos];
            while (pos < prices.length - 1 && prices[pos] <= prices[pos + 1]) ++pos;
            int peak = prices[pos];
            maxProfit += peak - valley;
        }
        return maxProfit;
    }
}