
import java.util.*;

class Solution {

    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        // code here
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        int n = adj.size();
        boolean[] vis = new boolean[n];
        q.add(0);
        vis[0] = true;
        while (!q.isEmpty()) {
            int src = q.poll();
            ans.add(src);
            for (int nbr : adj.get(src)) {
                if (!vis[nbr]) {
                    vis[nbr] = true;
                    q.add(nbr);
                }
            }

        }
        return ans;
    }
}
