class Solution {
    // TC:O(N) SC:O(1) passed
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int n = prices.length;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            int diff = prices[i] - min;
            maxProfit = Math.max(maxProfit, diff);
            min = Math.min(prices[i], min);
        }
        return maxProfit;
    }
}

class Solution2 {
    // TC:O(N) SC:O(N) passed
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        int min[] = new int[n];
        min[0] = prices[0];
        // Track min element till i_th idx
        for (int i = 1; i < n; i++) {
            min[i] = Math.min(min[i - 1], prices[i]);
        }
        // find Max difference
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, prices[i] - min[i]);
        }
        return ans;
    }
}

class Solution3 {
    // BT Approach TC:O(N^2) SC:O(1) 203/212 passed TLE
    public int maxProfit(int[] prices) {
        int ans = 0;
        int n = prices.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                ans = Math.max(ans, (prices[j] - prices[i]));
            }
        }
        return ans;
    }
}