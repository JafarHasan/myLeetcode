
import java.util.*;

class Solution {

    /// TOPOLOGICAL SORT Kahns Algo
    // TC:O(NxM) SC:O(NxM)
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] indegree = new int[n];
        // Making graph
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            g.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int itt : graph[i]) {
                g.get(itt).add(i); // reverse the direction of node
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        /// fill Queue with indegree 0 nodes
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }
        boolean isSafe[] = new boolean[n];
        // BFS
        while (!q.isEmpty()) {
            int curr = q.poll();
            isSafe[curr] = true;

            for (int nbr : g.get(curr)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.offer(nbr);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        // collect all safe nodes
        for (int i = 0; i < n; i++) {
            if (isSafe[i]) {
                ans.add(i);
            }
        }
        return ans;

    }
}
