import java.util.*;

class Solution {
    // SC;O(N) TC:O(N)
    public int findTheCity2(int n, int[][] edges, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList());
        }
        // making weighted undirected graph
        for (int row[] : edges) {
            int src = row[0];
            int dest = row[1];
            int wt = row[2];

            graph.get(src).add(new int[] { dest, wt });
            graph.get(dest).add(new int[] { src, wt });

        }
        int min = Integer.MAX_VALUE;
        int res = -1;
        // calling dijkstra for each node
        for (int i = 0; i < n; i++) {// for node->0 1 2 3 and so on
            Queue<int[]> pq = new PriorityQueue<>((a, b) -> (Integer.compare(a[1], b[1])));
            boolean[] vis = new boolean[n];
            int cnt = 0;
            pq.add(new int[] { i, 0 });

            while (pq.size() != 0) {
                int[] curr = pq.poll();
                int currNode = curr[0];
                int currDis = curr[1];

                if (vis[currNode]) {
                    continue;
                }
                vis[currNode] = true;
                cnt++;
                for (int currRow[] : graph.get(currNode)) {
                    int nbr = currRow[0];
                    int nbrDis = currRow[1];
                    if (vis[nbr] == false && currDis + nbrDis <= k) {
                        pq.add(new int[] { nbr, currDis + nbrDis });
                    }
                }

                if (cnt - 1 <= min) {
                    min = cnt - 1;
                    res = i;
                }
            }

        }
        return res;
    }

    public int findTheCity(int n, int[][] edges, int k) {
        // Create graph
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges to the graph
        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];
            int wt = edge[2];

            graph.get(src).add(new int[] { dest, wt });
            graph.get(dest).add(new int[] { src, wt });
        }

        int minReachable = Integer.MAX_VALUE;
        int resultCity = -1;

        // Run Dijkstra's algorithm for each city
        for (int startCity = 0; startCity < n; startCity++) {
            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
            int[] dist = new int[n];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[startCity] = 0;

            pq.add(new int[] { startCity, 0 });

            while (!pq.isEmpty()) {
                int[] curr = pq.poll();
                int currNode = curr[0];
                int currDist = curr[1];

                if (currDist > dist[currNode]) {
                    continue;
                }

                for (int[] neighbor : graph.get(currNode)) {
                    int nbr = neighbor[0];
                    int edgeWeight = neighbor[1];

                    if (currDist + edgeWeight < dist[nbr]) {
                        dist[nbr] = currDist + edgeWeight;
                        pq.add(new int[] { nbr, dist[nbr] });
                    }
                }
            }

            // Count cities reachable within distance k
            int count = 0;
            for (int d : dist) {
                if (d <= k) {
                    count++;
                }
            }

            // Update result city
            if (count <= minReachable) {
                minReachable = count;
                resultCity = startCity;
            }
        }

        return resultCity;
    }

}