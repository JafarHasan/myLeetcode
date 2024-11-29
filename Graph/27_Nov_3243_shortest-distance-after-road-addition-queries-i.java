import  java.util.*;
class Solution {
    //TC:O(N+Q*N) SC:O(V+E)
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        List<List<Integer>> graph=new ArrayList<>();
        ///0 to n-1 nodes if n=5 then 0->4 total 4 edges
        //0->1->2->3->4
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<=n-2;i++){
            int src=i;
            int dest=i+1;
            graph.get(src).add(dest);
        }
        int result[]=new int[queries.length];
        int idx=0;
        for(int query[]:queries){
            int u=query[0];
            int v=query[1];
            graph.get(u).add(v);//making queries given edges


            int d=bfs(n,graph);
            result[idx++]=d;
        }
        return result;




    }

    private int bfs(int n, List<List<Integer>> graph) {
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[n];
        q.add(0);
        vis[0] = true;
        int lvl = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int curr = q.poll();
                // if reached at last
                if (curr == n - 1) {
                    return lvl;
                }

                for (int nbr : graph.get(curr)) {
                    if (!vis[nbr]) {
                        q.add(nbr);
                        vis[nbr] = true;
                    }
                }
            }
            lvl++;
        }
        return -1;//nvr happend
    }
}