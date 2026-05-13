
import java.util.*;



      08_207_course-schedule_usingKahnsALGO_SameBFSclass Solution {
    //Kahns Algo
    public int[] findOrder(int n, int[][] pre) {
        int[] order = new int[n];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] indegree = new int[n];
        for (int[] e : pre) {
            graph.get(e[1]).add(e[0]);
            indegree[e[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int idx = 0;
        while (!q.isEmpty()) {
            int src = q.poll();
            order[idx++] = src;
            for (int nbr : graph.get(src)) {
                indegree[nbr]--;
                if (indegree[nbr] == 0) {
                    q.add(nbr);
                }
            }
        }
        for (int i : indegree) {
            if (i != 0) {
                return new int[]{};
            }
        }
        return order;
    }
}
