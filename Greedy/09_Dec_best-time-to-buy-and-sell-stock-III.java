
class Solution {

    int[][][] dp;

    private int solve(int idx, int buy, int[] prices, int limit) {
        if (idx == prices.length) {
            return 0;
        }
        if (limit == 0) {
            return 0;
        }
        if (dp[idx][buy][limit] != -1) {
            return dp[idx][buy][limit];
        }
        int profit = 0;
        // if we dont buy a stock(buy is allowed) so buy it or skip it
        if (buy == 1) {
            int buyIt = -prices[idx] + solve(idx + 1, 0, prices, limit);
            int skip = 0 + solve(idx + 1, 1, prices, limit);
            profit = Math.max(buyIt, skip);

            // we hv bought already(buy is not allowed) so sell it (here one transaction is complete if sold) or
            // skip it
        } else {
            // we sold so now we can buy (buy is allowed)
            int sellIt = prices[idx] + solve(idx + 1, 1, prices, limit - 1);
            // if we dont sell so we cant buy(buy is not allowed)
            int skip = 0 + solve(idx + 1, 0, prices, limit);
            profit = Math.max(sellIt, skip);
        }
        return dp[idx][buy][limit] = profit;
    }

    public int maxProfit2(int[] prices) {
        dp = new int[prices.length][2][3];//no of elements(indices),buy/sell/limit(0,1,2)
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1); // Fill each 1D array with -1
            }
        }
        return solve(0, 1, prices, 2);
    }

    public int maxProfit1(int[] prices) {
        int n = prices.length, pass[] = new int[n], buy = Integer.MAX_VALUE, sell = 0, prof = 0, i;
        // Pass 1: Forward
        for (i = 0; i < n; i++) {
            if (buy > prices[i]) {
                buy = sell = prices[i];
            }
            sell = Math.max(sell, prices[i]);
            pass[i] = prof = Math.max(prof, sell - buy);
        }

        // Pass 2: Reversed
        int res = pass[n - 1];
        for (i = n - 1, sell = prof = 0, buy = Integer.MAX_VALUE; i > 0; --i) {
            if (sell < prices[i]) {
                sell = buy = prices[i];
            }
            buy = Math.min(buy, prices[i]);
            res = Math.max(res, pass[i - 1] + sell - buy);
        }
        return res;
    }

    public int maxProfit(int[] prices) {
        //int n = prices.length;
        int firstBuy = Integer.MAX_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MAX_VALUE;
        int secondSell = 0;
        for (int price : prices) {
            firstBuy = Math.min(firstBuy, price);
            firstSell = Math.max(firstSell, price - firstBuy);
            secondBuy = Math.min(secondBuy, price - firstSell);
            secondSell = Math.max(secondSell, price - secondBuy);
        }

        return secondSell;
    }

}
