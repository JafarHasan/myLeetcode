
import java.util.*;

class GFG {

    static ArrayList<Integer> topoSort(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Compute indegrees
        for (int i = 0; i < n; i++) {
            for (int next : adj.get(i)) {
                indegree[next]++;
            }
        }

        // Add all nodes with indegree 0 
        // into the queue
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // Kahn’s Algorithm (BFS)
        while (!q.isEmpty()) {
            int top = q.poll();
            result.add(top);
            for (int next : adj.get(top)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        return result;
    }

}
