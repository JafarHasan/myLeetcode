import java.util.ArrayList;
import java.util.List;

class Solution {
    // TC:O(NXM) SC:O(1)
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> al = new ArrayList<>();
        int row = 0, col = 0;
        int n = mat.length;
        int m = mat[0].length;
        while (row < n && col < m) {
            // traverse first row straight 0-m-1
            for (int r = row; r < m; r++) {
                al.add(mat[row][r]);
            }
            // move to the next row
            row++;

            // traverse last col prevRow+1->n-1;
            for (int c = row; c < n; c++) {
                al.add(mat[c][m - 1]);
            }
            // move to the 2nd last col
            m--;

            // traverse last row reverse second last col->0
            if (row < n) {
                for (int r = m - 1; r >= col; r--) {
                    al.add(mat[n - 1][r]);
                }
                n--;
            }
            // travrse first col reverse down->top
            if (col < m) {
                for (int c = n - 1; c >= row; c--) {
                    al.add(mat[c][col]);
                }
                col++;
            }

        }
        return al;
    }

}

class Solution2 {
    public List<Integer> spiralOrder2(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int rows = matrix.length, cols = matrix[0].length;
        int left = 0, right = cols - 1, top = 0, bottom = rows - 1;

        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }
}