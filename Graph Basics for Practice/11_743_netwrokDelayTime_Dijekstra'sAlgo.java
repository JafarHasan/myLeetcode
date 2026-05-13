
import java.util.*;

class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] t : times) {
            int u = t[0] - 1, v = t[1] - 1, wt = t[2];
            graph.get(u).add(new int[]{v, wt});
            // graph.get(v).add(new int[] { u, wt });
        }
        int[] result = new int[n];
        Arrays.fill(result, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.add(new int[]{0, k - 1});
        result[k - 1] = 0;

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int wt = top[0];
            int node = top[1];

            if (wt > result[node]) {
                continue;
            }

            for (int[] nextNbr : graph.get(node)) {
                int currWt = nextNbr[1];
                int nbr = nextNbr[0];

                if (wt + currWt < result[nbr]) {
                    result[nbr] = wt + currWt;
                    pq.add(new int[]{result[nbr], nbr});
                }
            }

        }

        int time = -1;
        for (int r : result) {
            if (r == Integer.MAX_VALUE) {
                return -1;
            }
            time = Math.max(time, r);
        }
        return time;
    }
}
