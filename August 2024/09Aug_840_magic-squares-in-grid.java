class Solution {

    // TC:O(n*m) SC:O(1)
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if (n < 3 || m < 3)
            return 0;
        int cnt = 0;
        for (int i = 0; i <= n - 3; i++) {
            for (int j = 0; j <= m - 3; j++) {
                if (isMagicMatrix(grid, i, j)) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isMagicMatrix(int[][] grid, int x, int y) {
        // middle element should be 5
        if (grid[x + 1][y + 1] != 5)
            return false;

        // corners elements should be even 00,02,20,22
        if (grid[x][y] % 2 != 0 || grid[x][y + 2] % 2 != 0 || grid[x + 2][y] % 2 != 0 || grid[x + 2][y + 2] % 2 != 0)
            return false;

        // non corner should be Odd 01,10,12,21
        if (grid[x][y + 1] % 2 != 1 || grid[x + 1][y] % 2 != 1 || grid[x + 1][y + 2] % 2 != 1
                || grid[x + 2][y + 1] % 2 != 1)
            return false;

        // check row 0 sum==15 row 2 sum==15 and column 0 sum==15
        if ((grid[x][y] + grid[x][y + 1] + grid[x][y + 2]) != 15 || // row0
                (grid[x + 2][y] + grid[x + 2][y + 1] + grid[x + 2][y + 2]) != 15 || // row2
                (grid[x][y] + grid[x + 1][y] + grid[x + 2][y]) != 15) // column 0
            return false;

        return true;

    }
}