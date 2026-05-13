
import java.util.*;

class Solution {

    //fast
    public int countCoveredBuildings(int n, int[][] buildings) {

        int[] rMax = new int[n + 1];
        int[] rMin = new int[n + 1];
        int[] cMax = new int[n + 1];
        int[] cMin = new int[n + 1];

        Arrays.fill(rMin, n + 1);
        Arrays.fill(cMin, n + 1);

        for (int[] p : buildings) {
            int x = p[0], y = p[1];

            rMax[y] = Math.max(rMax[y], x);
            rMin[y] = Math.min(rMin[y], x);

            cMax[x] = Math.max(cMax[x], y);
            cMin[x] = Math.min(cMin[x], y);
        }

        int cnt = 0;

        for (int[] p : buildings) {
            int x = p[0], y = p[1];

            if (x > rMin[y] && x < rMax[y]
                    && y > cMin[x] && y < cMax[x]) {
                cnt++;
            }
        }

        return cnt;
    }
}

class Solution_Map {

    public int countCoveredBuildings(int n, int[][] buildings) {

        HashMap<Integer, int[]> map1 = new HashMap<>(); // x -> [minY, maxY]
        HashMap<Integer, int[]> map2 = new HashMap<>(); // y -> [minX, maxX]

        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            // For map1: group by x
            if (!map1.containsKey(x)) {
                map1.put(x, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            }
            int curr1[] = map1.get(x);
            map1.put(x, new int[]{
                Math.min(curr1[0], y),
                Math.max(curr1[1], y)
            });

            // For map2: group by y
            if (!map2.containsKey(y)) {
                map2.put(y, new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE});
            }
            int curr2[] = map2.get(y);
            map2.put(y, new int[]{
                Math.min(curr2[0], x),
                Math.max(curr2[1], x)
            });
        }

        int ans = 0;
        for (int[] b : buildings) {
            int x = b[0];
            int y = b[1];

            int[] curr1 = map1.get(x); // For x: allowed Y range
            int[] curr2 = map2.get(y); // For y: allowed X range

            // Strictly inside (not endpoints)
            if (curr1[0] < y && y < curr1[1]
                    && curr2[0] < x && x < curr2[1]) {
                ans++;
            }
        }

        return ans;
    }
}
