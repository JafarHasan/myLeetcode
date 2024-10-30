package DFS_On_Matrix;

import java.util.*;

class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int dp[][] = new int[n][m];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, n, m, grid, dp);

    }

    private int dfs(int i, int j, int n, int m, int[][] grid, int[][] dp) {
        if (i >= n || j >= m) {
            return Integer.MAX_VALUE;
        }
        // Base case: If we reached the bottom-right cell, return its value
        if (i == n - 1 && j == m - 1) {
            return grid[i][j];
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        // Down
        int down = dfs(i + 1, j, n, m, grid, dp);
        // right
        int right = dfs(i, j + 1, n, m, grid, dp);
        return dp[i][j] = grid[i][j] + Math.min(right, down);

    }
}