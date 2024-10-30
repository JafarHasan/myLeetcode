class Solution {
    /// Beats 100% using DP
    public int maxMoves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxMoves = 0;

        // Memoization array to store max moves from each cell
        Integer[][] memo = new Integer[n][m];

        for (int i = 0; i < n; i++) {
            maxMoves = Math.max(maxMoves, dfs(i, 0, n, m, grid, memo));
        }

        return maxMoves;
    }

    private int dfs(int i, int j, int n, int m, int[][] grid, Integer[][] memo) {
        // Boundary check
        if (i < 0 || i >= n || j >= m)
            return 0;

        // If already calculated, return the stored value
        if (memo[i][j] != null)
            return memo[i][j];

        int maxMove = 0;

        // Upward
        if (i > 0 && j < m - 1 && grid[i][j] < grid[i - 1][j + 1]) {
            maxMove = Math.max(maxMove, 1 + dfs(i - 1, j + 1, n, m, grid, memo));
        }

        // Rightward
        if (j < m - 1 && grid[i][j] < grid[i][j + 1]) {
            maxMove = Math.max(maxMove, 1 + dfs(i, j + 1, n, m, grid, memo));
        }

        // Downward
        if (i < n - 1 && j < m - 1 && grid[i][j] < grid[i + 1][j + 1]) {
            maxMove = Math.max(maxMove, 1 + dfs(i + 1, j + 1, n, m, grid, memo));
        }

        // Store the result in memo
        memo[i][j] = maxMove;
        return maxMove;
    }
}
