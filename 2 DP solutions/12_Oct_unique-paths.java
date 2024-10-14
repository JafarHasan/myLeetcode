import java.util.*;

class Solution {
    // Best 0ms TC:O(2^n) sc:O(N)
    int dp[][];

    private int dfs(int n, int m, int i, int j) {
        if (i >= n || j >= m)
            return 0;
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (dp[i][j] != -1)
            return dp[i][j];
        // down
        int down = dfs(n, m, i + 1, j);
        // right
        int right = dfs(n, m, i, j + 1);
        return dp[i][j] = down + right;

    }

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(m, n, 0, 0);
    }
}

class Solution2 {
    // TLE 38/63 TC:O(2^n) sc:O(N)
    private int dfs(int n, int m, int i, int j) {
        if (i >= n || j >= m)
            return 0;
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        // down
        int down = dfs(n, m, i + 1, j);
        // right
        int right = dfs(n, m, i, j + 1);
        return down + right;

    }

    public int uniquePaths(int m, int n) {
        return dfs(m, n, 0, 0);
    }
}