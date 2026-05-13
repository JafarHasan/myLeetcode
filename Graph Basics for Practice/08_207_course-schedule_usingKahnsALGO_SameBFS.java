
import java.util.*;

class Solution {

    public boolean canFinish(int num, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            graph.add(new ArrayList<>());
        }
        //build graph and indegree array
        int[] indeg = new int[num];
        for (int[] e : prerequisites) {
            int src = e[0];
            int dest = e[1];
            /// take course bi first if you want to take course ai.
            //b to a most Important
            graph.get(dest).add(src);
            indeg[src]++;
        }
        //check a cycle exists if yes false otherwise true
        //add all whose indegree in 0 in the q
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < num; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        int vis = 0;
        while (!q.isEmpty()) {
            int src = q.poll();
            vis++;
            for (int nbr : graph.get(src)) {
                indeg[nbr]--;
                if (indeg[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }
        return vis == num;

    }
}
