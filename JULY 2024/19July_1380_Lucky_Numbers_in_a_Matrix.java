import java.util.*;
class Solution {
    // TC:O(N X M ) SC:O(N)
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();

        for (int row[] : matrix) {
            int min = Integer.MAX_VALUE;
            for (int ele : row) {
                min = Math.min(min, ele);
            }
            set.add(min);
        }

        int n = matrix.length;
        int m = matrix[0].length;
        for (int j = 0; j < m; j++) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, matrix[i][j]);
            }
            if (set.contains(max)) {
                ans.add(max);
            }
        }

        return ans;
    }
}