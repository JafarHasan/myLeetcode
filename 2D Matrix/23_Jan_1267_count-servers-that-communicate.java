
class Solution {

    // TC:O(NxM) BF approch
    // SC:O(N+M)
    // Count server in each row
    // count server in each sol
    public int countServers(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int rowCnt[] = new int[n];
        int colCnt[] = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // count server in each row amd col to keep cnt
                if (grid[i][j] == 1) {
                    rowCnt[i] += 1;
                    colCnt[j] += 1;
                }
            }
        }
        int totalServer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // if a server found in curr i,j, check is there any server means cnt>1 in row
                // or col
                if (grid[i][j] == 1 && (rowCnt[i] > 1 || colCnt[j] > 1)) {
                    totalServer += 1;

                }
            }
        }
        return totalServer;

    }
}

class Solution1 {

    // TC:O(NxM)*(N+M) BF approch
    // Count total server -cnt server which cant communicate
    private boolean canCommunicate(int row, int col, int n, int m, int[][] grid) {
        // check in row is there any server
        for (int i = 0; i < m; i++) {
            // excluding the same col val(1)
            if (i != col && grid[row][i] == 1) {
                return true;
            }
        }
        // check for column
        for (int i = 0; i < n; i++) {
            // excluding the same row val(1)
            if (i != row && grid[i][col] == 1) {
                return true;
            }
        }
        return false;
    }

    public int countServers(int[][] grid) {
        int totalServer = 0;
        int cantCommunicate = 0;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // count server that cant commumnicate with anyone
                if (grid[i][j] == 1) {
                    if (!canCommunicate(i, j, n, m, grid)) {
                        cantCommunicate++;
                    }
                    totalServer++;
                }
            }
        }
        return totalServer - cantCommunicate;

    }
}
