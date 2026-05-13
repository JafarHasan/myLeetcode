
import java.util.*;

class Solution {

    public boolean validPath(int n, int[][] edges, int source, int d) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            int src = e[0];
            int dest = e[1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }

        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        vis[source] = true;
        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == d) {
                return true;
            }
            for (int nbr : graph.get(curr)) {
                if (!vis[nbr]) {
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }
        }
        return false;

    }
}
