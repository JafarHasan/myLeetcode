class Solution {
    boolean isSubIsland;

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid2[i][j] == 1) {
                    isSubIsland = true;
                    dfs(i, j, n, m, grid1, grid2);
                    if (isSubIsland)
                        cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(int i, int j, int n, int m, int[][] grid1, int[][] grid2) {
        if (i >= n || j >= m || i < 0 || j < 0 || grid2[i][j] == 0) {
            return;
        }
        if (grid1[i][j] != grid2[i][j]) {
            isSubIsland = false;
        }

        // mark visited
        grid2[i][j] = 0;

        dfs(i + 1, j, n, m, grid1, grid2);
        dfs(i - 1, j, n, m, grid1, grid2);
        dfs(i, j + 1, n, m, grid1, grid2);
        dfs(i, j - 1, n, m, grid1, grid2);
    }
}