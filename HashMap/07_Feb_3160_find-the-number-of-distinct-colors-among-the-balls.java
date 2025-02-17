
import java.util.*;

class Solution {

    // TC:O(N) SC:O(N)
    public int[] queryResults(int limit, int[][] queries) {
        int n = queries.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[n];
        Map<Integer, Integer> ballMap = new HashMap<>();

        int idx = 0;
        for (int[] row : queries) {
            int ball = row[0];
            int color = row[1];
            // if curr ball is already color
            if (ballMap.containsKey(ball)) {
                // find its previous color
                int prev = ballMap.get(ball);
                // decrese its freq by 1 in map
                map.put(prev, map.get(prev) - 1);
                // if color freq is 0 remove its from map
                if (map.get(prev) == 0) {
                    map.remove(prev);
                }

            }
            // if ball is not color
            // set its color
            ballMap.put(ball, color);
            // increase it or put it in map
            map.put(color, map.getOrDefault(color, 0) + 1);
            // size is the unique color we hv
            ans[idx++] = map.size();
        }
        return ans;
    }

    // MLE 547/551 passed TC:O(2xN) SC:O()
    public int[] queryResultsMLE(int limit, int[][] queries) {
        int n = queries.length;
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[n];
        int[] ballArr = new int[limit + 1];// This is extra space we are taking of those balls also which has not been
        // colored
        Arrays.fill(ballArr, -1);
        int idx = 0;
        for (int[] row : queries) {
            int ball = row[0];
            int color = row[1];
            // if curr ball is already color
            if (ballArr[ball] != -1) {
                // find its previous color
                int prev = ballArr[ball];
                // decrese its freq by 1 in map
                map.put(prev, map.get(prev) - 1);
                // if color freq is 0 remove its from map
                if (map.get(prev) == 0) {
                    map.remove(prev);
                }

            }
            // if ball is not color
            // set its color
            ballArr[ball] = color;
            // increase it or put it in map
            map.put(color, map.getOrDefault(color, 0) + 1);
            // size is the unique color we hv
            ans[idx++] = map.size();
        }
        return ans;
    }
}
