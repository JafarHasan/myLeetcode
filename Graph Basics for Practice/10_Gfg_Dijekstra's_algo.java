
import java.util.*;

class Solution {

    //Time: O((V + E) log V) Space: O(V + E)
    public int[] dijkstra(int V, int[][] edges, int src) {
        // code here
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            int u = e[0], v = e[1], wt = e[2];
            graph.get(u).add(new int[]{v, wt});
            graph.get(v).add(new int[]{u, wt});

        }
        //[wt,dest]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int result[] = new int[V];
        Arrays.fill(result, Integer.MAX_VALUE);
        pq.add(new int[]{0, src});//src to src 0 wt

        //mark source to source wt 0 in ansArray
        result[src] = 0;
        while (!pq.isEmpty()) {
            //take Curr{wt and Nbr Node}
            int currWt = pq.peek()[0];
            int currNode = pq.peek()[1];
            pq.poll();

            if (currWt > result[currNode]) {
                continue;
            }

            //traverse Nbr of curr Node
            for (int currNbr[] : graph.get(currNode)) {
                int nbr = currNbr[0];
                int newWt = currNbr[1];

                if (currWt + newWt < result[nbr]) {
                    result[nbr] = currWt + newWt;
                    pq.add(new int[]{currWt + newWt, nbr});
                }
            }
        }
        return result;
    }
}
