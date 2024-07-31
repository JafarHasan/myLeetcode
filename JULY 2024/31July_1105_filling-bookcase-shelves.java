class Solution {
    int WIDTH;
    int dp[][];

    // TC:O(N*WIDTH) SC:O(N*width) TC:O(N^2) SC:O(N^2)
    public int solve(int idx, int[][] books, int remainingWidth, int maxHeight) {
        if (idx >= books.length) {
            return maxHeight;
        }
        if (dp[idx][remainingWidth] != 0) {
            return dp[idx][remainingWidth];
        }
        // getting current books width and height
        int bookWidth = books[idx][0];
        int bookHeight = books[idx][1];

        int keep = Integer.MAX_VALUE;
        int skip = Integer.MAX_VALUE;
        // pick
        if (bookWidth <= remainingWidth) {
            // keep in current shelf
            keep = solve(idx + 1, books, remainingWidth - bookWidth, Math.max(bookHeight, maxHeight));
        }
        // not pick (prevoius height+calculating curr height)
        skip = maxHeight + solve(idx + 1, books, WIDTH - bookWidth, bookHeight);

        return dp[idx][remainingWidth] = Math.min(keep, skip);
    }

    public int minHeightShelves(int[][] books, int sw) {
        dp = new int[1001][1001];
        int n = books.length;
        WIDTH = sw;
        int remainingWidth = sw;
        return solve(0, books, remainingWidth, 0);
    }
}