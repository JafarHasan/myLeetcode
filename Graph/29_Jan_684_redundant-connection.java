
import java.util.*;

class Solution {

    // TC:O(N^2) SC:O(N)
    public int[] findRedundantConnection(int[][] edges) {
        // define a graph
        int n = edges.length;
        List<List<Integer>> graph = new ArrayList<>();// SC:O(N*2)

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        // make edges graph
        for (int e[] : edges) {// O(N)
            int src = e[0] - 1;
            int dest = e[1] - 1;

            // check if curr src and dest already present in graph
            // ans if i can reach from src to dest
            // then its a redudent edge
            boolean vis[] = new boolean[n];// SC:O(N)
            if (dfs(graph, src, dest, vis)) {// O(N)
                // return ans
                return e;
            }
            /// otherwise its a useful edges addit to grapg
            graph.get(src).add(dest);
            graph.get(dest).add(src);
        }
        return new int[]{};

    }

    //
    private boolean dfs(List<List<Integer>> graph, int src, int dest, boolean[] vis) {

        if (src == dest) {
            return true;
        }

        // mark it visited
        vis[src] = true;

        /// check in nbr can we reach
        for (int nbr : graph.get(src)) {
            if (!vis[nbr]) {

                if (dfs(graph, nbr, dest, vis)) {
                    return true;
                }
            }
        }
        return false;
    }
}
