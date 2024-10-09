package Graph;

import java.util.*;

class Solution {
    // TC:O(N) SC:O(N)
    public int minReorder(int n, int[][] conn) {
        /// making graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] row : conn) {
            int src = row[0];
            int dest = row[1];

            // Add both directions: (destination, needs reordering) and (source, no
            // reordering)
            graph.get(src).add(new int[] { dest, 1 });
            graph.get(dest).add(new int[] { src, 0 });

        }
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];

        q.add(0);// starting from 0 vertexx
        int change = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            vis[curr] = true;
            for (int[] nbr : graph.get(curr)) {
                int dest = nbr[0];
                int cnt = nbr[1];
                if (vis[dest] == false) {
                    vis[dest] = true;
                    q.add(dest);
                    change += cnt;
                }
            }
        }
        return change;
    }
}