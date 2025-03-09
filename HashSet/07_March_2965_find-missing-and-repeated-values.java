
import java.util.*;

class Solution {

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int ans[] = new int[2];
        boolean map[] = new boolean[n * n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curr = grid[i][j];
                if (map[curr] == true) {
                    ans[0] = curr;
                }
                map[curr] = true;
            }
        }

        for (int i = 1; i <= Math.pow(n, 2); i++) {
            if (!map[i]) {
                ans[1] = i;
                break;
            }
        }
        return ans;
    }

    // TC:O(N^2) SC:O(N^2)
    public int[] findMissingAndRepeatedValues_UsingHasSet(int[][] grid) {
        int n = grid.length;
        HashSet<Integer> set = new HashSet<>();
        int dup = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int curr = grid[i][j];
                if (set.contains(curr)) {
                    dup = curr;
                }
                set.add(curr);
            }
        }
        int miss = 1;
        for (int i = 1; i <= Math.pow(n, 2); i++) {
            if (!set.contains(i)) {
                return new int[]{dup, i};

            }
        }
        return new int[]{dup, miss};

    }
}
