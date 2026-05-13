
import java.util.*;

class Solution {

    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> graph = new ArrayList<>();
        int n = edges.length;
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int src = e[0];
            int dest = e[1];
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        int[] vis = new int[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == 0 && dfs(graph, i, -1, vis)) {
                return true;
            }
        }
        return false;

    }

    private boolean dfs(List<List<Integer>> graph, int src, int parent, int[] vis) {
        vis[src] = 1;
        for (int nbr : graph.get(src)) {

            if (nbr == parent) {
                continue;
            }
            if (vis[nbr] == 1) {
                return true;
            }
            if (dfs(graph, nbr, src, vis)) {
                return true;
            }
        }
        return false;
    }
}
