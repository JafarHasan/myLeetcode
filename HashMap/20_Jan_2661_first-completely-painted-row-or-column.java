
import java.util.*;

class Solution {

    // TC:O(N*M + len x N+M) SC:O(NxM)
    private boolean isRowFullyPainted(int[] row) {
        for (int ele : row) {
            if (ele != -1) {
                return false;
            }
        }
        return true;
    }

    private boolean isColFullyPainted(int[][] mat, int col) {
        for (int row[] : mat) {
            if (row[col] != -1) {
                return false;
            }
        }
        return true;
    }

    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int len = arr.length;
        // storing each element with their cordinates(i,j)
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                map.put(mat[i][j], new int[]{i, j});
            }
        }

        for (int i = 0; i < len; i++) {
            int curr[] = map.get(arr[i]);
            int row = curr[0];
            int col = curr[1];
            // mark curr row, col as painted -1
            mat[row][col] = -1;
            /// check if any row or col fully painted
            // access row and col and check
            if (isRowFullyPainted(mat[row]) || (isColFullyPainted(mat, col))) {
                return i;
            }

        }
        return -1;

    }
}
