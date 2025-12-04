class Solution {
    int[][] grid;
    int mod = 1000000007;
    Integer[][][] dp;
    int k;

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length, m = grid[0].length;
        this.grid = grid;
        this.k = k;
        dp = new Integer[n][m][k];
        return solve(0, 0, 0);
    }

    private int solve(int i, int j, int rem) {
        int n = grid.length, m = grid[0].length;

        if (i >= n || j >= m)
            return 0;

        rem = (rem + grid[i][j]) % k;

        if (i == n - 1 && j == m - 1)
            return rem == 0 ? 1 : 0;

        if (dp[i][j][rem] != null)
            return dp[i][j][rem];

        int down = solve(i + 1, j, rem);
        int right = solve(i, j + 1, rem);

        return dp[i][j][rem] = (down + right) % mod;
    }
}

class Solution_Bf {
    private int mod = 1000000007;

    public int numberOfPaths(int[][] grid, int k) {
        return solve(0, 0, grid.length, grid[0].length, grid, k, 0);
    }

    private int solve(int i, int j, int n, int m, int[][] grid, int k, int sum) {
        if (i >= n || j >= m)
            return 0;
        sum = (sum + grid[i][j]) % k;
        if (i == n - 1 && j == m - 1)
            return (sum == 0) ? 1 : 0;

        return (solve(i + 1, j, n, m, grid, k, sum + grid[i][j]) + solve(i, j + 1, n, m, grid, k, sum + grid[i][j]))%mod;
    }
}