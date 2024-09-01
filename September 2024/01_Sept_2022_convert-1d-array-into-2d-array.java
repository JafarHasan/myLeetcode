class Solution {
    // TC:O(n*m) SC;O(1)
    public int[][] construct2DArray(int[] org, int m, int n) {
        int len = org.length;
        if (len != (m * n)) {
            return new int[0][0];
        }
        int ans[][] = new int[m][n];
        int k = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[i][j] = org[k++];
            }
        }
        return ans;
    }
}