
class Solution {

    public int countNegatives(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            int left = 0, right = cols - 1;
            int firstNeg = cols; // default: no negatives

            while (left <= right) {
                int mid = left + (right - left) / 2;

                if (grid[i][mid] < 0) {
                    firstNeg = mid;
                    right = mid - 1; // move left
                } else {
                    left = mid + 1;
                }
            }

            count += cols - firstNeg;
        }

        return count;
    }
}

class Solution_BF2 {

    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] < 0) {
                    cnt += (m - j);
                    break;
                }
            }
        }
        return cnt;
    }
}

class Solution_Bf {

    public int countNegatives(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] < 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }
}
