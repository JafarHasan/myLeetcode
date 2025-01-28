
import java.util.*;

class Solution {
    ///Like Rotten Oranges
    //TC:O(NxM) SC:O(NxM)
    public int[][] highestPeak(int[][] isWater) {
        int n = isWater.length;
        int m = isWater[0].length;
        int[][] height = new int[n][m];
        for (int[] row : height) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> q = new LinkedList<>();
        // fill water cell height with 0
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isWater[i][j] == 1) {
                    height[i][j] = 0;
                    // this is the sourse for multisourse BFS also
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        // apply multisourse
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int[] curr = q.poll();
                int currR = curr[0];
                int currC = curr[1];

                for (int[] d : dir) {
                    int i = currR + d[0];
                    int j = currC + d[1];

                    if (i >= 0 && i < n && j >= 0 && j < m && height[i][j] == -1) {
                        height[i][j] = height[currR][currC] + 1;
                        q.offer(new int[]{i, j});
                    }
                }
            }
        }
        return height;
    }
}
