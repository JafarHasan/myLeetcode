class Solution {
    //its a concept of nextSmallerElementTORight
    // TC:O(N^2) SC:O(1)
    private int findNextSmaller(int arr[], int idx, int val) {
        int n = arr.length;
        for (int i = idx + 1; i < n; i++) {
            if (arr[i] <= val)
                return arr[i];
        }
        return 0;
    }

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = prices[i] - findNextSmaller(prices, i, prices[i]);
        }
        return ans;
    }
}