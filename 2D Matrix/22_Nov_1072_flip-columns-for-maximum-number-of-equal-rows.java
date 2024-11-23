class Solution {
    public int maxEqualRowsAfterFlips(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int ans = 0;

        for (int[] bin : mat) {
            // Create inverse of the current row
            int[] invBin = new int[m];
            for (int j = 0; j < m; j++) {
                invBin[j] = bin[j] == 0 ? 1 : 0;
            }

            // Compare with all rows
            int tmp = 0;
            for (int[] cur : mat) {
                if (Arrays.equals(cur, bin) || Arrays.equals(cur, invBin)) {
                    tmp++;
                }
            }

            ans = Math.max(tmp, ans);
        }

        return ans;
    }
}