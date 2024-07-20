class Solution {
    // TC:O(m+n) SC:O(1)
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {

        int n = rowSum.length;
        int m = colSum.length;

        int min = Integer.MAX_VALUE;
        int ans[][] = new int[n][m];
        int i = 0;// row
        int j = 0;// col
        while (i < n && j < m) {
            ans[i][j] = Math.min(rowSum[i], colSum[j]);
            rowSum[i] = rowSum[i] - ans[i][j];
            colSum[j] = colSum[j] - ans[i][j];

            if (rowSum[i] == 0) {
                i++;
            }
            if (colSum[j] == 0) {
                j++;
            }

        }
        return ans;
    }
}