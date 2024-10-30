package DFS_On_Matrix;

import java.util.*;

class Solution {
    // bottom -up Best approach beats 98%

    public int countSquares(int[][] matrix) {
        int rowSize = matrix.length;
        int colSize = matrix[0].length;

        for (int i = 1; i < rowSize; i++) {
            for (int j = 1; j < colSize; j++) {
                if (matrix[i][j] == 1)
                    matrix[i][j] += Math.min(matrix[i - 1][j], Math.min(matrix[i - 1][j - 1], matrix[i][j - 1]));
            }
        }

        int total = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                total += matrix[i][j];
            }
        }

        return total;
    }
}

class Solution2 {
    // Top-Down Approach 9.6% beats
    // Rec solution gives TLE 22/32 passed then use DP
    int[][] dp;

    public int countSquares(int[][] mat) {
        int result = 0;
        int n = mat.length;
        int m = mat[0].length;

        dp = new int[n + 1][m + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        // checking 1x1 matrix simple checking how many 1 are there
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    result += solve(i, j, n, m, mat, dp);
                }

            }
        }
        return result;
    }

    private int solve(int i, int j, int n, int m, int[][] mat, int[][] dp) {
        if (i >= n || j >= m || mat[i][j] == 0)
            return 0;

        if (dp[i][j] != -1)
            return dp[i][j];
        int right = solve(i + 1, j, n, m, mat, dp);
        int bottom = solve(i, j + 1, n, m, mat, dp);
        int diagonal = solve(i + 1, j + 1, n, m, mat, dp);
        return dp[i][j] = 1 + Math.min(right, Math.min(bottom, diagonal));
    }

}

class Solution3 {
    /**
     * Best Case:O(n×m), if all values are 0 (no squares to count).
     * Worst Case:if the matrix is mostly filled with 1s and includes larger
     * submatrices to check. O(n×m×min(n,m)
     */
    public int countSquares(int[][] mat) {
        int size = 1;
        int result = 0;
        int n = mat.length;
        int m = mat[0].length;

        // checking 1x1 matrix simple checking how many 1 are there
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    result++;
                }
            }
        }
        size = 2;
        while (size <= Math.max(m, n)) {
            result = result + checkSqaureMat(n, m, size, mat);
            size++;
        }
        return result;
    }

    private int checkSqaureMat(int n, int m, int size, int[][] mat) {
        int cnt = 0;
        for (int i = 0; i <= n - size; i++) {
            for (int j = 0; j <= m - size; j++) {
                boolean isSquare = true;

                for (int x = i; x < i + size; x++) {
                    for (int y = j; y < j + size; y++) {
                        if (mat[x][y] != 1) {
                            isSquare = false;
                            break;
                        }
                    }
                    if (!isSquare)
                        break;
                }

                if (isSquare)
                    cnt++;
            }
        }

        return cnt;
    }
}