class Solution {

    public long maxMatrixSum(int[][] matrix) {
        int n = matrix.length;
        long sum = 0;
        int negNo = 0;
        int minAbsValue = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] < 0) {
                    negNo++;
                }
                minAbsValue = Math.min(minAbsValue, Math.abs(matrix[i][j]));
                sum += Math.abs(matrix[i][j]);
            }
        }
        if (negNo % 2 == 0)
            return sum;
        else {
            return sum - 2 * minAbsValue;
        }
    }
}