package Graph;

import java.util.*;

class Solution {
    // TC:O(V+E) SC:O(N)
    public int findCircleNum(int[][] isConnected) {
        // make graph
        int n = isConnected.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // make edges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }
        // check how many time new DFS traverse the Graph=number-of-provinces
        boolean vis[] = new boolean[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] == false) {
                dfs(graph, vis, i);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(List<List<Integer>> graph, boolean[] vis, int src) {
        vis[src] = true;
        for (int nbr : graph.get(src)) {
            if (vis[nbr] == false) {
                dfs(graph, vis, nbr);
            }
        }
    }
}