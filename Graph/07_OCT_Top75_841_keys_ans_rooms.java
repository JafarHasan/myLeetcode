package Graph;

import java.util.*;

class Solution {
    // TC:O(E+V) SC:O(N) 0ms beats 100%
    // we dont need to make graph instead rooms is also a representation of Graph
    // use it directly
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        boolean vis[] = new boolean[rooms.size()];
        // start from 0th room
        dfs(rooms, 0, vis);

        // check all room visited or not
        for (boolean flag : vis) {
            if (!flag)
                return false;
        }
        return true;
    }

    private void dfs(List<List<Integer>> graph, int src, boolean[] vis) {
        vis[src] = true;
        for (int nbr : graph.get(src)) {
            if (vis[nbr] == false) {
                dfs(graph, nbr, vis);
            }
        }
    }
}

class Solution2 {
    // TC:O(V+E) SC:O(N)
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        int n = rooms.size();
        // making graph and edges
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>(rooms.get(i)));
        }

        boolean vis[] = new boolean[n];
        // start from 0th room
        dfs(graph, 0, n, vis);
        for (boolean flag : vis) {
            if (!flag)
                return false;
        }
        return true;
    }

    private void dfs(ArrayList<ArrayList<Integer>> graph, int src, int n, boolean[] vis) {
        vis[src] = true;
        for (int nbr : graph.get(src)) {
            if (vis[nbr] == false) {
                dfs(graph, nbr, n, vis);
            }
        }
    }
}