import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    // TC:(ElogV) SC:O(N) E=no of edges V=no of Vertices
    // to go node to node itself probablity=100% i e =1
    class Pair implements Comparable<Pair> {
        int dest;
        double prob;

        Pair(int d, double p) {
            this.dest = d;
            this.prob = p;
        }

        public int compareTo(Pair p) {
            return Double.compare(p.prob, this.prob);
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // max heap
        PriorityQueue<Pair> pq = new PriorityQueue();
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int k = 0;

        // making graph
        for (int[] row : edges) {
            int src = row[0];
            int dest = row[1];
            double prob = succProb[k++];

            graph.get(src).add(new Pair(dest, prob));
            graph.get(dest).add(new Pair(src, prob));

        }

        double result[] = new double[n];
        result[start_node] = 1;// to go node to node itself probablity=100% i e =1
        pq.add(new Pair(start_node, 1.0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int currNode = p.dest;
            double currProb = p.prob;

            for (Pair nbr : graph.get(currNode)) {
                int nbrDest = nbr.dest;
                double nbrProb = nbr.prob;
                if (result[nbrDest] < currProb * nbrProb) {
                    result[nbrDest] = currProb * nbrProb;
                    pq.add(new Pair(nbrDest, result[nbrDest]));
                }
            }

        }

        return result[end_node];

    }
}