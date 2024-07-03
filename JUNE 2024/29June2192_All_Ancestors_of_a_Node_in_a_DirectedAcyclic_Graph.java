import java.util.*;
import java.util.ArrayList;

class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {// O(N)
            graph.add(new ArrayList());
        }

        for (int[] edge : edges) { // O(E)
            int src = edge[0];
            int dest = edge[1];
            graph.get(dest).add(src);
        }

        for (int i = 0; i < n; i++) {// O(N)
            List<Integer> temp = new ArrayList<>();
            boolean vis[] = new boolean[n];// visited array for mark visited nodes
            dfs(i, temp, graph, vis);
            Collections.sort(temp);
            ans.add(temp);
        }
        return ans;
    }

    private void dfs(int src, List<Integer> temp, ArrayList<ArrayList<Integer>> graph, boolean[] vis) {
        vis[src] = true;
        for (int i = 0; i < graph.get(src).size(); i++) {
            int node = graph.get(src).get(i);
            if (!vis[node]) {
                temp.add(node);
                dfs(node, temp, graph, vis);
            }
        }

    }
}

// TC AND SC

/*
 * The time complexity and space complexity for this algorithm are as follows:
 * 
 * Time Complexity:
 * The time complexity of this algorithm is O(N^2 + E).
 * 
 * The first loop runs in O(N) time to initialize the graph.
 * The second loop runs in O(E) time to fill up the adjacency list with the
 * edges.
 * The third loop, which contains the DFS function, runs in O(N^2) time. This is
 * because
 * in the worst-case scenario, every node is connected to every other node, and
 * for each node,
 * we are performing a DFS, which in itself can take O(N) time in the worst
 * case. Also,
 * the sorting of each temp list takes O(NlogN) time. So in total, it’s O(N^2).
 * Space Complexity:
 * The space complexity of this algorithm is O(N + E).
 * 
 * The adjacency list graph can hold at most N+E elements, which gives O(N+E).
 * The visited array vis takes O(N) space.
 * The list ans can hold at most N lists, and each list can hold at most N
 * elements, which gives O(N^2).
 * 
 * But this is the output of our function, and some may argue that it should not
 * be included in the space complexity analysis.
 * So, the overall space complexity would be O(N+E) if we don’t count the space
 * used by the output, and O(N^2) if we do.
 */