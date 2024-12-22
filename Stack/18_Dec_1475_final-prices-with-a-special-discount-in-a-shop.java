
class Solution {
    // TC:O(N^2) SC:O(1) beats 98%
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

class Solution2 {
    // its a concept of nextSmallerElementTORight
    // TC:O(N) SC:O(N) beats 40% 4ms
    private int[] findNextSmaller(int arr[]) {
        int n = arr.length;
        Stack<Integer> st = new Stack<>();
        int nse[] = new int[n];
        nse[n - 1] = 0;
        st.push(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            int ele = arr[i];
            while (!st.isEmpty() && ele < st.peek()) {
                st.pop();
            }
            if (st.isEmpty()) {
                nse[i] = 0;
            } else {
                nse[i] = st.peek();
            }
            st.push(ele);
        }
        return nse;
    }

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int ans[] = new int[n];
        int nse[] = findNextSmaller(prices);
        for (int i = 0; i < n; i++) {
            ans[i] = prices[i] - nse[i];
        }
        return ans;
    }
}