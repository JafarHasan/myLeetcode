
import java.util.*;

/*  USING HASHMAP
class Graph {

    Map<Integer, List<Integer>> map;

    Graph() {
        map = new HashMap<>();
    }

    public void addEdge(int src, int dest) {
        map.computeIfAbsent(src, k -> new ArrayList<>()).add(dest);
        map.computeIfAbsent(dest, k -> new ArrayList<>()).add(src); // Undirected graph
    }

    public void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> vis = new HashSet<>();
        q.add(start);
        vis.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");
            for (int nbr : map.get(curr)) {
                if (!vis.contains(nbr)) {
                    vis.add(nbr);
                    q.add(nbr);
                }
            }
        }
    }

    public void dfs(int start) {
        Set<Integer> vis = new HashSet<>();
        dfsUtil(start, vis);

    }

    public void dfsUtil(int start, Set<Integer> vis) {
        vis.add(start);
        System.out.print(start + " ");

        for (int nbr : map.get(start)) {
            if (!vis.contains(nbr)) {
                dfsUtil(nbr, vis);
            }
        }

    }
}

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph();
        g.addEdge(1, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(3, 5);
        g.addEdge(3, 6);
        g.addEdge(5, 6);
        g.addEdge(6, 4);
        g.addEdge(1, 1); // optional
        // System.out.println("Graph: " + g.map);
        System.out.println("BFS: ");
        g.bfs(1);
        System.out.println("DFS:");

        g.dfs(1);
    }
}
 */
 /*
 
//USING ADJACENCY 2D MATRIX

class Graph {

    int n;
    int[][] graph;

    Graph(int n) {
        this.n = n;
        graph = new int[n + 1][n + 1];
    }

    public void addEdge(int i, int j) {
        graph[i][j] = 1;
        //if undirected
        // graph[j][i]=1;
    }

    public void BFS(int start) {
        Set<Integer> vis = new HashSet<>();
        Queue<Integer> q = new LinkedList();
        q.add(start);
        vis.add(start);

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int i = 0; i <= n; i++) {
                if (graph[curr][i] == 1 && !vis.contains(i)) {
                    vis.add(i);
                    q.add(i);

                }
            }

        }

    }

    public void DFS(int start) {
        Set<Integer> vis = new HashSet<>();
        DFSUtil(start, vis);
    }

    private void DFSUtil(int start, Set<Integer> vis) {
        vis.add(start);
        System.out.print(start + " ");

        for (int nbr = 0; nbr <= n; nbr++) {
            if (!vis.contains(nbr) && graph[start][nbr] == 1) {
                DFSUtil(nbr, vis);
            }
        }
    }

}

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(1, 2);
        g.addEdge(1, 6);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(6, 5);
        System.out.println("BFS");
        g.BFS(1);
        System.out.println("DFS");
        g.DFS(1);
    }
}
 */
//USING LIST OF LIST
class Graph {

    int size;
    List<List<Integer>> graph;

    Graph(int n) {
        this.size = n;
        graph = new ArrayList<>();
        for (int i = 0; i <= size; i++) {
            graph.add(new ArrayList<>());
        }
    }

    // public void buildGraph() {
    //     for (int i = 0; i < size; i++) {
    //         graph.add(new ArrayList<>());
    //     }
    // }
    public void addEdge(int src, int dest) {
        graph.get(src).add(dest);
    }

    public void dfs(int src) {
        Set<Integer> vis = new HashSet<>();
        dfsHelper(src, vis);
    }

    public void dfsHelper(int src, Set<Integer> vis) {
        vis.add(src);
        System.out.print(src + " ");

        for (int nbr : graph.get(src)) {
            if (!vis.contains(nbr)) {
                dfsHelper(nbr, vis);
            }
        }
    }

    public void BFS(int src) {
        Queue<Integer> q = new LinkedList();
        Set<Integer> vis = new HashSet<>();
        q.add(src);
        vis.add(src);

        while (!q.isEmpty()) {
            int curr = q.poll();
            System.out.print(curr + " ");

            for (int nbr : graph.get(curr)) {
                if (!vis.contains(nbr)) {
                    vis.add(nbr);
                    q.add(nbr);
                }
            }
        }
    }

}

public class Main {

    public static void main(String[] args) {
        Graph g = new Graph(6);
        g.addEdge(1, 2);
        g.addEdge(1, 6);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(6, 5);
        System.out.println("BFS");
        g.BFS(1);
        System.out.println("DFS");
        g.dfs(1);
    }
}
