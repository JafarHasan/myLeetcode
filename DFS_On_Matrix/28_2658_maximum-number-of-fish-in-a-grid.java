
class Solution {

    public int findMaxFish(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int maxFish = 0;
        boolean vis[][] = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if its not a cell check from here
                if (grid[i][j] > 0 && !vis[i][j]) {
                    maxFish = Math.max(maxFish, dfs(i, j, n, m, grid, vis));
                }
            }
        }
        return maxFish;
    }

    private int dfs(int i, int j, int n, int m, int[][] grid, boolean[][] vis) {
        if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0 || vis[i][j]) {
            return 0;
        }
        vis[i][j] = true;
        // Collect fish from the current cell
        int fish = grid[i][j];
        // left
        fish += dfs(i, j + 1, n, m, grid, vis);
        // right
        fish += dfs(i, j - 1, n, m, grid, vis);
        // up
        fish += dfs(i - 1, j, n, m, grid, vis);
        // down
        fish += dfs(i + 1, j, n, m, grid, vis);

        return fish;
    }
}
