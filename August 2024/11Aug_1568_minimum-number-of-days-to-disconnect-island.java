class Solution {
    // no of islands>1 || no of island==0 ans is 0 disconnected grid
    // TC:O(nxm)^2
    // SC:O(nxm)
    public int minDays(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int islands = noOfIsland(grid, n, m);
        if (islands > 1 || islands == 0) {
            return 0;
        } else {
            // check if we can disconnected thegrid in 1 day
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (grid[i][j] == 1) {
                        // convert to water
                        grid[i][j] = 0;

                        islands = noOfIsland(grid, n, m);
                        if (islands > 1 || islands == 0) {
                            return 1;
                        }
                        // reset water to land again
                        grid[i][j] = 1;// goto next cell
                    }
                }
            }

        }
        return 2;

    }

    public int noOfIsland(int[][] grid, int n, int m) {
        int islands = 0;
        int[][] vis = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] != 1) {// land found and its not visited
                    dfs(grid, i, j, n, m, vis);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void dfs(int[][] grid, int i, int j, int n, int m, int[][] vis) {
        if (i < 0 || i >= n || j < 0 || j >= m || vis[i][j] == 1 || grid[i][j] == 0) {
            return;
        }
        vis[i][j] = 1;// mark visited

        dfs(grid, i + 1, j, n, m, vis);
        dfs(grid, i - 1, j, n, m, vis);
        dfs(grid, i, j + 1, n, m, vis);
        dfs(grid, i, j - 1, n, m, vis);
    }

}