import java.util.*;

class Solution {

    // O(K^2) SC:O(k^2)
    public int[] topoSort(int[][] edges, int n) {
        // making graph
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();// O(k^2)
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] row : edges) {
            int src = row[0];
            int dest = row[1];

            // directed graph from src to dest
            graph.get(src).add(dest);
        }

        int vis[] = new int[n + 1];// node values is 1 2 ...n
        ArrayList<Integer> order = new ArrayList<>();
        Stack<Integer> st = new Stack<>();// src->dest
        boolean[] cycle = { false }; // Array to track cycle
        for (int i = 1; i <= n; i++) {
            if (vis[i] == 0) {// not visited
                dfs(i, vis, graph, st, cycle);
                if (cycle[0] == true) {
                    return new int[] {};
                }
            }
        }
        while (!st.isEmpty()) {
            order.add(st.pop());
        }
        int orderA[] = new int[order.size()];
        for (int i = 0; i < order.size(); i++) {
            orderA[i] = order.get(i);
        }
        return orderA;

    }

    public void dfs(int src, int[] vis, ArrayList<ArrayList<Integer>> graph, Stack<Integer> st, boolean[] cycle) {
        vis[src] = 1;// marked visited
        for (int nbr : graph.get(src)) {
            if (vis[nbr] == 0)// not visited
                dfs(nbr, vis, graph, st, cycle);
            else if (vis[nbr] == 1) {
                cycle[0] = true;
                return;
            }

        }
        vis[src] = 2;
        st.push(src);
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int ans[][] = new int[k][k];
        int topoRow[] = topoSort(rowConditions, k);// TC=SC=O(K)
        int topoCol[] = topoSort(colConditions, k);// TC=SC=O(K)

        if (topoRow.length == 0 || topoCol.length == 0) {
            // cycle found so we cant find topo order hence
            // cant make matrix
            return new int[][] {};
        }
        // TC:O(K^2)
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (topoRow[i] == topoCol[j])// element found
                    ans[i][j] = topoRow[i];// or topoCol[j]
            }
        }

        return ans;
    }
}