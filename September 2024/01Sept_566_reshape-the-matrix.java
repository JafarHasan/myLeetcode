class Solution {
    // TC:O(n*m) SC:O(1)
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int n = mat.length;
        int m = mat[0].length;
        if (n * m != r * c) {
            return mat;
        }
        int ans[][] = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                ans[row][col] = mat[i][j];
                col++;
                if (col == c) {
                    col = 0;
                    row++;
                }
            }
        }
        return ans;
    }
}