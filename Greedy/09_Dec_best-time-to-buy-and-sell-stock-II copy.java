
class Solution {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy = prices[0];
        int profit = 0;
        for (int i = 1; i < n; i++) {
            if (buy < prices[i]) {
                profit += prices[i] - buy;
            }
            buy = prices[i];
        }
        return profit;
    }

    public int maxProfit1(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy < prices[i]) {
                // sell this stock and add profit
                maxProfit += prices[i] - buy;
            }
            // buy this curr stock here
            buy = prices[i];
        }
        return maxProfit;
    }

    // prices =
    // [5,7,1,4,2]
    // Output
    // 5
    // Expected
    // 5
}
