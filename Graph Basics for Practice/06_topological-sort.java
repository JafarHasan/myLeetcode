
import java.util.*;

class Solution {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            graph.get(e[0]).add(e[1]);
        }

        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(graph, i, vis, st);
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!st.isEmpty()) {
            list.add(st.pop());
        }
        return list;
    }

    private void dfs(List<List<Integer>> graph, int src, boolean[] vis, Stack<Integer> st) {
        vis[src] = true;
        for (int nbr : graph.get(src)) {
            if (!vis[nbr]) {
                dfs(graph, nbr, vis, st);
            }
        }
        st.push(src);
    }
}
