
import java.util.*;

class Solution {

    public void setZeroes(int[][] matrix) {
        List<int[]> idx = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    idx.add(new int[]{i, j});
                }
            }
        }

        for (int[] pos : idx) {
            int row = pos[0];
            int col = pos[1];
            setAllZeros(row, matrix);
            setColoum(col, matrix);
        }
    }

    private void setAllZeros(int row, int[][] mat) {
        for (int i = 0; i < mat[0].length; i++) {
            mat[row][i] = 0;
        }
    }

    private void setColoum(int col, int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            mat[i][col] = 0;
        }
    }
}
